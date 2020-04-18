package randomQuestions;

public class ChaoticArray {

	static void minimumBribes(int[] queue) {
		int bribe =0;
		boolean isBribe = true;
		for(int i=0;i<queue.length;i++) {
			if(i+1!=queue[i] && queue[i]>i && queue[i]-3<=i) {
				bribe+=queue[i]-i-1;
			} else if(queue[i]-3>i) {
				System.out.println("Too chaotic");
				isBribe = false;
				break;
			}
		}
		
		if(isBribe) {
			System.out.println(bribe);
		}
	 }
	
	public static void main(String[] args) {
		int[] queue = {1,4,5,3,2};
		ChaoticArray.minimumBribes(queue);
	}
}
