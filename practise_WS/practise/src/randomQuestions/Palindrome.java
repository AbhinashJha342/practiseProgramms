package randomQuestions;

public class Palindrome {

	private static void isPalindrome(String str) {
		boolean isPld = true;
		
		for(int i=0,j=str.length()-1;i<=j;i++,j--) {
			if(str.charAt(i)!=str.charAt(j)) {
				isPld = false;
				break;
			}
		}
		
		if(isPld) {
			System.out.println("is palindrome");
		}else {
			System.out.println("not palindrome");
		}
		
	}
	
	public static void main(String[] args) {
		Palindrome.isPalindrome("Madam");
	}
}
