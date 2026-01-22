package com.Yusuf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Yusuf.entity.CustomerBasket;

@Repository
public interface CustomerBasketRepository extends JpaRepository<CustomerBasket, Long> {

}
