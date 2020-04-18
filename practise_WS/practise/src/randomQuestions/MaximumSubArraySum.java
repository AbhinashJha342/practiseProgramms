package randomQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumSubArraySum {
	
	//Set<Integer> integerSet = new HashSet<Integer>();
	static ArrayList<Long> subArrayList = new ArrayList<Long>();
	static Set<Long> sumSet = new HashSet<Long>();
	static int loopCount = 0;
	
	static long maximumSum(long[] array, long m) {
		long individualSum=0;
		long totalSum=0;
		
		for(int i=0;i<array.length;i++) {
			int z=0;
			individualSum=array[i];
			totalSum+=array[i];
			sumSet.add(individualSum%m);
			subArrayList.add(array[i]);
			for(int j=i+1;j<array.length;j++) {
				sumSet.add((individualSum+array[j])%m);
				subArrayList.add(array[j]);
				if(j==array.length-1) {
					while(subArrayList.size()-z>3) {
						subArraySum(i,m,++z);
					}
				}
			}
			subArrayList.clear();
			System.out.println(loopCount++);
		}
		System.out.println("Before adding to set");
		sumSet.add((totalSum)%m);
		List<Object> listOfSum = Arrays.asList(sumSet.toArray());
		System.out.println("Before returing");
		return (long) listOfSum.get(listOfSum.size()-1);
    }
	
	
	private static void subArraySum(int i,long m, int y) {
		int k=subArrayList.size()-y,j=0;
		long subArraySum = 0;
		if(y!=1) {
			for(j = k+1; k>0 && j<subArrayList.size(); k--,j--) {
				for(long x : subArrayList) {
					int index = subArrayList.lastIndexOf(x);
					if(!(index>=k && index<=j)) {
						subArraySum+=x;
					}
				}
				sumSet.add(subArraySum%m);
				subArraySum=0;
			}
		} else {
			while(k>0) {
				for(long x : subArrayList) {
					if(subArrayList.lastIndexOf(x)!=k) {
						subArraySum+=x;
					}
				}
				k--;
				sumSet.add(subArraySum%m);
				subArraySum=0;
			}
		}
	}

	public static void main(String[] args) {
		long[] elementArray = {846930887,1681692778,1714636916,1957747794,424238336,719885387,1649760493,596516650,
				1189641422,1025202363,1350490028,783368691,1102520060,2044897764,1967513927,1365180541,1540383427,
				304089173,1303455737,35005212,521595369,294702568,1726956430,336465783,861021531,278722863,233665124,
				2145174068,468703136,1101513930,1801979803,1315634023,635723059,1369133070,1125898168,1059961394,2089018457,
				628175012,1656478043,1131176230,1653377374,859484422,1914544920,608413785,756898538,1734575199,1973594325,
				149798316,2038664371,1129566414,
				50,184803527};
		System.out.println(maximumSum(elementArray, 1804289384));
	}
}
