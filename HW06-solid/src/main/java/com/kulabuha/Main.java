package com.kulabuha;

import com.kulabuha.implementations.BankomatImpl;
import com.kulabuha.implementations.CassetteImpl;
import com.kulabuha.interfaces.Bancomat;
import com.kulabuha.interfaces.BanknoteNominal;
import com.kulabuha.interfaces.Cassette;

public class Main {
    public static void main(String[] args) {
        Bancomat bancomat = new BankomatImpl();
        Cassette cassette = new CassetteImpl(1, BanknoteNominal.Hundred);
        cassette.addBanknote(100);
        bancomat.setCassette(cassette);
        bancomat.getCash(200);
        bancomat.getCash(2000000);
        System.out.println(bancomat.getBalanceAmount());
    }
}
