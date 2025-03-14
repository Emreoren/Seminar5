package lv.venta.model;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,20}")
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



}
