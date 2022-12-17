package kz.solva.transactions.service;

import kz.solva.transactions.dao.ProductLimitDao;
import kz.solva.transactions.entity.ProductLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductLimitServiceImpl implements ProductLimitService{

    @Autowired
    private ProductLimitDao productLimitDao;

    @Override
    @Transactional
    public ProductLimit getLimit(String accCode) {
        return productLimitDao.getLimit(accCode);
    }

    @Override
    @Transactional
    public void updateLimitSum(ProductLimit productLimit) {
        productLimitDao.updateLimitSum(productLimit);
    }

    @Override
    @Transactional
    public void newLimitSum(String accCode, int limSum) {
        System.out.println(-1);
        productLimitDao.newLimitSum(accCode,limSum);
    }
}
