package com.myretail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myretail.dto.PriceDto;
import com.myretail.dto.ProductDto;
import com.myretail.model.Currency;
import com.myretail.model.ProductPrice;
import com.myretail.repository.ProductPriceRepository;
import com.myretail.service.ProductService;

@SpringBootApplication
public class MyRetailCommandLineRunner implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductPriceRepository productPriceRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyRetailCommandLineRunner.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		productService.deleteAll();

		// save a couple of products
		productService.save(new ProductDto(1234l, "Dell Latitude 1460", "Dell"));
		productService.save(new ProductDto(1235l, "Dell Inspiron 1460", "Dell"));
		productService.save(new ProductDto(13860428l, "The Big Lebowski (Blu-ray) (Widescreen)", "LG"));
		productPriceRepository.save(new ProductPrice(1234l, 1099.99, Currency.USD));
		productPriceRepository.save(new ProductPrice(1235l, 1199.99, Currency.USD));
		productPriceRepository.save(new ProductPrice(13860428l, 599.99, Currency.USD));

		// fetch all products
		System.out.println("products found with findAll():");
		System.out.println("-------------------------------");
		for (ProductDto productDto : productService.findAll()) {
			System.out.println(productDto);
		}
		System.out.println();

		// fetch an individual product
		System.out.println("Product found with findOne(1234l):");
		System.out.println("--------------------------------");
		System.out.println(productService.findOne(1234l));

		System.out.println();
		// update an individual product
		ProductDto productToUpdate = new ProductDto(1234l, "Dell Latitude 1460", "Dell");
		PriceDto priceDto = new PriceDto(1299.99, Currency.USD);
		productToUpdate.setCurrentPrice(priceDto);

		System.out.println("Product price update with save(1234l):");
		System.out.println("--------------------------------");
		productService.save(productToUpdate);
		System.out.println(productService.findOne(1234l));
	}

}