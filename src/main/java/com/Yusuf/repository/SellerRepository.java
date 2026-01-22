package com.Yusuf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Yusuf.entity.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long>{

}
