package hard.interview.question.answer;

import java.util.Iterator;

public class EqualProbabilityOfBeingChosen {

	/* Random number between lower and higher, inclusive */
	public static int rand(int lower, int higher) {

		return lower + (int) (Math.random() * (higher - lower + 1));
	}

	/*
	 * pick M elements from original array. Clone original array so that we don’t
	 * destroy the input.
	 */
	public static int[] pickMRandomly(int[] original, int m) {
		int[] subset = new int[m];
		int[] array = original.clone();
		for (int j = 0; j < m; j++) {
			int index = rand(j, array.length - 1);
			subset[j] = array[index];
			System.out.println(
					"j  " + j + "  array[j] " + array[j] + " index " + index + "  array[index] " + array[index]);
			array[index] = array[j]; // array[j] is now “dead”
		}
		return subset;
	}

	public static void main(String[] args) {
		int[] cards = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		int[] subset = pickMRandomly(cards, 13);
		for (int i : subset) {
			System.out.print(i + "   ");
		}
	}

}
