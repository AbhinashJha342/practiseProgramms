package randomQuestions;

public class HappyNumber {

	private static int result = 0;
	
	public static int checkHappyNumber(int number) {
		int mod = number%10;
		int div = number/10;
		
		if(result!=1) {
			if(div!=0){
				result = (mod*mod) + checkHappyNumber(div);
			} else
				result = (mod*mod);
			checkHappyNumber(result);
		} else
			return 0;
		
		return 0;
	}
	
	public static void main(String[] args) {
		//System.out.println(checkHappyNumber(10)==0 ? "the number is happy number" : "the number is not happy number");
		String accountNUmber = "000009391307";
		String contract = "9391327";
		System.out.println(accountNUmber.contains(contract));
		StringBuilder strngBldr = new StringBuilder();
		strngBldr.append('c');
		strngBldr.append('c');
		strngBldr.setLength(0);
		System.out.println(strngBldr);
	}
}
