/**
 * 
 */
package com.recursion;

/**
 * @author Preyesh
 *
 */
public class FactorialRecursion {
//	TODO add step by step printouts to make it easier to understand and read the steps the program takes to sort the array
	public static void main(String[] args) {
		System.out.println(recursiveFactorial(3));
		System.out.println(iterativeFactorial(3));
	}

	/*
	 * #! - is how we denote factorial 1! = 0! * 1 = 1 2! = 2 * 1, which is
	 * equivalent to = 2 * 1! 3! = 3 * 2 * 1, which is equivalent to = 3 * 2! 4! = 4
	 * * 3 * 2 * 1, which is equivalent to = 4 * 3! 5! = 5 * 4 * 3 * 2 * 1, which is
	 * equivalent to = 5 * 4!
	 * 
	 * n! = n * (n - 1)!
	 */

	/*
	 * recursive approach to factorial this does the same approach as below but
	 * instead of using a for loop, it uses recursion. example, say num = 3 it'll go
	 * past the if statement and do "3 * recursiveFactorial(3 - 1);", but it has to
	 * wait until the function "recursiveFactorial(3 - 1)" is completed before it
	 * can return the value, so num = 3 recursion will be put on the call/recursion
	 * stack next recursion is num = 2 from "recursiveFactorial(3 - 1)", where it'll
	 * do the same as the previous recursion so it'll be
	 * "2 * recursiveFactorial(2 - 1)", so it'll be put on the call/recursion stack
	 * and it'll wait until next recursion is done "recursiveFactorial(2 - 1)" will
	 * do the same as the previous two recursions. so the next recursion will be
	 * "recursiveFactorial(1 - 1)" which is "recursiveFactorial(0)" here it'll go
	 * into the if statement and return 1. this will end "recursiveFactorial(0)" and
	 * go back into "recursiveFactorial(2 - 1)" to complete it, and so on until it
	 * goes back into "recursiveFactorial(3 - 1)" and completes it.
	 */
	/*
	 * recursion for the call/recursion stack goes in reverse order. Once it
	 * completes a recursion, it removes it from the call/recursion stack.
	 * call/recursion stack order for above example: recursiveFactorial(0)
	 * recursiveFactorial(1) recursiveFactorial(2) recursiveFactorial(3)
	 */
	public static int recursiveFactorial(int num) {
//		breaking condition to start going through the call/recursion stack
//		and completing the recursion functions
		if (num == 0) {
			return 1;
		}

//		calling itself
		return num * recursiveFactorial(num - 1);
	}

//	iterative approach to factorial
	public static int iterativeFactorial(int num) {

		if (num == 0) {
			return 1;
		}

//		factorial is set to 1 and is updated as it goes trhough the loop and then returns it once i is less than or equal to num.
		int factorial = 1;
		for (int i = 1; i <= num; i++) {
			factorial *= i;
		}

		return factorial;
	}

}
