package kz.solva.transactions.dao;

import kz.solva.transactions.entity.ProductLimit;
import kz.solva.transactions.entity.ServiceLimit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceLimitDaoImpl implements ServiceLimitDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ServiceLimit getLimit(String accCode) {
        Session session = sessionFactory.getCurrentSession();
        Query<ServiceLimit> query = session.createQuery("from ServiceLimit " +
                "where accCode =: accCode");
        query.setParameter("accCode",accCode);
        List<ServiceLimit> list = query.list();
        ServiceLimit serviceLimit = list.get(0);
        return serviceLimit;
    }

    @Override
    public void updateLimitSum(ServiceLimit serviceLimit) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(serviceLimit);
    }

    @Override
    public void newLimitSum(String accCode, int limitSum) {
        Session session = sessionFactory.getCurrentSession();
        ServiceLimit serviceLimit = getLimit(accCode);
        serviceLimit.setLimitSum(limitSum);
        session.saveOrUpdate(serviceLimit);
    }
}
