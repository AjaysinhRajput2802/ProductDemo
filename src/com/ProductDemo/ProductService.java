package com.ProductDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

	List<Product> products = new ArrayList<>();
	ProductDB db = new ProductDB();
	
	public void addProduct(Product p) {
		// TODO Auto-generated method stub
		//products.add(p);
		db.save(p);
	}

	public List<Product> getAllProducts() {
		return db.getAll();
	}

	public Product getProduct(String name) {
		/*for(Product p : products)
		{
			if(p.getName().equals(name))	
				return p;
		}
		return null;*/
		return db.getProduct(name);
	}
	
	// search by place
	public List<Product> getProductByPlace(String place) {
		List<Product> prods = new ArrayList<>();
		for(Product p : products)
		{
			if(p.getPlace().equals(place))	
				prods.add(p);
		}
		return prods;
	}
	
	// search products out of warranty
	public List<Product> getOOfWProducts(int year) {
		List<Product> prods = new ArrayList<>();
		for(Product p : products)
		{
			if(p.getWarranty()<year)	
				prods.add(p);
		}
		return prods;
	}

	// stream API
	public List<Product> getProductWithTextAPI(String text) {
		String str = text.toLowerCase();
		return products.stream().filter(
				p -> (
						p.getName().toLowerCase().contains(str) || 
						p.getType().toLowerCase().contains(str) || 
						p.getPlace().toLowerCase().contains(str)
					  )
				).collect(Collectors.toList());
	}
	
	public List<Product> getProductWithText(String text) {
		text = text.toLowerCase();
		List<Product> prods = new ArrayList<>();
		
		for(Product p : products)
			if(p.getName().toLowerCase().contains(text) || p.getType().toLowerCase().contains(text) || p.getPlace().toLowerCase().contains(text))
				prods.add(p);
		
		return prods;
	}

}
