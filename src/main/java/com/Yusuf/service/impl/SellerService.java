package com.Yusuf.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Yusuf.dto.DtoSeller;
import com.Yusuf.dto.DtoSellerIU;
import com.Yusuf.dto.DtoShop;
import com.Yusuf.entity.Seller;
import com.Yusuf.entity.SellerShop;
import com.Yusuf.entity.Shop;
import com.Yusuf.repository.SellerRepository;
import com.Yusuf.repository.SellerShopRepository;
import com.Yusuf.service.ISellerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SellerService implements ISellerService{
	
	private final SellerRepository sellerRepository;
	
	private final SellerShopRepository sellerShopRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public DtoSeller saveSeller(DtoSellerIU dtoSellerIU) {
		SellerShop sellerShop = new SellerShop();
	    Seller seller = new Seller();
	    Shop shop = new Shop();

	    seller.setCreateTime(new Date());
	    seller.setSellerName(dtoSellerIU.getSellerName());
	    seller.setPassword(passwordEncoder.encode(dtoSellerIU.getPassword()));

	    shop.setCreateTime(new Date());
	    shop.setShopName(dtoSellerIU.getShopName());

	    seller.setShop(shop);

	   
	    Seller savedSeller = sellerRepository.save(seller);

	    DtoSeller dtoSeller = new DtoSeller();
	    BeanUtils.copyProperties(savedSeller, dtoSeller);

	    DtoShop dtoShop = new DtoShop();
	    BeanUtils.copyProperties(savedSeller.getShop(), dtoShop); 

	    dtoSeller.setShop(dtoShop);
	    
	    sellerShop.setCreateTime(new Date());
	    sellerShop.setSeller(savedSeller);
	    sellerShop.setShop(shop);
	    sellerShopRepository.save(sellerShop);

	    return dtoSeller;
	}

}
