package com.Yusuf.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private Long age;
	
	@OneToOne(cascade = CascadeType.ALL) // Kendi tablolarında kaydedilir repository çağırmana gerek kalmaz
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Account account;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Basket basket;

}
