package hashing;

public class RepeatingCharacters {

	private void firstRepeatedCharater(char[] value) {
		int count[] = new int[256];
		for(int i=0; i<count.length; ++i)
			count[i] = 0;
		for(int i=0; i<value.length; i++) {
			if(count[value[i]]==1) {
				System.out.println("first repeated character is: "+value[i]);
				break;
			}
			else {
				count[value[i]]++;
			}
		}
		
	}
	
	private char[] removeRepeatedCharater(char[] value) {
		int count[] = new int[256];
		for(int i=0; i<count.length; ++i)
			count[i] = 0;
		for(int i=0; i<value.length; i++) {
			if(count[value[i]]==1) {
				value[i] = '\0';
			}
			else {
				count[value[i]]++;
			}
		}
		return value;
		
	}
	
	
	public static void main(String[] args) {
		RepeatingCharacters characters = new RepeatingCharacters();
		char[] value = {'c','o','n','s','t','a','n','t'};
		System.out.println(characters.removeRepeatedCharater(value));
		characters.firstRepeatedCharater(value);
	}
}
