package randomQuestions;

public class LinkedList {

	private int data;
	private LinkedList linkedNode;
	
	public LinkedList(int data) {
		this.data = data;
		this.linkedNode = null;
	}
	
	public void add(LinkedList node) {
		this.linkedNode = node;
	}
	
	
	public static void main(String args[]){
		LinkedList head = new LinkedList(5);
		//head.add(node);
		System.out.println(head.data);
		
	}
}
