package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.repo.IProductRepo;
import lv.venta.service.IProductCRUDService;

@Service
public class ProductCRUDServiceImpl implements IProductCRUDService{

	@Autowired
	private IProductRepo prodRepo;
	
	
	
	@Override
	public void create(String inputTitle, float inputPrice, String inputDescription, int inputQuantity)
			throws Exception {
		if(inputTitle == null || !inputTitle.matches("[A-Z]{1}[a-z ]{2,20}")
				|| inputPrice < 0 || inputPrice > 100000
				|| inputDescription == null || !inputDescription.matches("[A-Za-z0-9 ,.;:]+")
				|| inputQuantity < 0 || inputQuantity > 10000)
		{
			throw new Exception("Problems with input params");
		}
		
		if(prodRepo.existsByTitleAndDescriptionAndPrice(inputTitle,inputDescription, inputPrice ))
		{
			Product retrieveProduct = 
				prodRepo.findByTitleAndPriceAndDescription(inputTitle, inputPrice, inputDescription);
			
			int newQuantity = retrieveProduct.getQuantity() + inputQuantity;
			retrieveProduct.setQuantity(newQuantity);
			prodRepo.save(retrieveProduct);//this will update the product
		}
		
		else
		{
			Product newProduct = new Product(inputTitle, inputPrice, inputDescription, inputQuantity);
			prodRepo.save(newProduct);//this will save the new product
		}
		
		
	}

	@Override
	public ArrayList<Product> retrieveAll() throws Exception {
		if(prodRepo.count() == 0)
		{
			throw new Exception("Product table is empoty");
		}
		
		ArrayList<Product> allProducts = (ArrayList<Product>) prodRepo.findAll();
		return allProducts;
	}


	@Override
	public Product retrieveById(long id) throws Exception {
		//TODO
		if(id <= 0)
		{
			throw new Exception("Id should positive");
		}
		if(!prodRepo.existsById(id)) {
			throw new Exception("The product with id " + id + " doesn't exist");
		}
		
		Product oneProduct = prodRepo.findById(id).get();
		return oneProduct;
	}

	@Override
	public void UpdateById(long id, float inputPrice, String inputDescription, int inputQuantity) throws Exception {
		if(inputPrice < 0 || inputPrice > 1000 ||inputDescription == null || !inputDescription.matches("[A-Za-z0-9 ,.;:]+")
				||inputQuantity < 0 || inputQuantity > 100)
		{
			throw new Exception("Problems with input params");
		}
		
		Product productForUpdate = retrieveById(id);
		productForUpdate.setPrice(inputPrice);
		productForUpdate.setDescription(inputDescription);
		productForUpdate.setQuantity(inputQuantity);
		
		prodRepo.save(productForUpdate);
		
		}
		
		
		
		


	@Override
	public void DeleteById(long id) throws Exception {
		Product productForDelete = retrieveById(id);
		prodRepo.delete(productForDelete);
		
	}

	

}
