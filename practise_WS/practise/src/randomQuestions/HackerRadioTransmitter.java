package randomQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HackerRadioTransmitter{
	
	static List<Integer> trnsmsnList=new ArrayList<Integer>();
	
	//CompletethehackerlandRadioTransmittersfunctionbelow.
	static int hackerlandRadioTransmitters(int[] x, int k){
		Arrays.sort(x);
		int temp= x[0];
		if(x.length==1){
			return 1;
		}
		for(int i=1;i<x.length;i++){
			if(x[i]-temp==k){
				if(trnsmsnList.isEmpty()||!trnsmsnList.contains(temp)){
					trnsmsnList.add(x[i]);
					temp=x[i];
				}else{
					if(i+1<x.length && x[i]!=x[i+1]){
						temp=x[i+1];
					}
				}
			}else if(x[i]-temp>k){
				temp=x[i-1];
				if(trnsmsnList.isEmpty() || temp-trnsmsnList.get(trnsmsnList.size()-1)>k){
					trnsmsnList.add(x[i-1]);
				}
			}
			
			if(i==x.length-1&&(trnsmsnList.isEmpty()||x[i]-trnsmsnList.get(trnsmsnList.size()-1)>k)){
				trnsmsnList.add(x[i]);
			}
		}
		return trnsmsnList.size();
}

	public static void main(String[] args){
		int[]subArray={2,5,9,1,12,3,12,45,2,7,4,8,9,10,14,17,18,23,26,29,31,7,18,92,100,19834,1,234,89,92,9,93,1001,887,19,23,65,18263,17,11,1111,87,23,4,345,
				1010,1012,1029,1034,1024,1054,1078,213,56475,998743,990,14356,111,112,113,5463,99,5643,66};
		System.out.println(hackerlandRadioTransmitters(subArray, 40));
	}

}
