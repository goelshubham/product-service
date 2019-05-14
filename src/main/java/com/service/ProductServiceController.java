package com.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping(value="/productservice")
public class ProductServiceController {
	
	@Value("${key.com}")
	private String key;
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public String getProducts() {
		return "Property from external file is -> " + key;
	}

}
