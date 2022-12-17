package kz.solva.transactions.service;

import kz.solva.transactions.entity.ProductLimit;

public interface ProductLimitService {
    public ProductLimit getLimit(String accCode);

    public void updateLimitSum(ProductLimit productLimit);

    public void newLimitSum(String accCode, int limSum);
}
