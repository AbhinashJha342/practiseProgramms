package randomQuestions;

public class ReverseWord {

	
	private static String reverseWord(String s) {
		String updated = s.trim();
		if(!updated.contains(" ")) {
			return updated;
		}
		String[] seperatedStrings = updated.split(" ");
		StringBuffer finalString = new StringBuffer();
		for(int i=seperatedStrings.length-1;i>=0;i--) {
			if(seperatedStrings[i].length()!=0) {
				finalString.append(seperatedStrings[i]+" ");
			}
		}
		
		return finalString.toString().trim();
	}
	
	public static void main(String[] args) {
		System.out.println(reverseWord("  hello world  "));
	}
}
