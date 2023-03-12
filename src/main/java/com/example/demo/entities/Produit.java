package com.example.demo.entities;


import java.io.Serializable;

import org.hibernate.annotations.*;
import org.springframework.lang.NonNull;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Produit implements Serializable{
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private Long Id ;

@NotNull @Size(min=3,max=8)
private String designation ;

@DecimalMin("100")
private double prix ;
@Min(1)
@NotNull
private int quantite ;


public Produit() {
	
}
public Produit(Long id,String des,double prix,int q) {
	Id=id ;
	
	designation=des ;
	this.prix=prix ;
	quantite=q;
	
}

public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}
public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}
public Long getId() {
	return Id;
}
public void setId(Long id) {
	Id = id;
}



}

