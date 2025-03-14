package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;

public interface IProductCRUDService {
//CRUD create, retrive all, retrive one by id, update, delete
	
	
	//C
	public abstract void create(String inputTitle, float inputPrice, String inputDescriptrion, int inputQuantity)throws Exception ;
	
	
	//R
	public abstract ArrayList<Product> retrieveAll () throws Exception;
	
	
	//R
	public abstract Product retrieveByID(long id)throws Exception;
	
	
	//U
	public abstract ArrayList<Product> UpdateById (long id, float inputTitle, int inputQuantity) throws Exception;
	
	
	
	
	
}
