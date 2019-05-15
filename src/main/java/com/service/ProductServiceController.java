package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Product;

@RefreshScope
@RestController
@RequestMapping(value="/productservice")
public class ProductServiceController {
	
	@Value("${product.id}")
	private String prod_id;
	
	@Value("${product.name}")
	private String prod_name;
	
	@RequestMapping(value="/products", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getProducts() {
		Product testProduct1 = new Product("123", "testproduct");
		Product testProduct2 = new Product(prod_id, prod_name);
		
		List<Product> result = new ArrayList<Product>();
		result.add(testProduct1);
		result.add(testProduct2);
		return result;
	}

}
