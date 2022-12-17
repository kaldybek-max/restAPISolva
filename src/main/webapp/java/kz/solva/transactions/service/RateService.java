package kz.solva.transactions.service;

import kz.solva.transactions.entity.Rate;

import java.time.LocalDate;

public interface RateService {

    public Rate getRate(LocalDate localDate);
    public void saveRate();
}
