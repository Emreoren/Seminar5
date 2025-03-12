package lv.venta.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
	//variables
	private long id;	//TODO auto increment from DB 
	private String title;	
	private float price;
	private String description;
	private int quantity;
	
	
	//getters
	//setters
	//no arg cons
	//arg cons	
	
	public Product(String inputTitle, float inputPrice, String inputDescriptrion, int inputQuantity)
	{
		setTitle(inputTitle);
		setPrice(inputPrice);
		setDescription(inputDescriptrion);
		setQuantity(inputQuantity);
	}

	//TODO
	//Create new controller function as a get
	//create new product
	//add this product in model
	//specify which html file should be shoed
	//create the html file
	

}
