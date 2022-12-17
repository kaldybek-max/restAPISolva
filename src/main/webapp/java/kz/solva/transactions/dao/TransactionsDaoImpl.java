package kz.solva.transactions.dao;

import kz.solva.transactions.entity.ProductLimit;
import kz.solva.transactions.entity.Rate;
import kz.solva.transactions.entity.ServiceLimit;
import kz.solva.transactions.entity.Transactions;
import kz.solva.transactions.service.ProductLimitService;
import kz.solva.transactions.service.RateService;
import kz.solva.transactions.service.ServiceLimitService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Repository
public class TransactionsDaoImpl implements TransactionsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ProductLimitService productLimitService;

    @Autowired
    private RateDao rateDao;

    @Autowired
    private ServiceLimitService serviceLimitService;


    @Override
    public void saveTransactions(Transactions transactions) {
        Session session = sessionFactory.getCurrentSession();
        String accountCode = transactions.getAccountFrom();
        String category = transactions.getExpenceCategory();
        LocalDate localDate = LocalDate.now();
        if(Objects.equals(category, "product")){

            ProductLimit productLimit = productLimitService.getLimit(accountCode);
            float productSum = productLimit.getLimitSum();
            Rate rate = rateDao.getRate(localDate);
            float rateVal = Float.valueOf(rate.getCloseRate());
            productSum = productSum * rateVal;

            if(productSum - transactions.getSum() < 0){
                int resSum = ((int) ((productSum - transactions.getSum())/rateVal));
                productLimit.setLimitSum(resSum);
                productLimit.setExcFl("1");
                productLimitService.updateLimitSum(productLimit);

            }else{
                int resSum = ((int) ((productSum - transactions.getSum())/rateVal));
                productLimit.setLimitSum(resSum);
                productLimitService.updateLimitSum(productLimit);
            }
        } else if (Objects.equals(category, "service")){
            ServiceLimit serviceLimit = serviceLimitService.getLimit(accountCode);
            float serviceSum = serviceLimit.getLimitSum();
            Rate rate = rateDao.getRate(localDate);
            float rateVal = Float.valueOf(rate.getCloseRate());
            serviceSum = serviceSum * rateVal;

            if(serviceSum - transactions.getSum() < 0){
                int resSum = ((int) ((serviceSum - transactions.getSum())/rateVal));
                serviceLimit.setLimitSum(resSum);
                serviceLimit.setExcFl("1");
                serviceLimitService.updateLimitSum(serviceLimit);

            }else{
                int resSum = ((int) ((serviceSum - transactions.getSum())/rateVal));
                serviceLimit.setLimitSum(resSum);
                serviceLimitService.updateLimitSum(serviceLimit);

            }
        }

        session.saveOrUpdate(transactions);
    }
}
