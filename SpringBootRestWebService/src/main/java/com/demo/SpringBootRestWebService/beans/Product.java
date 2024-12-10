package com.demo.SpringBootRestWebService.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Product {

    @Id
    private int id;
    private String name;
    private int qty;
    private double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expdate;
    private int cid;

    public Product() {
    }

    public Product(int id, String name, int qty, double price, LocalDate expdate, int cid) {
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

    public LocalDate getExpdate() {
        return expdate;
    }

    public void setExpdate(LocalDate expdate) {
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
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", expdate=" + expdate +
                ", cid=" + cid +
                '}';
    }
}
