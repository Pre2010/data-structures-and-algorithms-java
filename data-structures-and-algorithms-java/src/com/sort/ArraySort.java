package com.sort;

import java.util.Arrays;

public class ArraySort {

	public static void main(String[] args) {
//			dummy data
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
		
//		using the Arrays class to sort

//		this one uses Dual Pivot sort
//		Arrays.sort(intArray);
		
//		This one uses a parallel merge sort that splits arrays into sub arrays
//		and then uses quick sort to put them back into a single array
		Arrays.parallelSort(intArray);

//			print out the sorted array
//			-22 -15 1 7 20 35 55 
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}

	}

}
