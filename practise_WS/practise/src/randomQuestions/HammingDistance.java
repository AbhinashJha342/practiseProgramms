package randomQuestions;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class HammingDistance {

	public static void main(String[] args) throws IOException {
		System.out.println(Long.toBinaryString(680142203));
		System.out.println(Long.toBinaryString(1111953568));
		int[] myArray = {1,7,3,2};
		Arrays.sort(myArray);
		System.out.println(Arrays.toString(myArray));
//		File file = new File("/Users/abhinashjha/Desktop/streamFIle.txt");
//		BufferedReader br = new BufferedReader(new FileReader(file));
//		String st; 
//		  while ((st = br.readLine()) != null) {
//			  if(st.equals(" ")) {
//					st.replace(" ", ",");
//				}
//		  	}
		  Path path = Paths.get("/Users/abhinashjha/Desktop/streamFIle.txt");
		  Charset charset = StandardCharsets.UTF_8;

		  String content = new String(Files.readAllBytes(path), charset);
		  content = content.replaceAll(" ", ",");
		  Files.write(path, content.getBytes(charset));
		}
}
