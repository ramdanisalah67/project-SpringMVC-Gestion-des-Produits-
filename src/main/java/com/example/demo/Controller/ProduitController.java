package com.example.demo.Controller;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.ProduitRepository;
import com.example.demo.entities.Produit;

import jakarta.validation.Valid;

@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository pr ;
@RequestMapping(value = "/index")

	public String Lister(Model model,@RequestParam(name = "page",defaultValue = "0") int page,
			@RequestParam(name = "size",defaultValue = "4") int size,
			@RequestParam(name="MotCle",defaultValue = "")String mc
			) 
				{
					Page <Produit> produits = pr.chercher_Par_Mot_Cle("%"+mc+"%",PageRequest.of(page, size));
					model.addAttribute("list_des_produits",produits.getContent());
					int totalpages[]= new int[produits.getTotalPages()];
					model.addAttribute("total_pages",totalpages);
					model.addAttribute("size",size);
					model.addAttribute("page_courante",page);
					model.addAttribute("mc",mc);
						return "index";
				}
@RequestMapping(value="/delete",method = RequestMethod.GET) //par defaut c'est Get alors dans ce cas c'est pas obligeé pour declaré cette attribue
	public String delete(@RequestParam(name="id",defaultValue = "") Long Id,@RequestParam(name="page",defaultValue = "")int page
			,@RequestParam(name="size",defaultValue = "")int size,@RequestParam(name="MotCle",defaultValue = "")String mc) {
		pr.deleteById(Id);
		
		return "redirect:/index?page="+page+"&size="+size+"&MotCle="+mc;
	}

@RequestMapping(value = "/AddProduct",method = RequestMethod.GET)
public String AddProduct(Model model) {
	model.addAttribute("produit",new Produit());
	return "AjouterProduit";
}
@RequestMapping(value = "/save",method = RequestMethod.POST)
public String save(Model model,@Valid Produit produit,BindingResult bindingResult) {
	if(bindingResult.hasErrors()) {
		return "AjouterProduit" ;
	}
	pr.save(produit);
	return "Confirmation";
}
@RequestMapping(value = "/to_layout",method = RequestMethod.GET)
public String lay() {

	return "layout";
}
@RequestMapping(value = "/test",method = RequestMethod.GET)
public String test() {

	return "test";
}
@RequestMapping(value = "/test2",method = RequestMethod.GET)
public String test2() {

	return "testfiles";

}}
