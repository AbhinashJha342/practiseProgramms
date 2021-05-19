package randomQuestions;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	private static void indexofSum(int[] arr, int sum) {
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++) {
			
			if(!indexMap.isEmpty()) {
				if(arr[i]<sum && indexMap.containsKey(sum-arr[i])) {
					System.out.println("index of two numbers are::"+i+" "+indexMap.get(sum-arr[i]));
					return;
				} else {
					indexMap.put(arr[i], i);
				}
				
			} else {
				indexMap.put(arr[i], i);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] myArray = {2,3,7,4,8};
		indexofSum(myArray, 7);
	}
}
