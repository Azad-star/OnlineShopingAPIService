package com.Yusuf.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "basket_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketProduct extends BaseEntity{
	
	@ManyToOne
	private Basket basket;
	
	@ManyToOne
	private Product product;
	
	@ManyToOne
	private Customer customer;
	

}
