package rmi.digest;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.Date;


public class RMIDigestClient {

	public static final String SERVER = "160.98.31.52";
	public static final String CLASS = "RMIDigestServer";
	public static final String USERNAME = "DucMarcacci";
	public static final String PASSWORD = "password";

	public static void main(String[] args) {
		try {
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new RMISecurityManager());
			}
			RMIDigestValidator obj = (RMIDigestValidator) Naming.lookup("//"
					+ SERVER + "/" + CLASS);
			String challenge = obj.getChallenge(USERNAME);
			MD5Digest md5 = new MD5Digest();
			boolean result = obj.challengeResponse(USERNAME,
					md5.doHash(md5.doHash(PASSWORD), challenge.getBytes()));
			System.out.println("Challenge: " + (result ? "Success" : "Fail"));
			Date date1 = obj.getDate(USERNAME);
			System.out.println("date1:" + date1);
			Date date2 = obj.getDate2(USERNAME);
			System.out.println("date2:" + date2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
