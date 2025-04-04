package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.repo.IProductRepo;
import lv.venta.service.IProductFilterService;

@Service
public class ProductFilterServiceImpl implements IProductFilterService{
	
	
	@Autowired
	private IProductRepo prodRepo;

	@Override
	public ArrayList<Product> retrieveAllProductsPriceLessThan(float priceThreshold) throws Exception 
	{
		if(priceThreshold < 0 || priceThreshold > 1000)
		{
			throw new Exception("Price can be 1 - 1000");
		}
		ArrayList<Product> result = prodRepo.findByPriceLessThanEqual(priceThreshold);
		if(result.isEmpty())
		{
			throw new Exception("There is no product smaller than " + priceThreshold + " TRY");
		}
		
		return result;
	}

	@Override
	public ArrayList<Product> retrieveAllProductsTitleOrDescriptionContainsText(String text) throws Exception {
			
		if(text == null || text.length() == 0 )
		{
			throw new Exception("There is a problem with searching text");
		}
		ArrayList<Product> result = prodRepo.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(text, text);
		
		if(result.isEmpty())
		{
			throw new Exception("There is no product that contains text: " + text);
		}
		
		return result;
	}

	@Override
	public ArrayList<Product> retrieveAllProductsQuantityLargerThan(int quantityThreshold) throws Exception {
		
		if(quantityThreshold < 0 || quantityThreshold > 1000000)
		{
			throw new Exception("Quantity can be 0 - 1000000");
		}
		ArrayList<Product> result = prodRepo.findByQuantityGreaterThanEqual(quantityThreshold);
		
		if(result.isEmpty())
		{
			throw new Exception("There is no product that quantity is larger than " + quantityThreshold );
			
		}
		
		
		return result;
	}
	
	

	
}
