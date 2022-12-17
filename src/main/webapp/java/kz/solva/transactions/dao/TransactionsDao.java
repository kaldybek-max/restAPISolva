package kz.solva.transactions.dao;

import kz.solva.transactions.entity.Transactions;

import java.util.List;

public interface TransactionsDao {

    public void saveTransactions(Transactions transactions);
}
