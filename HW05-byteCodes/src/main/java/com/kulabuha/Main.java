package com.kulabuha;

public class Main {
    public static void main(String[] args) {
        TestLoggingInterface myClass = Ioc.createMyClass(new TestLogging());
        myClass.calculation(6, "fdsf");
        myClass.calculation(6);
    }
}
