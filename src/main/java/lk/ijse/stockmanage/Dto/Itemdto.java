package lk.ijse.stockmanage.Dto;

public class Itemdto {
    private String code;
    private String description;
    private double uPrice;
    private int qty;

    public Itemdto() {

    }
    public Itemdto(String code, String description, double unitPrice, int qtyOnHand) {
        this.code = code;
        this.description = description;
        this.uPrice = unitPrice;
        this.qty = qtyOnHand;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public double getuPrice() {
        return uPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setuPrice(double uPrice) {
        this.uPrice = uPrice;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Itemdto{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", uPrice=" + uPrice +
                ", qty=" + qty +
                '}';
    }
}
