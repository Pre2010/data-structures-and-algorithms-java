/**
 * 
 */
package com.sort;

/**
 * @author Preyesh
 *
 */
public class ShellSort {
//	TODO add step by step printouts to make it easier to understand and read the steps the program takes to sort the array
	public static void main(String[] args) {
		/*
		 * Shell Sort. Variation of Insertion Sort. Compares elements that are farther
		 * apart from one another. Could also improve Bubble Sort using this. Named
		 * after Robert Shell, computer scientist. After each comparison, decreases teh
		 * distance or gap at which elements are compared. The last gap value is 1 which
		 * is when Insertion Sort occurs. Shell Sort does some preliminary work before
		 * it becomes an Insertion Sort. This helps decrease the amount of shifting
		 * involved if we just did Insertion Sort since the array will already be
		 * sorted to an extent.. https://en.wikipedia.org/wiki/Shellsort#Gap_sequences
		 * The Wikipedia page for Shell Sort has a table of gaps and their time
		 * complexities Time complexity depends on what gap sequence you use. Unstable
		 * algorithm
		 * 
		 * Gap Sequence here will be : index.length / 2
		 * 
		 */

//		dummy data
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

//		setting up the gap sequence to loop over
		for (int gap = intArray.length / 2; gap > 0; gap /= 2) {
//			loop through all elements in the array
			for (int i = gap; i < intArray.length; i++) {
//				saves the value of the current unsorted index in this variable 
				int newElement = intArray[i];

				int j = i;

//				while it has not gone to the front of the array AND array element is larger than new element, 
//				shift elements
				while (j >= gap && intArray[j - gap] > newElement) {
					intArray[j] = intArray[j - gap];
					j -= gap;
				}
//				assigns the new element from above loop into newElement
				intArray[j] = newElement;
			}
		}

//		print out the sorted array
//		-22 -15 1 7 20 35 55 
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}

	}

}
