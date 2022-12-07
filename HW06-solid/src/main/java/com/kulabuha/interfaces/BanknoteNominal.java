package com.kulabuha.interfaces;

public enum BanknoteNominal {
    Hundred(100),
    TwoHundred(200),
    FiveHundred(500),
    Thousand(1000),
    TwoThousand(2000),
    FiveThousand(5000);

    private int nominal;

    public int getNominal() {
        return nominal;
    }

    BanknoteNominal(int nominal) {
        this.nominal = nominal;
    }
}
