package kz.solva.transactions.dao;

import kz.solva.transactions.entity.ProductLimit;

public interface ProductLimitDao {
    public ProductLimit getLimit(String accCode);

    public void updateLimitSum(ProductLimit productLimit);

    public void newLimitSum(String accCode, int limitSum);
}
