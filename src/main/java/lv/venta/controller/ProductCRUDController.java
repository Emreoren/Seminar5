package lv.venta.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.service.IProductCRUDService;
import lv.venta.model.Product;

@Controller
@RequestMapping("/product/crud")
public class ProductCRUDController {

	@Autowired
	private IProductCRUDService prodService;
	
	
	//CRUD
	
	
	
	//c
	
	
	
	//R
	@GetMapping("/all")
	public String getControllerAllProducts(Model model) 
	{
	try
		{
		ArrayList<Product> allProducts = prodService.retrieveAll();
		model.addAttribute("boxies", allProducts);//will add products from DB in box
		return "array-product-page";//show-all-product-page.html will be shown with products from DB
		
		}
	catch (Exception e) 
		{
			model.addAttribute("box", e.getMessage());
			return "error-page";//this will show error-page.html with Exception message
		}
	}
	
	

	//R by Id
	
	@GetMapping("/one")//localhost:8080/product/crud/one?id=3
	public String getControlleOneProductById(@RequestParam(name = "id") long id, Model model)
	{
		try
		{
		Product oneProduct = prodService.retrieveById(id);
		model.addAttribute("box", oneProduct);
		return "test-product-page";
		}
		catch (Exception e)
		{
			model.addAttribute("box", e.getMessage());
			return "error-page";
		}
	}
	
	
	
	@GetMapping("/all/{id}")//localhost:8080/product/crud/all/3
	public String getControllerOneProductById(@PathVariable(name = "id") long id, Model model)
	{
		try
		{
		Product oneProduct = prodService.retrieveById(id);
		model.addAttribute("box", oneProduct);
		return "test-product-page";
		}
		catch (Exception e)
		{
			model.addAttribute("box", e.getMessage());
			return "error-page";
		}
	}
	
	
}
	
	
	