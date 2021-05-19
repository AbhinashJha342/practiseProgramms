package randomQuestions;

public class ReverseInteger {
	
	
	private static void reverseInteger(Integer number) {
		int reversed = 0;
		while(number!=0) {
			reversed = reversed*10 + number%10;
			number = number/10;
		}
		System.out.println(reversed);
	}
	
	public static void main(String[] args) {
		reverseInteger(863);
	}

}
