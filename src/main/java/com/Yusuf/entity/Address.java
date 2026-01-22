package com.Yusuf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address  extends BaseEntity{
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "neighbor")
	private String neighbor;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "apartmentNo")
	private String apartmentNo;

}
