package com.visa.prj.client;

import com.visa.prj.dao.PersistenceException;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.dao.ProductDaoJdbcImpl;
import com.visa.prj.entity.Product;

public class AddProduct {

	public static void main(String[] args) {
		ProductDao productDao = new ProductDaoJdbcImpl();
		Product p =new Product(0, "Logitech Mouse", "computer", 400.00, 500);
		try {
			int id = productDao.addProduct(p);
			System.out.println("Product added with id " + id);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}

}
