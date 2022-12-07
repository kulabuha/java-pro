package com.kulabuha.interfaces;

import com.kulabuha.Exceptions.NotEnoughMoneyException;

public interface Bancomat {
    void getCash(long summa);
    void setCash(int nominal, long count);
    long getBalanceAmount();
    void setCassette(Cassette cassette);
    void removeCassette(Cassette cassette);
}
