package com.visa.prj.client;

import java.lang.reflect.Method;

import com.visa.prj.entity.Mobile;
import com.visa.prj.entity.Product;
import com.visa.prj.entity.Tv;

public class ProductClient {

	public static void main(String[] args) {
		Product[] products = new Product[4]; //Array of 4 Pointers
		products[0] = new Tv(133,"Sony Bravia",135000.00,"LED");
		products[1] = new Mobile(453,"MotoG",12999.00,"4G");
		products[2] = new Tv(634,"Onida Thunder",35000.00,"CRT");
		products[3] = new Mobile(621,"iPhone XR",99999.00,"4G");
		
		printExpensive(products);
		printInfo(products);
		printInfoOCP(products);
	}

	
	/*
	 * Print details using Open for Extension, CLosed for Change
	 * Done using Reflection APIs
	 */
	private static void printInfoOCP(Product[] products) {
		System.out.println("Using OCP");
		for (Product p : products) {
			Class clazz = p.getClass();
			Method[] methods = clazz.getMethods();
			for (Method m : methods) {
				if(m.getName().startsWith("get")) {
					try {
						Object ret = m.invoke(p);
						System.out.println(ret);
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			System.out.println("*****");
		}
	}

	private static void printInfo(Product[] products) {
		for (Product p : products) {
			System.out.println(p.getName() + " : " + p.getPrice());
			if(p instanceof Tv)
			{
				Tv t = (Tv) p;
				System.out.println(t.getScreenType());
			}
			if(p.getClass() == Mobile.class) {
				Mobile m = (Mobile) p;
				System.out.println(m.getConnectivity());
			}
			System.out.println("!!!!!!");
		}
	}

	private static void printExpensive(Product[] products) {
		for (Product product : products) {
			if(product.isExpensive()) {
				System.out.println(product.getName() + " is expensive");
			}
			
		}
	}

}
