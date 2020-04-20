package lol.kangaroo.common.player.profile;

public class ProfileID {
	
	public static final ProfileID ZERO_PID = new ProfileID(new byte[] {0,0,0,0});
	
	private byte[] bytes;
	
	public ProfileID(byte[] bytes) {
		if(bytes.length != 4) throw new IllegalArgumentException("byte[] length must be 4.");
		this.bytes = bytes;
	}
	
	@Override
	public String toString() {
		return bytesToHex(bytes);
	}
	
	public static ProfileID fromString(String pid) {
		return new ProfileID(hexToBytes(pid));
	}
	
	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
	private static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for (int j = 0; j < bytes.length; j++) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = HEX_ARRAY[v >>> 4];
	        hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	
	private static byte[] hexToBytes(String hex) {
	    int len = hex.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
	                             + Character.digit(hex.charAt(i+1), 16));
	    }
	    return data;
	}

}
