package com.Yusuf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Yusuf.entity.BasketProduct;

@Repository
public interface BasketProductRepository extends JpaRepository<BasketProduct, Long>{

}
