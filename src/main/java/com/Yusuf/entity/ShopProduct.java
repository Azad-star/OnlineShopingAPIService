package com.Yusuf.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shop_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopProduct extends BaseEntity {
	
	@ManyToOne
	private Shop shop;
	
	@ManyToOne
	private Product product;

}
