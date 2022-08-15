
public class Main {

	public static void main(String[] args) {
		IDandPasswords idandPasswords = new IDandPasswords();
		//idandPasswords.signUp("weiber", "0503");
		new LoginPage(idandPasswords.getLoginInfo());
	}

}
