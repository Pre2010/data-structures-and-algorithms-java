/**
 * 
 */
package com.sort;

/**
 * @author Preyesh
 *
 */
public class RadixSort {

	public static void main(String[] args) {
		/*
		 * Radix = number of unique digits or values if we are dealing with characters,
		 * that a numbering system or alphabet has. Example: English alphabet, radix =
		 * 26. Decimal system, radix = 10. Binary, radix = 2. Width = length of data
		 * Radix Sort: makes assumptions about the data, data must have same radix and
		 * width. Sorts integers and strings, based on each individual digit or letter
		 * position. Starts on the right most position. must use a stable sort algorithm
		 * at each stage
		 * 
		 * Example: for the below array, for 4725, the individual digit we will start
		 * sorting with it 5 or the 1's position. for the next number in the array,
		 * 4589, the individual digit we will sort by is 9, and so on. until the sorted
		 * array based on the first rightmost position looks like this: intArray =
		 * {1330,8792,1594,4725,4589,5729} Then we will move to the 2nd rightmost
		 * position which is the 10's position and so on.
		 * 
		 * this doesn't undo any of the sorting done in the previous phases. the sorting
		 * in previous phases are persistent.
		 * 
		 * This is a stable version of Counting Sort Time complexity: O(n) though it can
		 * run at O(nlogn) due to overhead. in place algorithm depending on the sort
		 * algorithm
		 */

//		dummy data
		int[] intArray = { 4725, 4589, 1330, 8792, 1594, 5729 };

		radixSorting(intArray, 10, 6);

//		print out the sorted array
//		 1330 1594 4589 4725 5729 8792 
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}
	}

	public static void radixSorting(int[] input, int radix, int width) {
//		
		for (int i = 0; i < width; i++) {
			/*
			 * Starts with the rightmost position, then move to the left. Right to left. we
			 * call radixSingleSort on each of our positions.
			 * 
			 */
			radixSingleSort(input, i, radix);
		}
	}

	public static void radixSingleSort(int[] input, int position, int radix) {
//		number of items we will be sorting
		int numItems = input.length;

//		count array to hold all of our values
		int[] countArray = new int[radix];

//		for every value in our input array, 
//		count how many values have a certain digit at whatever position we are currently looking at
		for (int value : input) {
			countArray[getDigit(position, value, radix)]++;
		}

		/*
		 * Adjust the count array. This is how this becomes a stable sort Each position,
		 * other than 0, will have a count of how many positions have that digit or
		 * less. so we sum upto that digit or less on the digit we are working on.
		 * 
		 * We don't worry about 0 in the first index since the number of values for zero
		 * or less will be zero and won't change
		 */
		for (int j = 1; j < radix; j++) {
			countArray[j] += countArray[j - 1];
		}

//		this is the temp array to copy the values to.
		int[] temp = new int[numItems];

//		in this example,  since we have 6 elements, tempIndex = 5.
		for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
//			using the prefix operator, we subtract one from the countArray and use that as our index.
//			we are writing right to left to preserve ordering of duplicates.
			temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
		}

//		we copy from the sorted temp array to the input array
		for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
			input[tempIndex] = temp[tempIndex];
		}
	}

	public static int getDigit(int position, int value, int radix) {
		/*
		 * (int) = int casting Math.pow() method takes the first param and raises it to
		 * the second param, then after division is done, we mod that with the radix
		 * Example: 4725 / (int)Math.pow(10, 0) = 1, 4725 / 1 = 4725, 4725 % 10 = 472
		 * with a remainder of 5. So we return 5.
		 * 
		 */
		return value / (int) Math.pow(radix, position) % radix;
	}
}
