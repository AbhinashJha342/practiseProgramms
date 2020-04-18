package randomQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dog extends Animal{
	
	static Set<String> subStrSet = new HashSet<String>();
	static List<String> dummyList = new ArrayList<String>();

	static void doStuff() {
		System.out.println("d");
	}
	
	public static void main(String... args) {
//		double d = 1_00_0000.00;
//		String s;
//		Animal[] a = {new Animal(), new Dog()};
//		for(Animal an: a) {
//			an.doStuff();
//		}
		String x = "abcabcddd";
		dummyList.add("abc");
		dummyList.add("a");
		dummyList.add("c");
		dummyList.add("abc");
		dummyList.add("bc");
		dummyList.add("abc");
		for(int i=0;i<x.length();i++) {
			if(i==0) {
				subStrSet.add(x.substring(0, i+1));
			}
			else {
				subStrSet.add(x.substring(i, i+1));
				subStrSet.add(x.substring(0,i+1));
				for(int j=1;j<i;j++) {
					subStrSet.add(x.substring(j,i+1));
				}
			}
		}
		System.out.println(dummyList.indexOf("abc"));
		System.out.println(subStrSet.contains("abc"));
		System.out.println(subStrSet.toString());
	}
}
