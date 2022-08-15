import java.util.*;

public class IDandPasswords {
	
	Map<String, String> loginInfo = new HashMap<>();
	
	IDandPasswords(){
		
		loginInfo.put("Bro", "pizza");
		loginInfo.put("Brometheus","PASSWORD");
		loginInfo.put("BroCode","abc123");
		
	}
	
	protected Map<String, String> getLoginInfo(){
		return loginInfo;
	}
	
	public void signUp(String ID, String pwd) {
		loginInfo.put(ID, pwd);
	}
	
}
