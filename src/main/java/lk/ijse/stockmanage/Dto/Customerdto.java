package lk.ijse.stockmanage.Dto;

public class Customerdto {
    private String id;
    private String name;
    private String address;
    private double salaray;

    public Customerdto(String id, String name, String address, double salaray) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salaray = salaray;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalaray() {
        return salaray;
    }

    public void setSalaray(double salaray) {
        this.salaray = salaray;
    }

    @Override
    public String toString() {
        return "Customerdto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salaray=" + salaray +
                '}';
    }
}
