/**
 * 
 */
package com.sort;

/**
 * @author Preyesh
 *
 */
public class CountingSort {
//	TODO add step by step printouts to make it easier to understand and read the steps the program takes to sort the array
	public static void main(String[] args) {
/*		Counting Sort: makes assumptions about data, doesn't use comparisons (<, >), counts the occurrences of of each value,
 * 			only works with non-negative discrete values ( not float or strings), values must be in a specific range.
 * 			we have two arrays, the original array and the counting array which will hold the occurrences of the numbers found in the original array.
 * 			So two phases,
 * 			1st phase: count the occurrences and add them to a separate counting array. 
 * 			2nd phase: then go through the counting array and put them in the original array
 * 		 	
 * 		Example: for an array with 10 elements, the counting array will also have 10 elements.
 * 			after getting all of the occurrences into the counting array, we go through the counting array and overwrite the original array.
 * 		
 * 		Example: intArray = {2,5,9,8,2,8,7,10,4,3} countingArray = {0,2,1,1,1,0,1,2,1,1}
 * 			the first 0 is because there isn't a 1 in the intArray and does not get put into the intArray. 
 * 			the next number in the countingArray is the occurrence of 2 in the intArray, so it will get put into the intArray
 * 			{2,2,......}, next coutingArray has 1 occurrence of 3 so intArray will be {2,2,3,......}, and so on and so on.
 * 			So by overwriting the original array using the counting array occurrences, we get intArray = {2,2,3,4,5,7,8,8,9,10}
 * 			
 * 		Time complexity: O(n)
 * 		This implementation of the Counting Sort is unstable.
 * 		The algorithms: bubble, selection, insertion, shell, merge, and quick sorts haven't made assumptions about the data. 
 * 		So we can use just about any data type with them.
 * 
 */
		
//		dummy data
		int[] intArray = {2,5,9,8,2,8,7,10,4,3};	
		
		countSort(intArray, 1, intArray.length);		
		
//		print out the sorted array
//		2 2 3 4 5 7 8 8 9 10 
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}

	}
	
	public static void countSort(int[] input, int min, int max) {
		
//		array to hold the occurrences
		int[] countArray = new int[(max - min) + 1];
		
//		looping through the original array and add occurrences of numbers to the counting array. 
		for(int i = 0; i < input.length; i++) {
//			this increments an occurrence by one and adds it in the correct position in the array.
//			Example: if we are looping and the number from input[i] is 3 and min is 1,
//				then countArray[3-1] = countArray[2]++. This will put the occurrence of the number 3 in
//				index 2 and increment the occurrence by 1.
			countArray[input[i] - min]++;
		}
		
//		this is where we "sort" the original array by writing into it using the countArray occurrences.
//		j = the index at which we are writing back to the original array
		int j = 0;
		
		
		for(int i = min; i <= max; i++) {
//			this is where we go through the occurrences of the count array and add it to the original array
//			Example: going by the original array and the occurrences of 2's we have,countArray[1], we should put two 2's in the 
//				original array. the while loop helps with this, while we have an occurrence of 2, add it to the
//				original array and increment the j, which is our index of the original array that we are writing to.
//				Then we decrement the occurrence of the two 2's and go exit out of the while loop into the for loop which
//				will increment i and repeat the process of inside the while loop.
				
			while(countArray[i - min] > 0) {
				input[j++] = i;
				countArray[i - min]--; 
			}
		}
		
		
	}

}
