package com.visa.prj.client;

interface Computation{
	int compute(int x,int y);
}

public class TestAnonymous {

	public static void main(String[] args) {
		Computation c1 =new Computation() {		
			@Override
			public int compute(int x, int y) {
				return x + y;
			}
		};
		System.out.println(c1.compute(5,4));
		/*
		 * Java 8 introduced Lambda expression as a short form for anonymous class.
		 * interface should have only method to implement
		 */
		Computation c2 = (int x,int y) -> {
			return x - y;
		};
		System.out.println(c2.compute(5,4));
		//Type inference
		Computation c3 = (x,y) -> x*y; // if the method returns it will return or if void also same
		//no need to explicitly give return,int etc.. as its understood
		System.out.println(c3.compute(5,4));
		
		
	}
	
}
