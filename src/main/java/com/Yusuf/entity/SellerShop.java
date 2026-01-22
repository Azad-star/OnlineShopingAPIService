package com.Yusuf.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seller_shop")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerShop extends BaseEntity {
	
	@ManyToOne
	private Seller seller;
	
	@ManyToOne
	private Shop shop;

}
