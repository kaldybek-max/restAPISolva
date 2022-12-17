package kz.solva.transactions.service;

import kz.solva.transactions.entity.ProductLimit;
import kz.solva.transactions.entity.ServiceLimit;

public interface ServiceLimitService {
    public ServiceLimit getLimit(String accCode);

    public void updateLimitSum(ServiceLimit serviceLimit);

    public void newLimitSum(String accCode, int limitSum);
}
