package com.kulabuha.Exceptions;

public class NotEnoughMoneyException extends Exception {

    String exceptionMessage;

    @Override
    public String toString() {
        return exceptionMessage;
    }

    public NotEnoughMoneyException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
