package kz.solva.transactions.service;


import kz.solva.transactions.dao.RateDao;
import kz.solva.transactions.entity.Rate;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class RateServiceImpl implements RateService{

    @Autowired
    private RateDao rateDao;

    @Override
    public Rate getRate(LocalDate localDate) {
        return rateDao.getRate(localDate);
    }

    @Override
    @Transactional
    public void saveRate() {
        String url = "https://api.twelvedata.com/time_series?symbol=USD/KZT&interval=1day&apikey=4385ccc4473b4c5fa23193aed2b64307";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url,String.class);

        JSONObject jsonObj = new JSONObject(result);
        JSONArray jsonArray = jsonObj.getJSONArray("values");
        String closeRate = jsonArray.getJSONObject(0).getString("close");
        String dateTimeRate = jsonArray.getJSONObject(0).getString("datetime");
        String curDate = String.valueOf(java.time.LocalDate.now());
        Rate rate = new Rate();
        rate.setDateTime(dateTimeRate);
        rate.setCloseRate(closeRate);
        rate.setCurDate(curDate);

        System.out.println(dateTimeRate + " " + closeRate + " " + curDate);

        rateDao.saveRate(rate);
    }
}
