package com.Yusuf.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer_basket")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerBasket extends BaseEntity {
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private Basket basket;

}
