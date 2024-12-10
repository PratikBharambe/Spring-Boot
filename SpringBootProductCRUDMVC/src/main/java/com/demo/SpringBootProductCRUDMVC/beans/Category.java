package com.demo.SpringBootProductCRUDMVC.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "catagory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    private int id;
    private String cname;
    private String cdesc;
}
