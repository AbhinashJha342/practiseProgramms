package randomQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidString {
	
	static String isValid(String s) {
		//boolean isSimilar = false;
		//char temp;
		int count=1;
		boolean addChars = false;
		int differnetNums =0;
		StringBuilder dummyString = new StringBuilder(s);
		List<Character> validatedChars = new ArrayList<Character>();
		List<Integer> numberCount = new ArrayList<Integer>(); 
		
		int z;
		int x = 0;
		
		//compare and store the comparison result of each char for the primary substring
				for(; x<dummyString.length()-1;x++) {
					z=x+1;
					int start = (int) s.charAt(x);
					for(;z<dummyString.length();z++) {
						int end = (int) s.charAt(z);
						if(validatedChars.contains(s.charAt(x))) {
							addChars = false;
							break;
						} else if(!validatedChars.contains(s.charAt(x)) && start==end){
							count++;
							addChars = true;
						}
					}
					if(addChars || !validatedChars.contains(s.charAt(x))) {
						validatedChars.add(s.charAt(x));
						if(!numberCount.contains(count))
							differnetNums++;
						numberCount.add(count);
						count=1;
						addChars=false;
					}
				}
				
				if(!validatedChars.contains(s.charAt(x))){
					validatedChars.add(s.charAt(x));
					if(!numberCount.contains(count))
						differnetNums++;
					numberCount.add(count);
				}
		
		if(differnetNums>2) {
			return "NO";
		} else {
			int max = Collections.max(numberCount);
			int min = Collections.min(numberCount);
			if(numberCount.lastIndexOf(min)!=numberCount.indexOf(min)
					&& numberCount.lastIndexOf(max)!=numberCount.indexOf(max)) {
				return "NO"; 
			} else if(max-min<2) {
				return "YES";
			} else
				return "NO";
		}
	}
	
	
	public static void main(String[] args) {
		//System.out.println(isValid("aabbcd"));
		String[] aliasName = null;
		String temp = "name-1";
		aliasName = temp.split("-");
		if(aliasName[1].equals("1")) {
			System.out.println("inside if block");
		}
	}
}
