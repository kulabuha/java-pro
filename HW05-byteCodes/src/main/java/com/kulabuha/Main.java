package com.kulabuha;

public class Main {
    public static void main(String[] args) {
        TestLoggingInterface myClass = Ioc.createMyClass();
        myClass.calculation(6, "fdsf");
        myClass.calculation(6);
    }
}
