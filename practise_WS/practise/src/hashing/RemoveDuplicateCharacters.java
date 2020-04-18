package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class RemoveDuplicateCharacters {

	//method to remove duplicate characters
	public static char[] removeDuplicates(char[] charArray) {
		HashMap<Character, CountIndex> hm = new HashMap<Character, CountIndex>(); // in () we define the capacity of hashMap,
																				  // else default capacity is used.
		for(int i=0;i<charArray.length;i++) {
			if(hm.containsKey(charArray[i]) && hm.get(charArray[i]).getCount()==1){
				charArray[i] = '\0';
			} else 
				hm.put(charArray[i], new CountIndex(i));
		}
		return charArray;
	}
	
	//method to find first non-repeating character
	public static HashMap findFirstNonRepeating(char[] charArray) {
		HashMap<Character, CountIndex> hm = new HashMap<Character, CountIndex>(); // in () we define the capacity of hashMap,
																				  // else default capacity is used.
		for(int i=0;i<charArray.length;i++) {
			if(hm.containsKey(charArray[i])){
				hm.get(charArray[i]).incCount();
			} else {
				hm.put(charArray[i], new CountIndex(i));
			}
		}
		
		
		return hm;
	}
	
	private static void forEachLoop(char[] a) {
		HashSet<Character> set = new HashSet<Character>();
		for(char x : a)
			set.add(x);
		System.out.println(set);
	}
	
	public static void main(String[] arg) {
		char[] value = {'g','e','e','k','f','o','r','g','e','e','k','s'};
		forEachLoop(value);
		System.out.println(removeDuplicates(value));
		char[] remDupValue = {'g','e','e','k','f','o','r','g','e','e','k','s'};
		HashMap<Character, CountIndex> hm = findFirstNonRepeating(remDupValue);
		int result = Integer.MAX_VALUE;
		for(int i=0;i<remDupValue.length;i++){
			if(hm.get(remDupValue[i]).getCount()==1 && result>hm.get(remDupValue[i]).getIndex()){
				result = hm.get(remDupValue[i]).getIndex();
			}
		}
		System.out.println("First non duplicate character is :"+" "+remDupValue[result]);
	}
}
