package hard.interview.question.answer;
/**
 * Write a method to shuffle a deck of cards. It must be a perfect shuffle - 
 * in other words, each 52! permutations of the deck has to be equally likely. 
 * Assume that you are given a random number generator which is perfect.
 * @author nitin
 * we could randomly selecting items and put them into a new array. We must make 
 * sure that we don’t pick the same item twice though by somehow marking the node as dead.
 * 				Array: [1] [2] [3] [4] [5]
 *  Randomly select 4: [4] [?] [?] [?] [?]
 *  Swap dead element: [X] [2] [3] [1] [5]
 *  
 *  			Array: [X] [2] [3] [1] [5]
 *  Randomly select 3: [4] [3] [?] [?] [?]
 *  Swap dead element: [X] [X] [2] [1] [5]
 *
 */

public class PerfectShuffle {
	
	public static void shuffleArray(int[] cards) {
		 int temp, index;
		 for (int i = 0; i < cards.length; i++){
		 index = (int) (Math.random() * (cards.length - i)) + i;
		 temp = cards[i];
		 cards[i] = cards[index];
		 cards[index] = temp;
		 }
	 }

	public static void main(String[] args) {
		int[] cards= {1,2,3,4,5,6,7,8,9,10,11,12,13};
		PerfectShuffle.shuffleArray(cards);
		for (int i : cards) {
			System.out.println("\n cards   "  +i);
		}

	}

}
