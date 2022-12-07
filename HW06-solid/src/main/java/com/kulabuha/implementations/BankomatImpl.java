package com.kulabuha.implementations;

import com.kulabuha.Exceptions.NotEnoughMoneyException;
import com.kulabuha.interfaces.Bancomat;
import com.kulabuha.interfaces.Cassette;

import java.util.ArrayList;
import java.util.List;

public class BankomatImpl implements Bancomat {

    private long balanceAmount = 0;
    private List<Cassette> cassettePool = new ArrayList<>();

    @Override
    public void getCash(long summa) {
        try {
            if (summa > getBalanceAmount()) {
                throw new NotEnoughMoneyException("Недостаточно денег");
            }
            getBanknoteAlgorithm(summa);
            balanceAmount = getBalanceAmount() - summa;
        } catch (NotEnoughMoneyException e) {
            System.out.println(e);
        }
    }

    @Override
    public void setCash(int nominal, long count) {
        loadCassete(nominal, count);
        balanceAmount = getBalanceAmount() + nominal * count;
    }

    @Override
    public long getBalanceAmount() {
        return balanceAmount;
    }

    @Override
    public void setCassette(Cassette cassette) {
        cassettePool.add(cassette);
        balanceAmount += cassette.getBanknoteNominal() * cassette.getCountBanknote();
    }

    @Override
    public void removeCassette(Cassette cassette) {
        cassettePool.remove(cassette);
        balanceAmount -= cassette.getBanknoteNominal() * cassette.getCountBanknote();
    }

    private void loadCassete(int nominal, long count) {
        cassettePool.stream()
                .filter(cassette -> cassette.getBanknoteNominal() == nominal)
                .findAny()
                .ifPresent(cassetteForLoading -> cassetteForLoading.addBanknote(count));
        balanceAmount += nominal * count;
    }

    private void getBanknoteAlgorithm(long summa) {
        unloadCassete(summa);
    }
    private void unloadCassete(long summa) {
            cassettePool.stream()
                    .filter(cassette -> cassette.getCountBanknote() * cassette.getBanknoteNominal() >= summa)
            .findAny()
                .ifPresent(cassetteForUnloading -> cassetteForUnloading
            .getBanknote(summa/cassetteForUnloading.getBanknoteNominal()));
    }
}
