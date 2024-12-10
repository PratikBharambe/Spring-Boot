package com.demo.SpringBootRestWebService.dto;


public class ProductDto {

    private int id;
    private String name;
    private int qty;
    private double price;
    private String expdate;
    private int cid;

    public ProductDto() {
    }

    public ProductDto(int id, String name, int qty, double price, String expdate, int cid) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.expdate = expdate;
        this.cid = cid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", expdate='" + expdate + '\'' +
                ", cid=" + cid +
                '}';
    }
}
