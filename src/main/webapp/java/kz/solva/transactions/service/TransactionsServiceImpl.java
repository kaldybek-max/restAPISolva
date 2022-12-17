package kz.solva.transactions.service;

import kz.solva.transactions.dao.TransactionsDao;
import kz.solva.transactions.dao.TransactionsDaoImpl;
import kz.solva.transactions.entity.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    private TransactionsDao transactionsDao;


    @Override
    @Transactional
    public void saveTransactions(Transactions transactions) {
        transactionsDao.saveTransactions(transactions);
    }
}
