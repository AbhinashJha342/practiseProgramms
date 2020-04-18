package randomQuestions;

import java.util.HashSet;
import java.util.Set;

public class SubstringCount {

	static Set<String> subStringSet = new HashSet<String>();
	
	private static int subStringCount(String s, int start, int end) {
		if(start==end) {
			return 1;
		} else {
			subStringSet.add(Character.toString(s.charAt(start)));
			Set<String> tempSubSet = new HashSet<String>();
			tempSubSet = subStringSet;
			for(int i=start+1;i<=end;i++) {
				for(String temp : tempSubSet) {
					subStringSet.add(s.charAt(i)+temp);
				}
				tempSubSet = subStringSet;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		subStringCount("aabaa", 1, 4);
		
	}
}
