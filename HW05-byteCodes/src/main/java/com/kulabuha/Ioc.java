package com.kulabuha;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Ioc {

    private Ioc() {
    }

    static <T extends TestLoggingInterface> TestLoggingInterface createMyClass(T t) {
        InvocationHandler handler = new DemoInvocationHandler(t);
        return (TestLoggingInterface) Proxy.newProxyInstance(Ioc.class.getClassLoader(),
                new Class<?>[]{TestLoggingInterface.class}, handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final TestLoggingInterface myClass;
        private final List<Method> methods;

        DemoInvocationHandler(TestLoggingInterface myClass) {
            this.myClass = myClass;
            this.methods = Arrays.stream(myClass.getClass().getMethods())
                    .filter(method -> method.isAnnotationPresent(Log.class)).toList();
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            List<Method> testMethod = methods.stream()
                    .filter(m -> Objects.equals(m.getName(), method.getName()))
                    .filter(m -> Arrays.equals(m.getParameterTypes(), method.getParameterTypes()))
                    .toList();
            if (!testMethod.isEmpty()) {
                System.out.println("executed method: " + method.getName() + ", param: " + Arrays.toString(args));
            }
            return method.invoke(myClass, args);
        }
    }
}
