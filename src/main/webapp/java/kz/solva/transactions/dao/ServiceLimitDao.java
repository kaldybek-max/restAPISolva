package kz.solva.transactions.dao;

import kz.solva.transactions.entity.ProductLimit;
import kz.solva.transactions.entity.ServiceLimit;
import kz.solva.transactions.service.ServiceLimitService;

public interface ServiceLimitDao {
    public ServiceLimit getLimit(String accCode);

    public void updateLimitSum(ServiceLimit serviceLimit);

    public void newLimitSum(String accCode, int limitSum);
}
