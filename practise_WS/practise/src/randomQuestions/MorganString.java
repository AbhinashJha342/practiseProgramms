package randomQuestions;

public class MorganString {
	
	static String generateLexMinString(String a, String b) {
		StringBuilder lexMinString =  new StringBuilder();
		int ascii_StrA;
		int ascii_StrB;
		int i;
		int j = 0;
		for(i=0;i<a.length();) {
			ascii_StrA = (int) a.charAt(i);
			for(;j<b.length();) {
				ascii_StrB = (int) b.charAt(j);
				if(ascii_StrA<ascii_StrB){
					lexMinString.append(a.charAt(i));
					i++;
					break;
				} else if(ascii_StrA==ascii_StrB) {
					if(i+1<a.length() && j+1<b.length()) {
						int tempA = (int) a.charAt(i+1);
						int tempB = (int) b.charAt(j+1);
						if(tempA<tempB){
							lexMinString.append(a.charAt(i));
							i++;
							break;
						} else {
							lexMinString.append(b.charAt(j));
							j++;
						}
					} else if(i+1<a.length()){
						lexMinString.append(a.charAt(i));
						i++;
						break;
					} else {
						lexMinString.append(b.charAt(j));
						j++;
					}
				} else {
					lexMinString.append(b.charAt(j));
					j++;
				}
			}
			if(j==b.length())
				break;
		}
		lexMinString.append(i<a.length()?a.substring(i, a.length()):b.substring(j, b.length()));
		return lexMinString.toString();
	}
	
	
	public static void main(String[] args) {
		System.out.println(generateLexMinString("fiogqa", "fghmpaz"));
	}

}
