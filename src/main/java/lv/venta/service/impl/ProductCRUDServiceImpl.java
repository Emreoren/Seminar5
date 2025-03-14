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
	public void create(String inputTitle, float inputPrice, String inputDescriptrion, int inputQuantity)
			throws Exception {
		// TODO Auto-generated method stub
		
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
	public Product retrieveByID(long id) throws Exception {
		
		if(prodRepo.findById())
	}

	@Override
	public void UpdateById(long id, float inputPrice, int inputQuantity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	

}
