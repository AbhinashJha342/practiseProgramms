package randomQuestions;

import java.util.ArrayList;

public class SimilarStrings {

	
	static int calculateSimilarity(String str, int startIndex, int endIndex) {
		ArrayList<String> similarString =  new ArrayList<String>();
		//String[] similarString = new String[str.length()];
		StringBuilder subStrings = new StringBuilder();
		ArrayList<Boolean> compParam = new ArrayList<Boolean>();
		//Boolean[] compParam = new Boolean[(endIndex-startIndex)+1];
		subStrings.append(str.substring(startIndex-1, endIndex));
		
		if(subStrings.length()==1) {
			return str.length();
		}
		
		int z;
		int x = 0;
		int arrayIndex=0;
		boolean equalsFlag = false;
		//compare and store the comparison result of each char for the primary substring
		for(; x<subStrings.length()-1;x++) {
			z=x+1;
			for(;z<subStrings.length();z++) {
				int start = (int) subStrings.charAt(x);
				int end = (int) subStrings.charAt(z);
				compParam.add(arrayIndex, (start==end));
				arrayIndex++;
			}
		}
		
		System.out.println(compParam.size());
		System.out.println(subStrings.length());
		
		//clear the StringBuilder to store other substring
		subStrings.delete(0, subStrings.length());
		
		int y = (endIndex-startIndex)+1;
		int endOfX = str.length()-y;
		z=0;
		arrayIndex=0;
		//below loops through string and makes substring equal to length of primary string
		for(x=0;x<=endOfX;x++) {
			for(;y<=str.length();) {
				subStrings.append(str.substring(x, y));
				for(int k=0; k<subStrings.length()-1;k++) {
					z=k+1;
					for(;z<subStrings.length();z++) {
						int start = (int) subStrings.charAt(k);
						int end = (int) subStrings.charAt(z);
						if(compParam.get(arrayIndex)!=(start==end)) {
							equalsFlag = false;
							break;
						}else
							equalsFlag = true;
						arrayIndex++;
					}
					if(!equalsFlag)
						break;
				}
				if(equalsFlag){
					similarString.add(subStrings.toString());
				}
				subStrings.delete(0, subStrings.length());
				y++;
				arrayIndex=0;
				break;
			}
		}
		
		
		return similarString.size();
	}
	
	public static void main(String[] args) {
		int result = calculateSimilarity("hgecfahajadfdfaghhjdgjggaheffdbjhjejfbbdghfhbijifafahbfeeheaagihgghaagihghhjcecfacffabeffbfbabeeicgagbgeccihaeacdgdejejacebbabeijfdigedbdbefeefhjhchbffdajbjfihibgbgjjajajafaceeijgcgedadchchggjgjghgdbdbgaghbebebchjieiejjggabfbchbhchefcceceheffdbcigagcgaadaajjjfjfahahahajadfdfagajfcfcfagdbdbgjdjaacidi",263, 287);
		System.out.println(result);
	}
	
}
