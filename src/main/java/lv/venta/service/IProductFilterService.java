package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;

public interface IProductFilterService {

	public abstract ArrayList<Product> retrieveAllProductsPriceLessThan(float priceThreshold)throws Exception;
	
	public abstract ArrayList<Product> retrieveAllProductsTitleOrDescriptionContainsText(String text) throws Exception;
	
	public abstract ArrayList<Product> retrieveAllProductsQuantityLargerThan(int quantity) throws Exception;

}
