package com.packt.webstore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

	public List<Product> getProductByCategory(String category) {
		List<Product> categoryProducts = new ArrayList<Product>();
		for (Product product : listOfProducts) {
			if (category.equalsIgnoreCase(product.getCategory())) {
				categoryProducts.add(product);
			}
		}
		return categoryProducts;
	}

	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		Set<Product> productsByBrand = new HashSet<Product>();
		Set<Product> productsByCategory = new HashSet<Product>();
		Set<String> criterias = filterParams.keySet();
		if (criterias.contains("brand")) {
			for (String brandName : filterParams.get("brand")) {
				for (Product product : listOfProducts) {
					if (brandName.equalsIgnoreCase(product.getManufacturer())) {
						productsByBrand.add(product);
					}
				}
			}
		}
		if (criterias.contains("category")) {
			for (String category : filterParams.get("category")) {
				productsByCategory.addAll(this.getProductByCategory(category));
			}
		}
		productsByCategory.retainAll(productsByBrand);
		return productsByCategory;
	}

	public List<Product> getProductsByManufaturer(String manufacturer) {
		List<Product> manufacturerProducts = new ArrayList<Product>();
		for (Product product : listOfProducts) {
			if (manufacturer.equalsIgnoreCase(product.getManufacturer())) {
				manufacturerProducts.add(product);
			}
		}
		return manufacturerProducts;
	}

	public List<Product> getProductsByPriceFilter(Map<String, String> priceFilter) {
		List<Product> productsWithPrice = new ArrayList<Product>();
		Set<String> criterias = priceFilter.keySet();
		if (criterias.contains("low") && criterias.contains("high")) {
//			BigDecimal lowPrice = new BigDecimal(priceFilter.get("low"));
//			BigDecimal highPrice = new BigDecimal(priceFilter.get("high"));
//			for (Product product : listOfProducts) {
//				if (lowPrice.compareTo(product.getUnitPrice()) == 1
//						&& highPrice.compareTo(product.getUnitPrice()) == -1) {
//					productsWithPrice.add(product);
//				}
//			}
		}
		return productsWithPrice;
	}

}
