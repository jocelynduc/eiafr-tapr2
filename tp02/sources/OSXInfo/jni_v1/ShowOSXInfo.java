public class ShowOSXInfo {

	static {
    	System.loadLibrary("osxinfo");
	}

	public static native String getOSXInfo();
	  
	public static void main(String[] args) {
	    System.out.println("Operating System:\n" + getOSXInfo());
	}
}