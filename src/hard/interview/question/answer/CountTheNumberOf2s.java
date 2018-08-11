package hard.interview.question.answer;

/**
 * Write a method to count the number of 2s between 0 and n. Write a method to
 * count the number of 5s between 0 and n.
 * 
 * @author nitin *************************************************************
 *         Picture a sequence of numbers: 0 1 2 3 4 5 6 7 8 9 -2s come 1 times
 *         10 11 12 13 14 15 16 17 18 19 -2s come 1 times 20 21 22 23 24 25 26
 *         27 28 29 -2s come 11 times ... 110 111 112 113 114 115 116 117 118
 *         119 -2s come 1 times 120 121 122 123 124 125 126 127 128 129 -2s come
 *         11 times
 **********************************************************
 *         So, if there are X 2s between 0 and 99, then we know there are 2x
 *         twos between 0 and 199. Between 0 and 299, we have 3x twos from the
 *         last two digits, and another 100 2s from the first digit. In other
 *         words, we can look at a number like this: f(513) = 5 * f(99) + f(13)
 *         + 100
 */
public class CountTheNumberOf2s {

	public static int count2sR(int n) {
		// Base case
		if (n == 0)
			return 0;

		// 513 into 5 * 100 + 13. [Power = 100; First = 5; Remainder = 13]
		int power = 1;
		while (10 * power < n)
			power *= 10;
		int first = n / power;
		int remainder = n % power;
		// Counts 2s from first digit
		int nTwosFirst = 0;
		if (first > 2)
			nTwosFirst += power;
		else if (first == 2)
			nTwosFirst += remainder + 1;

		// Count 2s from all other digits
		int nTwosOther = first * count2sR(power - 1) + count2sR(remainder);

		return nTwosFirst + nTwosOther;
	}

	public static int count2sI(int num) {
		int countof2s = 0, digit = 0;
		int j = num, seeEndDigitNum = 0, position = 0, pow10_pos = 1;
		/*
		 * maintaining this value instead of calling pow() is an 6x perf gain (48s ->
		 * 8s) pow10_posMinus1. maintaining this value instead of calling Numof2s is an
		 * 2x perf gain (8s -> 4s). overall > 10x speedup
		 */
		while (j > 0) {
			digit = j % 10;
			int pow10_posMinus1 = pow10_pos / 10;
			countof2s += digit * position * pow10_posMinus1;
			/*
			 * we do this if digit <, >, or = 2 Digit < 2 implies there are no 2s
			 * contributed by this digit. Digit == 2 implies there are 2 * numof2s
			 * contributed by the previous position + num of 2s contributed by the presence
			 * of this 2
			 */
			if (digit == 2) {
				countof2s += seeEndDigitNum + 1;
			}
			/*
			 * Digit > 2 implies there are digit * num of 2s by the prev. position +
			 * 10^position
			 */
			else if (digit > 2) {
				countof2s += pow10_pos;
			}
			seeEndDigitNum = seeEndDigitNum + pow10_pos * digit;
			pow10_pos *= 10;
			position++;
			j = j / 10;
		}
		return countof2s;
	}

	public static void main(String[] args) {
		System.out.println(count2sR(50));
		System.out.println(count2sI(517));

	}

}
