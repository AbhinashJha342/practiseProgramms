package randomQuestions;

import java.util.HashMap;
import java.util.Map;

public class SimpleThread extends Thread implements Runnable{

	private StringBuffer myBuffer;
	
	public StringBuffer getMyBuffer() {
		return myBuffer;
	}

	public void setMyBuffer(StringBuffer myBuffer) {
		this.myBuffer = myBuffer;
	}

	public SimpleThread(StringBuffer myBuffer) {
		this.myBuffer = myBuffer;
	}
	
	public void run() {
		synchronized (this.myBuffer) {
			while((int)(this.myBuffer.charAt(0))!=68) {
				for(int i=0;i<3;i++) {
					System.out.println(this.myBuffer.charAt(0));
				}
				char x = this.myBuffer.charAt(0);
				this.myBuffer.setCharAt(0, (char) (x+1));
			}
			//this.myBuffer.setCharAt(0, 'A');
		}
	}
	
	public static void main(String[] args) {
		StringBuffer safeBuffer = new StringBuffer();
		safeBuffer.append('A');
		SimpleThread one = new SimpleThread(safeBuffer);
		one.setName("One");
		one.start();
		
		SimpleThread two = new SimpleThread(safeBuffer);
		two.setName("Two");
		two.start();
		
		SimpleThread three = new SimpleThread(safeBuffer);
		three.setName("Three");
		three.start();
		
		Map<String, String> tempmap = new HashMap<String, String>();
		tempmap.put("1", "value1");
		for(String key:tempmap.keySet()) {
			System.out.println(key);
		}
		System.out.println(tempmap.get("1") instanceof String);
		StringBuilder builder = new StringBuilder("");
		builder.append("str");
		System.out.println(builder);
		builder.setLength(0);
		System.out.println(builder);
	}
}
