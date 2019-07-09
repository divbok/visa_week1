package com.visa.prj.util;

public class ArrayUtil {
	public static int getSum(int[] data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}

	//use comparable to compare objects of any type
	public static void sort(Comparable[] elems) {
		for (int i = 0; i < elems.length; i++) {
			for (int j = i+1; j < elems.length; j++) {
				if(elems[i].compareTo(elems[j]) > 0) {
					Comparable temp = elems[i];
					elems[i] = elems[j];
					elems[j] = temp;			
				}
			}
		}
	}

	/**
	 * method to return number of occurence of "no" in array
	 * 
	 * @param elems
	 * @param no
	 * @return
	 */
	public static int getCount(int[] elems, int no) {
		int count = 0;
		for (int i = 0; i < elems.length; i++) {
			if (elems[i] == no) {
				count++;
			}
		}
		return count;
	}
	public static int[] convert(int[][] data) {
		int[] newarray =new int[data.length * data[0].length];
		int k=0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				newarray[k++] = data[i][j];
			}
		}
		return newarray;
		
	}

}
