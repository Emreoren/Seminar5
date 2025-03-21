package lv.venta.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.repo.IProductRepo;

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
			throw new Exception("There is no product smaller than " + priceThreshold);
		}
		
		return result;
	}

	@Override
	public ArrayList<Product> retrieveAllProductsTitleOrDescriptionContainsText(String text) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> retrieveAllProductsQuantityLargerThan(int quantity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
}
