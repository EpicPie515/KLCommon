package lol.kangaroo.common.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.UUID;

public class MessageWrapper {
	
	public ByteArrayOutputStream b;
	public DataOutputStream out;
	
	public MessageWrapper(String subchannel) {
		this.b = new ByteArrayOutputStream();
		this.out = new DataOutputStream(b);
		try {
			out.writeUTF(subchannel);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public MessageWrapper writeInt(int i) {
		try {
			out.writeInt(i);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public MessageWrapper writeUTF(String s) {
		try {
			out.writeUTF(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public MessageWrapper writeChar(char c) {
		try {
			out.writeChar(c);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public MessageWrapper writeUuid(UUID u) {
		try {
			out.writeLong(u.getLeastSignificantBits());
			out.writeLong(u.getMostSignificantBits());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public void close() {
		try {
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
