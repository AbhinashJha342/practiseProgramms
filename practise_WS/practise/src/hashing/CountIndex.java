package hashing;

public class CountIndex {

	private int count;
	private int index;
	
	public CountIndex(int index){
		this.count = 1;
		this.index = index;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void incCount() {
		this.count++;
	}
}
