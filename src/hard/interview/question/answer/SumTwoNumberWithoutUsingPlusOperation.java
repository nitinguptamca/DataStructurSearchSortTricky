package hard.interview.question.answer;



public class SumTwoNumberWithoutUsingPlusOperation {
	
	int add_no_arithm(int a, int b) {
		if (b == 0)
			return a;
		int sum = a ^ b; // add without carrying
		System.out.println("sum  "+sum);
		int carry = (a & b) << 1; // carry, but don’t add
		System.out.println("carry   "+carry);
		return add_no_arithm(sum, carry); // recurse
	}

	public static void main(String[] args) {
		int a = 849;
		int b = 986;
		SumTwoNumberWithoutUsingPlusOperation sumNumberWithoutPlus=new SumTwoNumberWithoutUsingPlusOperation();
		System.out.println("add to values   :" + sumNumberWithoutPlus.add_no_arithm(a, b));
		
		System.out.println(" a "+Integer.toBinaryString(a));
		System.out.println("  b  "+Integer.toBinaryString(b));
		System.out.println(Integer.parseInt(Integer.toBinaryString(a), 2));
		System.out.println(Integer.parseInt(Integer.toBinaryString(b), 2));
 
	}

}
