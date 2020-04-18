package randomQuestions;

public class Emu {

	static String s = "-";
	public static void main(String[] args) {
		try {
			throw new Exception();
		}catch(Exception e) {
			try {
				try {
					throw new Exception();
				}catch(Exception ex) {
					s+="ic ";
				}
				System.out.println("ex ");
			}catch(Exception x) {
				s+="mc ";
			}finally {
				s+="mf ";
			}
		}finally {
			s+="of ";
		}
		System.out.println(s);
		System.out.println("00009862121".contains("98621"));
	}
}
