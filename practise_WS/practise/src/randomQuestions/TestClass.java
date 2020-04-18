package randomQuestions;

public class TestClass {

	public TestClass(String s, int i) {
		System.out.println("inside test");
	}
	
	public TestClass(String s) {
		System.out.println(s);
	}
	
	public static void main(String[] s) {
		TestClass x = new TestClass("name");
		Boolean falg = false;
		if(!falg) {
			System.out.println("inside if");
		}
		System.out.println(falg);
		System.out.println("014523437650000000".replaceAll("0+$",""));
	}
}
