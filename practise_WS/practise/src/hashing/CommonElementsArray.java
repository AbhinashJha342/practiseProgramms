package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CommonElementsArray {
	
	private static ArrayList<Integer[]> nonRepeatingElements = new ArrayList<Integer[]>();
	
	private static Integer[] makeArrayWIthCommonElements(ArrayList<Integer[]> listOfArrays) {
		HashMap<Integer, Integer> mapOfElements = new HashMap<Integer, Integer>();
		ArrayList<Integer> commonElementsList = new ArrayList<Integer>();
		for(int i=0;i<listOfArrays.size();i++) {
			removeDuplicates(listOfArrays.get(i), listOfArrays);
		}
			for(Integer a : nonRepeatingElements.get(0))
				mapOfElements.put(a, 1);
			for(int i=1; i<nonRepeatingElements.size(); i++)
				for(Integer a : nonRepeatingElements.get(i))
					if(mapOfElements.containsKey(a)){
						commonElementsList.add(a);
					}else
						mapOfElements.put(a, 1);
		
		return commonElementsList.toArray(new Integer[(commonElementsList.size())]);
	}
	
	private static void removeDuplicates(Integer[] elementsList, ArrayList<Integer[]> listOfArrays) {
		HashSet<Integer> set = new HashSet<Integer>();
			for(int a : elementsList)
				set.add(a);
			nonRepeatingElements.add(set.toArray(new Integer[set.size()]));
	}

	public static void main(String[] args) {
		ArrayList<Integer[]> listOfArrays = new ArrayList<Integer[]>();
		Integer[] A = {2, 5, 3, 2, 8,1}; 
		Integer[] B = {7, 9, 5, 2, 4, 10, 10}; 
		Integer[] C = {6, 7, 5, 5, 3, 7};
		listOfArrays.add(A);
		listOfArrays.add(B);
		listOfArrays.add(C);
		Integer[] nonRepeatingElements = makeArrayWIthCommonElements(listOfArrays);
		System.out.println(Arrays.toString(nonRepeatingElements));
	}
}
