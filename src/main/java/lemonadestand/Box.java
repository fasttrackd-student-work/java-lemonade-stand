package lemonadestand;

public class Box <T> {
	
	private T obj;
	
	public Box (T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
	public <S, R> void printValue(S sObj, R rObj) {
		System.out.println(sObj);
		System.out.println(rObj);
	}
	
}
