package randomQuestions;

public class LongestPalindrome {

	
	private static int startIndex;
	private static int length;
	
	
	private static String lngstPalindrome(String str) {
		int strLength = str.length();
		
		if(strLength<2) {
			return str;
		}
		
		for(int i=0;i<str.length()-1;i++) {
			countPalindrome(str, i, i);
			countPalindrome(str, i, i+1);
		}
		
		return str.substring(startIndex, startIndex+length);
		
	}
	
	
	private static void countPalindrome(String str, int begin, int end) {
		while(begin>=0 && end<str.length() && Character.toUpperCase(str.charAt(begin)) == Character.toUpperCase(str.charAt(end))) {
			begin--;
			end++;
		}
		
		if(length<(end-begin-1)) {
			startIndex = begin+1;
			length = end-begin-1;
		}
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(lngstPalindrome("madamoAbccba"));
	}
}
