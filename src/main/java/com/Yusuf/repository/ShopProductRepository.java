package com.Yusuf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Yusuf.entity.ShopProduct;

@Repository
public interface ShopProductRepository extends JpaRepository<ShopProduct, Long> {
	
	Optional<ShopProduct> findByProductId(Long productId);

}
