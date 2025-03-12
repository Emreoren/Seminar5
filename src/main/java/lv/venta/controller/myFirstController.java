package lv.venta.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.venta.model.Product;

@Controller
public class myFirstController {

	@GetMapping("/simple") //localhost:8080/simple
	public String getControllerSimple()
	{
		System.out.println("Simple controlled is dead");
		return "simple-page"; // it will show a simple htmlpage
	}
	
	
	@GetMapping("/data")
	public String getControllerData(Model model)
	{
		Random rand = new Random();
		System.out.println("Data controller is called");
		String data = "Emre: "  + rand.nextInt(0, 11);
		model.addAttribute("box", data);
		return "data-page"; //it will show a data.page.html with data 
	}
	
	
	
	@GetMapping("/testproduct") // localhost:8080/testproduct
	public String getControllerSendProduct(Model model)
	{
		Product testProduct = new Product("Banana", 1.99f, "Eco, yellow", 100 );
		model.addAttribute("box", testProduct);
		return "test-product-page"; // it will show the page
	}
	
}
