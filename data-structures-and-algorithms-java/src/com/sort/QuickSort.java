/**
 * 
 */
package com.sort;

/**
 * @author Preyesh
 *
 */
public class QuickSort {
//	TODO add step by step printouts to make it easier to understand and read the steps the program takes to sort the array
	public static void main(String[] args) {
		/*
		 * Quick Sort: Similar to Merge Sort in that they are both divide and conquer
		 * and recursive algorithms. uses a pivot element to split arrays into two
		 * parts, left and right. elements that are less than the pivot are put to it's
		 * left, elements that are greater than the pivot are put to it's right. the
		 * pivot element will be in the correct sorted position. But the left and right
		 * arrays are not sorted yet. Then we do the same for the left and right arrays
		 * by using a new pivot element in the left and right arrays until we have 1
		 * element arrays. So every element becomes the pivot and is placed in its
		 * correct sorted position.
		 * 
		 * This is different than the Merge Sort since it doesn't create temporary
		 * arrays. So it doesn't take up as much memory as Merge Sort.
		 * 
		 * Time complexity: O(nlogn) - log to the base of 2. average case. worst case -
		 * quadratic complexity. unstable algorithm.
		 */

//		dummy data
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

		quickSorting(intArray, 0, intArray.length);

//		print out the sorted array
//		-22 -15 1 7 20 35 55 
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}

	}

	public static void quickSorting(int[] input, int start, int end) {
//		this means it is already a 1 element array and our recursion breakpoint
		if (end - start < 2) {
			return;
		}

//		position of the pivot
		int pivotIndex = partition(input, start, end);

//		recursion calls
//		Everything that is smaller than the pivot is to the left of the pivot
		quickSorting(input, start, pivotIndex);

//		Everything larger than the pivot is to the righ tof the pivot.
		quickSorting(input, pivotIndex + 1, end);

//		after quick sorting the left and right array, the whole array should be sorted.

	}

	private static int partition(int[] input, int start, int end) {
//		this is using the first element as the pivot
		int pivot = input[start];
		int i = start;
		int j = end;

//		while i and j haven't crossed
		while (i < j) {

//			this is an empty loop body to keep decrementing j to find an element that is less than the pivot or j crosses i.
			while (i < j && input[--j] >= pivot)
				;

//			if i hasn't crossed j, then we want to move j to position i. 
//			since we found the first element that is less than the pivot and need to move it 
//			this is where we move the smaller elements to the left of the pivot
			if (i < j) {
				input[i] = input[j];
			}

//			empty loop to keep incrementing i to find an element that is greater than the pivot or i crosses j.
			while (i < j && input[++i] <= pivot)
				;

//			if i hasn't crossed j, then we want to move i to position j.
//			since we found the first element that is greater than the pivot and need to move it
//			this is wehre we move the larger elements to the right of the pivot.
			if (i < j) {
				input[j] = input[i];
			}
		}
//		pivot index
		input[j] = pivot;
		return j;

	}
}
