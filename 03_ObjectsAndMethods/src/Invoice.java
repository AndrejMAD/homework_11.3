import java.util.Date;

public class Invoice {

    private int number;
    private Date date;
    private String organization;
    private String contractor;
    private String products;
    private double totalSumm;

    public Invoice(int number, Date date) {
        this.number = number;
        this.date = date;
    }

    public Invoice(int number, Date date, String organization, String contractor, String products, double totalSumm) {
        this.number = number;
        this.date = date;
        this.organization = organization;
        this.contractor = contractor;
        this.products = products;
        this.totalSumm = totalSumm;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public double getTotalSumm() {
        return totalSumm;
    }

    public void setTotalSumm(double totalSumm) {
        this.totalSumm = totalSumm;
    }
}
