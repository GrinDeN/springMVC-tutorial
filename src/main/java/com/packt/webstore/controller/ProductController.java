package com.packt.webstore.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.webstore.domain.Product;

@Controller
public class ProductController {

	@RequestMapping("/products")
	public String list(Model model) {
		Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
		iphone.setDescription("Apple Iphone5s, smartphone z 5-calowym wyświetlaczem "
				+ "o rozdzielczości 640x1136 i 8-megapikselowym aparatem.");
		iphone.setCategory("Smart Phone");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(1000);
		model.addAttribute("product", iphone);
		return "products";
	}
}
