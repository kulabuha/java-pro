package com.kulabuha.interfaces;

public interface Cassette {
    int getBanknoteNominal();
    void setBanknoteNominal(int banknoteNominal);
    void addBanknote(long countBanknote);
    void getBanknote(long countBanknote);
    long getCountBanknote();
}
