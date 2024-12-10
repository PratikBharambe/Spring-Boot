package com.demo.SpringBootProductCRUDMVC.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "catagory")
public class Category {

    @Id
    private int id;
    private String cname;
    private String cdesc;

    public Category() {
    }

    public Category(int id, String cname, String cdesc) {
        this.id = id;
        this.cname = cname;
        this.cdesc = cdesc;
    }

    public int getId() {
        return id;
    }

    public String getCname() {
        return cname;
    }

    public String getCdesc() {
        return cdesc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setCdesc(String cdesc) {
        this.cdesc = cdesc;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                ", cdesc='" + cdesc + '\'' +
                '}';
    }
}
