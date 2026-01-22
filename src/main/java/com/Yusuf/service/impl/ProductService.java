package com.Yusuf.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Yusuf.dto.DtoProduct;
import com.Yusuf.dto.DtoProductIU;
import com.Yusuf.dto.DtoShop;
import com.Yusuf.entity.Product;
import com.Yusuf.entity.Seller;
import com.Yusuf.entity.SellerShop;
import com.Yusuf.entity.Shop;
import com.Yusuf.entity.ShopProduct;
import com.Yusuf.exception.BaseException;
import com.Yusuf.exception.ErrorMessage;
import com.Yusuf.exception.MessageType;
import com.Yusuf.repository.ProductRepository;
import com.Yusuf.repository.SellerRepository;
import com.Yusuf.repository.SellerShopRepository;
import com.Yusuf.repository.ShopProductRepository;
import com.Yusuf.repository.ShopRepository;
import com.Yusuf.service.IProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
	
	private final ProductRepository productRepository;
	
	private final SellerRepository sellerRepository;
	
	private final ShopProductRepository shopProductRepository;
	
	private final SellerShopRepository sellerShopRepository; 
	
	private final ShopRepository shopRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public DtoProduct saveProduct(DtoProductIU dtoProductIU) {
			
		Product product = new Product();
		Seller seller = new Seller();
		Shop shop = new Shop();
		SellerShop sellerShop = new SellerShop();
		ShopProduct shopProduct = new ShopProduct();
		
		DtoShop dtoShop = new DtoShop();
		DtoProduct dtoProduct = new DtoProduct();
		
		Optional<Seller> optSeller = sellerRepository.findById(dtoProductIU.getSellerId());
		if(optSeller.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.INVALID_ID, "Invalid sellerId => " + dtoProductIU.getSellerId()));
		}
		
		boolean matcehsPassword = encoder.matches(dtoProductIU.getPassword() , optSeller.get().getPassword());
		
		if(!matcehsPassword) {
			throw new BaseException(new ErrorMessage(MessageType.INVALID_PASSWORD, "Invalid password => " + dtoProductIU.getPassword()));
		}
		
		Optional<Shop> optShop = shopRepository.findById(dtoProductIU.getShopId());
		if(optShop.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.INVALID_ID,"Invalid shopId => " + dtoProductIU.getShopId()));
		}
		
		Optional<SellerShop> optSellerShop = sellerShopRepository.findSellerShopBySellerIdAndShopId(dtoProductIU.getSellerId(), dtoProductIU.getShopId());
		if(optSellerShop.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.INVALID_ID, "The shop doesn't belong to this seller => " + dtoProductIU.getShopId() ));
		}
			
		product.setCreateTime(new Date());
		BeanUtils.copyProperties(dtoProductIU, product);
		Product savedProduct = productRepository.save(product);
		BeanUtils.copyProperties(optShop.get(), shop);
		BeanUtils.copyProperties(shop, dtoShop);
		BeanUtils.copyProperties(savedProduct, dtoProduct);
		dtoProduct.setShop(dtoShop);
		
		shopProduct.setCreateTime(new Date());
		shopProduct.setProduct(savedProduct);
		shopProduct.setShop(shop);
		shopProductRepository.save(shopProduct);
		
		return dtoProduct;
	}

}
