package com.Yusuf.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.Yusuf.dto.DtoBasketProduct;
import com.Yusuf.dto.DtoBasketProductIU;
import com.Yusuf.dto.DtoCustomerForPurchase;
import com.Yusuf.dto.DtoProductForPurchase;
import com.Yusuf.dto.DtoShopForPurchase;
import com.Yusuf.entity.BasketProduct;
import com.Yusuf.entity.Customer;
import com.Yusuf.entity.Product;
import com.Yusuf.entity.ShopProduct;
import com.Yusuf.exception.BaseException;
import com.Yusuf.exception.ErrorMessage;
import com.Yusuf.exception.MessageType;
import com.Yusuf.repository.BasketProductRepository;
import com.Yusuf.repository.CustomerRepository;
import com.Yusuf.repository.ProductRepository;
import com.Yusuf.repository.ShopProductRepository;
import com.Yusuf.service.IBasketProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BasketProductService implements IBasketProductService{
	
	// Repositories
	private final CustomerRepository customerRepository;
	
	private final BasketProductRepository basketProductRepository;
	
	private final ProductRepository productRepository;
	
	private final ShopProductRepository shopProductRepository;

	@Override
	public DtoBasketProduct saveBasketProduct(DtoBasketProductIU dtoBasketProductIU) {
		
		BasketProduct basketProduct = new BasketProduct();
			
		DtoBasketProduct dtoBasketProduct = new DtoBasketProduct();
		// Special Dto Classes for purchasing
		DtoShopForPurchase dtoShop = new DtoShopForPurchase();
		DtoCustomerForPurchase dtoCustomer = new DtoCustomerForPurchase();
		DtoProductForPurchase dtoProduct = new DtoProductForPurchase();
		
		// Check Customer
		Optional<Customer> optCustomer = customerRepository.findById(dtoBasketProductIU.getCustomerId());
		if(optCustomer.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.INVALID_ID, "Invalid customerId => " + dtoBasketProductIU.getCustomerId()));
			}
		
		// Check Product
		Optional<Product> optProduct = productRepository.findById(dtoBasketProductIU.getProductId());
		if(optProduct.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.INVALID_ID, "Invalid productId => " + dtoBasketProductIU.getProductId()));
			}
		
		// Check Enough Balance
		if(optCustomer.get().getAccount().getBalance().compareTo(optProduct.get().getPrice()) < 0 ) {
			throw new BaseException(new ErrorMessage(MessageType.NO_ENOUGH_BALANCE, "Inadequate balance  => " + optCustomer.get().getAccount().getBalance() + " TL"));  
		}
		
		Optional<ShopProduct> opShopProduct = shopProductRepository.findByProductId(optProduct.get().getId());
		BeanUtils.copyProperties(opShopProduct.get().getShop(), dtoShop);
		
		// Setting basketProduct to save  DB
		basketProduct.setCreateTime(new Date());
		basketProduct.setCustomer(optCustomer.get());
		basketProduct.setBasket(optCustomer.get().getBasket());
		basketProduct.setProduct(optProduct.get());
		BasketProduct savedBasketProduct = basketProductRepository.save(basketProduct);
		
		BeanUtils.copyProperties(optCustomer.get(), dtoCustomer);
		BeanUtils.copyProperties(optProduct.get(), dtoProduct);
		
		// Seting dtoProduct to return
		BeanUtils.copyProperties(savedBasketProduct, dtoBasketProduct);
		dtoBasketProduct.setProduct(dtoProduct);
		dtoBasketProduct.setCustomer(dtoCustomer);
		dtoBasketProduct.setShop(dtoShop);
		
		// Update Product stock
		Product updatedProduct = optProduct.get();
		updatedProduct.setStock(optProduct.get().getStock()-1);
		productRepository.save(updatedProduct);
		
		// Update Customer Account
		Customer updatedCustomer = optCustomer.get();
		updatedCustomer.getAccount().setBalance(updatedCustomer.getAccount().getBalance().subtract(optProduct.get().getPrice()));
		customerRepository.save(updatedCustomer);
		
		return dtoBasketProduct;
	}

}
