package kz.solva.transactions.controller;


import kz.solva.transactions.entity.ProductLimit;
import kz.solva.transactions.entity.ServiceLimit;
import kz.solva.transactions.service.ProductLimitService;
import kz.solva.transactions.service.ServiceLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solva/api/get_limit_sum")
public class LimitController {

    @Autowired
    private ProductLimitService productLimitService;

    @Autowired
    private ServiceLimitService serviceLimitService;

    @GetMapping("/for_product")
    public ProductLimit getLimitProduct(@RequestBody ProductLimit productLimit){
        return productLimitService.getLimit(productLimit.getAccCode());
    }

    @GetMapping("/for_service")
    public ServiceLimit getLimitService(@RequestBody ServiceLimit serviceLimit){
        return serviceLimitService.getLimit(serviceLimit.getAccCode());
    }

    @PutMapping("/product/new_lim")
    public void newProductLimitSum(@RequestBody ProductLimit productLimit){
        String accCode = productLimit.getAccCode();
        int limSum = (int) productLimit.getLimitSum();
        productLimitService.newLimitSum(accCode, limSum);
    }

    @PutMapping("/service/new_lim")
    public void newServiceLimitSum(@RequestBody ServiceLimit serviceLimit){
        String accCode = serviceLimit.getAccCode();
        int limSum = (int) serviceLimit.getLimitSum();
        serviceLimitService.newLimitSum(accCode, limSum);
    }
}
