package kz.solva.transactions.controller;


import kz.solva.transactions.entity.Transactions;
import kz.solva.transactions.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solva/api")
public class TransactionController {

    @Autowired
    private TransactionsService transactionsService;


    @PostMapping("/transaction")
    public Transactions saveTransactions(@RequestBody Transactions transactions){
        transactionsService.saveTransactions(transactions);
        return transactions;
    }
}
