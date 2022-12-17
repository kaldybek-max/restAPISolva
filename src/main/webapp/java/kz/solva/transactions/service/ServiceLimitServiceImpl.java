package kz.solva.transactions.service;

import kz.solva.transactions.dao.ServiceLimitDao;
import kz.solva.transactions.entity.ServiceLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceLimitServiceImpl implements ServiceLimitService{

    @Autowired
    private ServiceLimitDao serviceLimitDao;

    @Override
    @Transactional
    public ServiceLimit getLimit(String accCode) {
        return serviceLimitDao.getLimit(accCode);
    }

    @Override
    @Transactional
    public void updateLimitSum(ServiceLimit serviceLimit) {
        serviceLimitDao.updateLimitSum(serviceLimit);
    }

    @Override
    @Transactional
    public void newLimitSum(String accCode, int limitSum) {
        serviceLimitDao.newLimitSum(accCode,limitSum);
    }


}
