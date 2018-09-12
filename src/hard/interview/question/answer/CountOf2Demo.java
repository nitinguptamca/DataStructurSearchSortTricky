package hard.interview.question.answer;

public class CountOf2Demo {

	public static void main(String[] args) {
		System.out.println(countOf2n(519));

	}

	private static int countOf2n(int i) {
		int num = i, position = 0, remainder = 0, Powerof10_pos = 1, endDigit = 0, countOf2 = 0;
		while (num > 0) {
			remainder = num % 10;
			int Powerof10_pos_tmp = Powerof10_pos / 10;
			countOf2 += remainder * position * Powerof10_pos_tmp;
			if (remainder == 2) {
				countOf2 = endDigit + 1;
			} else if (remainder > 2) {
				countOf2 += Powerof10_pos;
			}else {
				countOf2 += 0;
			}
			
			endDigit =endDigit+remainder+Powerof10_pos;
			Powerof10_pos *= 10;
			position++;
			num=num/10;
		}

		return countOf2;
	}

}
