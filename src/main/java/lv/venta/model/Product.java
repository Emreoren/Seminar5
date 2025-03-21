package lv.venta.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Table(name = "ProductTable") // Mysql will be product_table, H2 - PRODUCT_TABLE
@Entity
public class Product {
	//variables
	@Column(name = "Id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE) // this means thet setter for id will be not visible/usable
	private long id;
	
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,20}")
	@Column(name = "Title")
	private String title;	
	
	@Min(0)
	@Max(100000)
	@Column(name = "Price")
	private float price;
	
	@Column(name = "Description")
	@NotNull
	@Pattern(regexp = "[A-Za-z0-9 ,.;:]+")
	@Size(min = 5, max = 100)
	private String description;
	
	
	@Min(0)
	@Max(1000000)
	@Column(name = "Quantity")
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
