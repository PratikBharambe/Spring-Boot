package com.demo.SpringBootProductCRUDMVC.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product1")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	private int id;
	private String name;
	private int qty;
	private double price;
	private int cid;

}
