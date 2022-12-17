package kz.solva.transactions.entity;


import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "account_from")
    private String accountFrom;

    @Column(name = "account_to")
    private String accountTo;

    @Column(name = "val_code")
    private String valCode;

    @Column(name = "sum")
    private float sum;

    @Column(name = "expense_category")
    private String expenceCategory;

    @Column(name = "datetime")
    private String dateTime;

    public Transactions(String accountFrom, String accountTo, String valCode, float sum, String expenceCategory, String dateTime) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.valCode = valCode;
        this.sum = sum;
        this.expenceCategory = expenceCategory;
        this.dateTime = dateTime;
    }

    public Transactions() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(String accountFrom) {
        this.accountFrom = accountFrom;
    }

    public String getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(String accountTo) {
        this.accountTo = accountTo;
    }

    public String getValCode() {
        return valCode;
    }

    public void setValCode(String valCode) {
        this.valCode = valCode;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public String getExpenceCategory() {
        return expenceCategory;
    }

    public void setExpenceCategory(String expenceCategory) {
        this.expenceCategory = expenceCategory;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
