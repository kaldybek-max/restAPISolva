package kz.solva.transactions.dao;


import kz.solva.transactions.entity.ProductLimit;
import kz.solva.transactions.entity.Transactions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ProductLimitDaoImpl implements ProductLimitDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ProductLimit getLimit(String accCode) {
        Session session = sessionFactory.getCurrentSession();
        Query<ProductLimit> query = session.createQuery("from ProductLimit " +
                "where accCode =: accCode");
        query.setParameter("accCode",accCode);
        List<ProductLimit> list = query.list();
        ProductLimit productLimit = list.get(0);
        return productLimit;
    }

    @Override
    public void updateLimitSum(ProductLimit productLimit) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(productLimit);
    }

    @Override
    public void newLimitSum(String accCode, int limitSum) {
        Session session = sessionFactory.getCurrentSession();
        ProductLimit productLimit = getLimit(accCode);
        productLimit.setLimitSum(limitSum);
        session.saveOrUpdate(productLimit);
    }
}
