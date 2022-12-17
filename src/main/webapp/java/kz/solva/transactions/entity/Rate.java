package kz.solva.transactions.entity;


import javax.persistence.*;


@Entity
@Table(name = "rate_table")
public class Rate {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_time")
    private String dateTime;

    @Column(name = "close_rate")
    private String closeRate;

    @Column(name = "cur_date")
    private String curDate;

    public Rate() {
    }

    public Rate(int id, String dateTime, String closeRate, String curDate) {
        this.id = id;
        this.dateTime = dateTime;
        this.closeRate = closeRate;
        this.curDate = curDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getCloseRate() {
        return closeRate;
    }

    public void setCloseRate(String closeRate) {
        this.closeRate = closeRate;
    }

    public String getCurDate() {
        return curDate;
    }

    public void setCurDate(String curDate) {
        this.curDate = curDate;
    }
}
