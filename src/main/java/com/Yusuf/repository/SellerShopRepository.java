package com.Yusuf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Yusuf.entity.SellerShop;

@Repository
public interface SellerShopRepository extends JpaRepository<SellerShop, Long>{
	
	Optional<SellerShop> findSellerShopBySellerIdAndShopId(Long sellerId, Long shopId);

}
