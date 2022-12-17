package kz.solva.transactions.dao;

import kz.solva.transactions.entity.Rate;
import kz.solva.transactions.service.RateService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RateDaoImpl implements RateDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private RateService rateService;

    @Override
    public Rate getRate(LocalDate localDate) {
        Session session = sessionFactory.getCurrentSession();

        if(!localDate.getDayOfWeek().toString().equals("SATURDAY")) {
            Query<Rate> rateQuery = session.createQuery("from Rate " +
                    "where curDate =: localDate");
            rateQuery.setParameter("localDate", localDate);
            try {
                List<Rate> rateList = rateQuery.list();
                Rate rate = rateList.get(0);
                return rate;
            } catch (Exception ex) {
                rateService.saveRate();
                List<Rate> rateList = rateQuery.list();
                Rate rate = rateList.get(0);
                return rate;
            }
        }else{
            Query<Rate> rateQuery = session.createQuery("from Rate " +
                    "where id = (select max(id) from Rate)");
            List<Rate> rateList = rateQuery.list();
            Rate rate = rateList.get(0);
            return rate;
        }
    }

    @Override
    public void saveRate(Rate rate) {
        Session session = sessionFactory.getCurrentSession();
        session.save(rate);
    }
}
