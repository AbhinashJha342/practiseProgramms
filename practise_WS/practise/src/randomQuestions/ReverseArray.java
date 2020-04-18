package randomQuestions;

import java.util.ArrayList;
import java.util.List;

public class ReverseArray {

	static void reverArray(char[] arrayToReverse) {
		List<Character> reverseList = new ArrayList<Character>();
		int j=0;
		for(int i=0;i<arrayToReverse.length;i++) {
			if(arrayToReverse[i]!=' '){
				reverseList.add(j, arrayToReverse[i]);
				j++;
			}else {
				reverseList.add(0, arrayToReverse[i]);
				j=0;
			}
		}
	}
	
	public static void main(String[] args) {
		char[] characters = {'o','n','e',' ','t','w','o'};
		reverArray(characters);
	}
}
