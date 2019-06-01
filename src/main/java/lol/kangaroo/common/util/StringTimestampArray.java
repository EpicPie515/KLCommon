package lol.kangaroo.common.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class StringTimestampArray {
	
	private List<DoubleObject<String, Timestamp>> list = new ArrayList<>();
	
	public void add(String s, Timestamp t) {
		list.add(new DoubleObject<String, Timestamp>(s, t));
	}
	
	public List<DoubleObject<String, Timestamp>> getList() {
		return list;
	}
	
}
