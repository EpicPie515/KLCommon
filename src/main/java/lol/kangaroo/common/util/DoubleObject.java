package lol.kangaroo.common.util;

public class DoubleObject<O1, O2> {
	
	private O1 o1;
	private O2 o2;
	
	public DoubleObject(O1 o1, O2 o2) {
		super();
		this.o1 = o1;
		this.o2 = o2;
	}

	public O1 getObject1() {
		return o1;
	}

	public void setObject1(O1 o1) {
		this.o1 = o1;
	}

	public O2 getObject2() {
		return o2;
	}

	public void setObject2(O2 o2) {
		this.o2 = o2;
	}
	
}
