package kz.solva.transactions.dao;

import kz.solva.transactions.entity.Rate;

import java.time.LocalDate;

public interface RateDao {

    public Rate getRate(LocalDate localDate);
    public void saveRate(Rate rate);
}
