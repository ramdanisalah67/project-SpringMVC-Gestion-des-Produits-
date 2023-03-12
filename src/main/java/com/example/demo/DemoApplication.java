package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.entities.Produit;
import com.example.demo.dao.ProduitRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
	ApplicationContext ctx =	SpringApplication.run(DemoApplication.class, args);
		ProduitRepository pr=ctx.getBean(ProduitRepository.class);
		
		pr.findAll().forEach(e->{System.out.println(e.getDesignation());});
		
	}

}
