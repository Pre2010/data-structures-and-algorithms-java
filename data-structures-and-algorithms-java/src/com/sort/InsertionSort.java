/**
 * 
 */
package com.sort;

/**
 * @author Preyesh
 *
 */
public class InsertionSort {
//	TODO add step by step printouts to make it easier to understand and read the steps the program takes to sort the array
	public static void main(String[] args) {
//		 Insertion Sort. Loops through an array and inserts the first element of the array into a new sorted array.
//			Then the loop goes to the next element in the unsorted array, compares the unsorted array element to the elements in the sorted array,
//			and inserts it into the sorted array based whether it is less than or equal to a value in the sorted array. 
//			This compare is done in the sorted array from right to left.
//			Stable algorithm		
//			quadratic time complexity : O(n^2) where n is number of items sorted

//		dummy data
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

//		Loops through intArray,unsorted array, starting at index 1
//		this is under the assumption that index 0 is already in the sorted array.
//		
		for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
//			saves the value of the current unsorted index in this variable
			int newElement = intArray[firstUnsortedIndex];

			int sortedindex;

//			loops through, compares, and finds the correct position in the sorted array
//			this will keep looping until it hits the front of the array
//			this checks to make sure that new element is less than the value in intArray
//			this is where insertion sort is happening.
			for (sortedindex = firstUnsortedIndex; sortedindex > 0
					&& intArray[sortedindex - 1] > newElement; sortedindex--) {
//				this is where we shift elements from left to right
				intArray[sortedindex] = intArray[sortedindex - 1];
			}

//			assigns the new element from above loop into newElement
			intArray[sortedindex] = newElement;

		}

//		print out the sorted array
//		-22 -15 1 7 20 35 55 
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}

	}

}
