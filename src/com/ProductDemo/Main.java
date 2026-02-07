package com.ProductDemo;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProductService service = new ProductService();

		/*service.addProduct(new Product("Type C", "Cable", "Black Drawer", 2024));
		service.addProduct(new Product("Mac Studio", "Computer", "White Table", 2025));
		service.addProduct(new Product("Focusrite Mixer", "Audio System", "White Table", 2025));

		service.addProduct(new Product("Asus Vivobook", "Laptop", "Brown Drawer", 2021));
		service.addProduct(new Product("Asus Rog", "Laptop", "Black Table", 2021));
		service.addProduct(new Product("Macbook Pro", "Laptop", "Brown Drawer", 2022));

		service.addProduct(new Product("Wacom Pad", "Writing Pad", "Black Drawer", 2020));
		service.addProduct(new Product("Apple Keyboard", "Keyboard", "White Table", 2022));
		service.addProduct(new Product("Logitech Keyboard", "Keyboard", "Black Table", 2024));

		service.addProduct(new Product("HDMI Cable", "Cable", "Black Drawer", 2024));
		service.addProduct(new Product("Java Black Book", "Book", "Shelf", 2024));
		service.addProduct(new Product("Logi Mouse", "Mouse", "Black Table", 2022));
		
		service.addProduct(new Product("Apple Mouse", "Mouse", "White Table", 2022));
		service.addProduct(new Product("Lenovo Mouse", "Mouse", "Black Drawer", 2022));
		service.addProduct(new Product("BlackBeast", "Computer", "White Table", 2020));*/
		
		List<Product> products = service.getAllProducts();
		for(Product p : products)
			System.out.println(p);
		
		
		System.out.println("====================================================");
		System.out.println("a Particular product");
		Product p = service.getProduct("Logi Mouse");
		System.out.println(p);
		
		
		System.out.println("====================================================");
		System.out.println("a Particular text");
		List<Product> prods = service.getProductWithText("black");
		for(Product prod:prods)
			System.out.println(prod);
		
		System.out.println("====================================================");
		System.out.println("Search By Place");
		List<Product> ans1 = service.getProductByPlace("Black Table");
		for(Product prod:ans1)
			System.out.println(prod);
		
		System.out.println("====================================================");
		System.out.println("Search products out of warranty");
		List<Product> ans2 = service.getOOfWProducts(2022);
		for(Product prod:ans2)
			System.out.println(prod);
		
		System.out.println("====================================================");
		System.out.println("Stream API for getProductWithText");
		List<Product> ans3 = service.getProductWithTextAPI("black");
		for(Product prod:ans3)
			System.out.println(prod);
	}

}
