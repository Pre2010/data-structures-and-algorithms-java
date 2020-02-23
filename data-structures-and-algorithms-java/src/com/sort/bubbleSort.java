package com.sort;

/**
 * @author Preyesh
 *
 */
public class bubbleSort {

	public static void main(String[] args) {
//		 Bubble sort algorithm. Considered a stable sort algorithm
//			Bubble sort algorithm takes the first index and compares it to the next index so see if the first index is larger. 
//			If so, swaps places with it and continues to do the same for the rest of the array.
//			If it is equal, it does not swap places and goes on to the index after the one that was just compared.
//			Quadratic time coimplexity: O(n^2) where n is number of items sorted
		
//		dummy data
		int[] intArray = {20,35, -15, 7, 55, 1, -22};
		
//		outer loop. loop through each index in the array
		for(int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
//		inner loop.	iterate through each index in the array using the swap method
//			with the current index value being the index at which the outer loop is at
//			this is where the bubble sort is happening
			for(int i = 0; i < lastUnsortedIndex; i++) {
				if (intArray[i] > intArray[i + 1]) {
					swap(intArray, i, i+1);
				}
			}
		}
		
//		print out the sorted array
//		-22 -15 1 7 20 35 55 
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}
		

	}
	
//	swap method for switching out values in the array for the bubble sort
	public static void swap(int[] array, int indexCurrent, int indexNext) {
		
//		if current index is equal to the next index, do nothing
		if(indexCurrent == indexNext) {
			return;
		}
		
//		temp variable, to be used to swap with indexNext
//		then sets temp to position of current index in the array
//		sets value current index to position of the next index 
//		and then sets the value of next index to the temp variable position
		int temp = array[indexCurrent];
		array[indexCurrent] = array[indexNext];
		array[indexNext] = temp;
		
	}

}
