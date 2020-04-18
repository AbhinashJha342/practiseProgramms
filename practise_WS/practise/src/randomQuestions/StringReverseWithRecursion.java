package randomQuestions;

public class StringReverseWithRecursion {

	private static StringBuffer plusOnePosString = new StringBuffer();
	
	private StringBuffer plusOneStringPos(String word) {
		plusOnePosString = plusOnePosString.append(word.substring(1)).append(word.charAt(0));
		return plusOnePosString;
	}
	
	private String reverseString(String word) {
		String reversedString = "";
		if(word.length()==1)
			return word;
		reversedString = reversedString +(reverseString(word.substring(1))) + (word.charAt(0));
		return reversedString;
	}
	
	
	public static void main(String[] args){
		StringReverseWithRecursion recursion = new StringReverseWithRecursion();
		StringBuffer plusOnePos = recursion.plusOneStringPos("abcd");
		System.out.println(plusOnePos.toString());
		System.out.println(recursion.reverseString("abcd"));
	}
}
