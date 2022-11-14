package com.kulabuha;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

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
        private final Class<?> classString;

        DemoInvocationHandler(TestLoggingInterface myClass) {
            this.myClass = myClass;
            this.classString = myClass.getClass();
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (classString.getMethod(method.getName(), method.getParameterTypes()).isAnnotationPresent(Log.class)) {
                System.out.println("executed method: " + method.getName() + ", param: " + Arrays.toString(args));
            }
            return method.invoke(myClass, args);
        }
    }
}
