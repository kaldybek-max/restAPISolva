package kz.solva.transactions.entity;


import javax.persistence.*;

@Entity
@Table(name = "service_limits")
public class ServiceLimit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "acc_code")
    private String accCode;

    @Column(name = "limit_sum")
    private int limitSum;

    @Column(name = "limit_datetime")
    private String limitDateTime;

    @Column(name = "val_code")
    private String val_code;

    @Column(name = "exc_fl")
    private String excFl;

    public ServiceLimit() {
    }

    public ServiceLimit(int id, String accCode, int limitSum, String limitDateTime, String val_code, String excFl) {
        this.id = id;
        this.accCode = accCode;
        this.limitSum = limitSum;
        this.limitDateTime = limitDateTime;
        this.val_code = val_code;
        this.excFl = excFl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccCode() {
        return accCode;
    }

    public void setAccCode(String accCode) {
        this.accCode = accCode;
    }

    public int getLimitSum() {
        return limitSum;
    }

    public void setLimitSum(int limitSum) {
        this.limitSum = limitSum;
    }

    public String getLimitDateTime() {
        return limitDateTime;
    }

    public void setLimitDateTime(String limitDateTime) {
        this.limitDateTime = limitDateTime;
    }

    public String getVal_code() {
        return val_code;
    }

    public void setVal_code(String val_code) {
        this.val_code = val_code;
    }

    public String getExcFl() {
        return excFl;
    }

    public void setExcFl(String excFl) {
        this.excFl = excFl;
    }
}
