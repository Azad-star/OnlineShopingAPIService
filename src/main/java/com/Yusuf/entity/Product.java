package com.Yusuf.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity{
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "stock")
	private Long stock;
	
	


}
