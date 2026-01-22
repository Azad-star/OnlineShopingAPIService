package com.Yusuf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Yusuf.entity.Basket;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long>{

}
