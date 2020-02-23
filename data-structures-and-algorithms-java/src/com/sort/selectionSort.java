/**
 * 
 */
package com.sort;

/**
 * @author Preyesh
 *
 */
public class selectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		 Selection Sort. Goes through an array, selects the first index and compares it to the rest of the array, once it finds a larger value,
//			it becomes the number to compare by until it finds another larger number and so on. 
//			Once that is complete and the largest number has been compared to all of the numbers in the array,
//			it swaps positions with the last number in the array. Rinse and repeat.
//			Unstable algorithm. Requires less swapping than bubble sort.
//			quadratic time complexity : O(n^2) where n is number of items sorted
		
//		dummy data
		int[] intArray = {20,35, -15, 7, 55, 1, -22};
		
//		outer loop. loop through each index in the array
		for(int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			
//			temp variable to hold the largest value
			int largest = 0;
//		inner loop.	iterate through each index in the array using the swap method
//			with the current index value being the index at which the outer loop is at
//			this loop will compare and update the largest variable for if the loop finds a larger value than it.
//			largest isn't the actual number but that number's index
//			this is where the selection sort is happening
			for(int i = 1; i <= lastUnsortedIndex; i++) {
				if (intArray[i] > intArray[largest]) {
					largest = i;
					
				}
			}
			swap(intArray, largest, lastUnsortedIndex);
		}
		
//		print out the sorted array
//		-22 -15 1 7 20 35 55 
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}

	}
		
//		swap method for switching out values in the array for the bubble sort
		public static void swap(int[] array, int indexCurrent, int indexNext) {
			
//			if current index is equal to the next index, do nothing
			if(indexCurrent == indexNext) {
				return;
			}
			
//			temp variable, to be used to swap with indexNext
//			then sets temp to position of current index in the array
//			sets value current index to position of the next index 
//			and then sets the value of next index to the temp variable position
			int tempIndex = array[indexCurrent];
			array[indexCurrent] = array[indexNext];
			array[indexNext] = tempIndex;
			
		}
		
}

