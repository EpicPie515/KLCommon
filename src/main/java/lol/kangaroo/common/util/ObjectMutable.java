package lol.kangaroo.common.util;

public class ObjectMutable<T> {
	
	private T t;
	
	public ObjectMutable(T t) {
		this.t = t;
	}
	
	public void set(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}

}
