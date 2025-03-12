package lv.venta.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
	//variables
	private long id;
	private String title;	
	private float price;
	private String description;
	private int quantity;
	
	
	//getters
	//setters
	//no arg cons
	
	
	public Product(String inputTitle, float inputPrice, String inputDescriptrion, int inputQuantity)
	{
		setTitle(inputTitle);
		setPrice(inputPrice);
		setDescription(inputDescriptrion);
		setQuantity(inputQuantity);
	}
	//arg cons


}
