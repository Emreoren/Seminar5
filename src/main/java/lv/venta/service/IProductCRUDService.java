package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;

public interface IProductCRUDService {
//CRUD create, retrive all, retrive one by id, update, delete
	
	
	//C
	public abstract void create(String inputTitle, float inputPrice, String inputDescription, int inputQuantity)throws Exception ;
	
	
	//R
	public abstract ArrayList<Product> retrieveAll () throws Exception;
	
	
	//R 
	public abstract Product retrieveById(long id) throws Exception;
	
	
	//U
	public abstract void UpdateById (long id, float inputPrice,String inputDescription, int inputQuantity) throws Exception;
	
	//D
	public abstract void DeleteById(long id)throws Exception;

	
	
	
}
