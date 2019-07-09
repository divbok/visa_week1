package com.visa.prj.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayUtilTest {

	@Test
	public void testGetSum() {
		int[] data = {5,4,3,2,1,10};
		int expected = 25;
		assertEquals(expected,ArrayUtil.getSum(data));
	}

	@Test
	public void testSort() {
		int[] data = {5,3,2,1,4};
		int[] expected = {1,2,3,4,5};
		ArrayUtil.sort(data);
		assertArrayEquals(expected,data);
	}

	@Test
	public void testGetCount() {
		int[] data = {5,1,2,5,5,6};
		int expected = 3;
		assertEquals(expected,ArrayUtil.getCount(data, 5));
	}
	
	@Test
	public void testConvert() {
		int[][] data = {{5,1,2,4},{3,4,6,7},{7,8,9,10}};
		int[] expected = {5,1,2,4,3,4,6,7,7,8,9,10};
		int[] check = ArrayUtil.convert(data);
		assertArrayEquals(expected,check);
	}
	
	
	

}
