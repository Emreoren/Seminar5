package lv.venta.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lv.venta.service.IProductCRUDService;
import lv.venta.model.Product;

@Controller
@RequestMapping("/product/crud")
public class ProductCRUDController {

	@Autowired
	private IProductCRUDService prodService;
	
	
	//CRUD
	
	
	
	//c
	
	@GetMapping("/create") // localhost:8080/product/crud/create
	public String getControllerCreateNewProduct(Model model)
	{
		Product newEmptyProduct = new Product();
		model.addAttribute("product", newEmptyProduct);
		return "create-product-page";//will show create-product-page.html with empty new product
	}
	
	@PostMapping("/create")
	public String postControllerCreateNewProduct(@Valid Product product, BindingResult result, Model model) {//get product from html
		if(result.hasErrors()) // is there any validation problem
		{
			return "create-product-page";
		}
		try {
			prodService.create(product.getTitle(), product.getPrice(),
					product.getDescription(), product.getQuantity());
			return "redirect:/product/crud/all";
		} catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";//this will show error-page.html with Exception message

		}
		
		
	}
	
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
	public String getControllerOneProductById(@RequestParam(name = "id") long id, Model model)
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
	public String postControllerOneProductById(@PathVariable(name = "id") long id, Model model)
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
	
	//U
	
	
	@GetMapping("/update/{id}") //localhost:8080/product/crud/update/3
	public String getControllerUpdateProductById(@PathVariable(name = "id") long id, Model model) {
		try
		{
			Product productForUpdating = prodService.retrieveById(id);
			model.addAttribute("product", productForUpdating);
			return "update-product-page";
		}catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";//this will show error-page.html with Exception message
		}
		
	}
	
	@PostMapping("/update/{id}")
	public String postControllerUpdateProductById(@PathVariable(name = "id") long id, @Valid Product product, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			return "update-product-page";
		}
		
		try
		{
			prodService.UpdateById(id, product.getPrice(), product.getDescription(), product.getQuantity());
			return "redirect:/product/crud/all";
		}
		catch (Exception e)
		{
			model.addAttribute("box", e.getMessage());
			return "error-page";
		}
	}
	@GetMapping("/delete/{id}")//localhost:8080/product/crud/delete/3
	public String getControllerDeleteProductById(@PathVariable(name = "id") long id, Model model)
	{
		try {
			prodService.DeleteById(id);
			model.addAttribute("box", prodService.retrieveAll());//will add products from DB in box
			return "show-all-product-page";//show-all-product-page.html will be shown with products from DB

		} catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";//this will show error-page.html with Exception message

		}
		
	}
	
	
	
	
}
	
	
	