package randomQuestions;

import java.util.function.Predicate;

public class UpperCaseHChar {

	private static boolean isCorrectUpperChar(String str) {
		Predicate<Character> isUpperChar = Character::isLowerCase;
		
		if(Character.isUpperCase(str.charAt(0)) &&
				Character.isUpperCase(str.charAt(1))) {
			isUpperChar = Character::isUpperCase;
		}
		
		for(int i=1;i<str.length();i++) {
			if(!isUpperChar.test(str.charAt(i))) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		System.out.println(isCorrectUpperChar("UAs"));
	}
	
}
