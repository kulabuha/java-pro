package com.kulabuha.implementations;

import com.kulabuha.interfaces.BanknoteNominal;
import com.kulabuha.interfaces.Cassette;

import java.util.Objects;

public class CassetteImpl implements Cassette {

    private final long index;
    private int banknoteNominal;
    private long countBanknote;

    public CassetteImpl(long index, BanknoteNominal nominal) {
        this.index = index;
        this.banknoteNominal = nominal.getNominal();
    }

    @Override
    public int getBanknoteNominal() {
        return banknoteNominal;
    }

    @Override
    public void setBanknoteNominal(int banknoteNominal) {
        this.banknoteNominal = banknoteNominal;
    }

    @Override
    public void addBanknote(long countBanknote) {
        this.countBanknote += countBanknote;
    }

    @Override
    public void getBanknote(long countBanknote) {
        this.countBanknote -= countBanknote;
    }

    @Override
    public long getCountBanknote() {
        return countBanknote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CassetteImpl cassette = (CassetteImpl) o;
        return index == cassette.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
