package com.packt.webstore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;

@Repository
public class InMemoryProductRepository implements ProductRepository {

	private List<Product> listOfProducts = new ArrayList<Product>();
	
	public InMemoryProductRepository() {

		Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
		iphone.setDescription("Apple iPhone 5s, smartfon z 4-calowym ekranem o "
				+ "rozdzielczości 640x1136 i 8-megapikselowym aparatem");
		iphone.setCategory("Smartfon");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(1000);
		
		Product laptopDell = new Product("P1235", "Dell Inspiron", new BigDecimal(700));
		laptopDell.setDescription("Dell Inspiron, 14-calowy laptop (czarny)");
		laptopDell.setCategory("laptop");
		laptopDell.setManufacturer("Dell");
		laptopDell.setUnitsInStock(1000);
		
		Product tabletNexus = new Product("P1236", "Nexus 7", new BigDecimal(300));
		tabletNexus.setDescription("Google Nexus 7 jest najlżejszym 7-calowym tabletem z "
				+ "4 rdzeniowym procesorem Qualcomm SnapDragon S4 Pro");
		tabletNexus.setCategory("Tablet");
		tabletNexus.setManufacturer("Google");
		tabletNexus.setUnitsInStock(1000);
		
		listOfProducts.add(iphone);
		listOfProducts.add(laptopDell);
		listOfProducts.add(tabletNexus);
	}
	
	public List<Product> getAllProducts() {
		return this.listOfProducts;
	}

	public Product getProductById(String productId) {
		Product productById = null;
		for (Product product : listOfProducts) {
			if (product != null && product.getProductId() != null
					&& product.getProductId().equals(productId)) {
				productById = product;
				break;
			}
		}
		if (productById == null) {
			throw new IllegalArgumentException("Brak produktu o wskazanym id: " + productId);
		}
		return productById;
	}

}
