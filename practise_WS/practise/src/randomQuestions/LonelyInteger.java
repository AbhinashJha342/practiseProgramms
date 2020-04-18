package randomQuestions;

import java.util.HashMap;
import java.util.Map;

public class LonelyInteger {

	private static Map<String, Integer> uniqueInt = new HashMap<String, Integer>();
	
	static int lonelyinteger(int[] a) {
		int end =0;
		for(int i=0; i<=a.length-1;i++) {
			end=i+1;
			while(end<=a.length){
				if(a[i]==a[end]){
					uniqueInt.put(Integer.toString(a[end]), a[i]);
					break;
				}
				end++;
			}
			if(uniqueInt.containsValue(a[i])) {
				uniqueInt.put("unique", a[i]);
			}
		}
		
		return uniqueInt.get("unique");
    }
}
