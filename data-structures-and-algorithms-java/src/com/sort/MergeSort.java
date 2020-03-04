/**
 * 
 */
package com.sort;

/**
 * @author Preyesh
 *
 */
public class MergeSort {
//	TODO add step by step printouts to make it easier to understand and read the steps the program takes to sort the array
	public static void main(String[] args) {
		/*
		 * Merge Sort. It is a divide and conquer, you split up the array into smaller
		 * pieces but don't actually create new arrays, and a recursive algorithm with
		 * two phases: Splitting and Merging.
		 * 
		 * Splitting speeds up sorting during the Merging phase. Splitting does not
		 * create new arrays, it keeps track of its indices. Splitting phase: begins
		 * with splitting the array into two arrays, left array and right array. then
		 * it'll keep splitting the array in half by left and right array until each
		 * array has one element.
		 * 
		 * This begins the Merging phase. Merging phase: merge will start merging 1 left
		 * array pair to make it a 2 element array. when merging happens, it sorts the
		 * elements. we do the same to the right array pair and keep doing that for both
		 * left and right until we have 1 array that is sorted. we do this by using
		 * recursion. we use temporary arrays when doing the merging and splitting. once
		 * we have 1 sorted array, we start overwriting the original with the sorted
		 * array.
		 * 
		 * time complexity: O(nlogn) - log to the base 2.
		 */

//		dummy data
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

		mergeSorting(intArray, 0, intArray.length);

//		print out the sorted array
//		-22 -15 1 7 20 35 55 
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}

	}

	public static void mergeSorting(int[] input, int start, int end) {
//		break point for recursion
//		this means we have a 1 element array
		if (end - start < 2) {
			return;
		}

//		we partition the array by creating a mid point
		int mid = (start + end) / 2;
		/*
		 * so below at the first instance of the recurison will be mergeSort(input, 0,
		 * 3); input being the intArray above. so this will form the left array and the
		 * remainder of elements not in 0 - 3 range, will be in the right array left
		 * array = 20, 35, -15
		 */
		mergeSorting(input, start, mid);

//		right array = 7, 55, 1, -22
//		this will be called after the left array mergeSort has been fully partitioned
		mergeSorting(input, mid, end);

//		merge method to merge the left and right arrays
//		this will be called after both arrays, left and right, have been split into 1 element arrays.
		merge(input, start, mid, end);

	}

//		method to merge the sorted arrays
	private static void merge(int[] input, int start, int mid, int end) {
//		if left midpoint element is less than or equal to right midpoint element, that means the array is sorted and we don't need to merge.
//		input[mid - 1] is the last element of the left partition, input[mid] is the first element of the right partition
		if (input[mid - 1] <= input[mid]) {
			return;
		}

//		
		int i = start;
		int j = mid;
		int tempIndex = 0;

//		temp array, large enough to hold the left and right array.
		int[] temp = new int[end - start];

		/*
		 * loop through the left and right array while i, i being the left array, is
		 * less than mid AND j, j being the right array, is less than end, keep
		 * comparing to see which value from the left and right array is smaller and add
		 * it to the temp array, then incremenet the position of the smaller value
		 * array. this while loop will exit out once we have gone through one of the
		 * arrays, which will leave some elements in one array that hasn't been sorted
		 * yet.
		 */
		while (i < mid && j < end) {
			temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
		}

		/*
		 * this will handle the remaining elements that we didn't go through in the
		 * while loop. only handles the left array, since the right array should already
		 * be sorted since they are greater than the left array and don't need to change
		 * positions. System.arraycopy(source array, position at which we start our
		 * copy, destination array, destination at which we copy to, number of elements
		 * we didn't copy over); we just directly copy from the temp array to the
		 * original array, to the position where'd they would end up
		 */
		System.arraycopy(input, i, input, start + tempIndex, mid - i);

//		copy over the temp array to the original array
//		System.arraycopy(source array, position at which we start our copy, destination array, destination at which we copy to, number of elements we didn't copy over);
		System.arraycopy(temp, 0, input, start, tempIndex);
	}

}
