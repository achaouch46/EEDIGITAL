package com.mutex.selenium.testdata;

public class LoginInput {
	public LoginInput(String mail, String pw) {
		this.mail = mail;
		this.pw = pw;
	}

	// Siret non dsn
	private String mail;
	// TODO : rename to pwd
	private String pw;

	public String getMail() {
		return mail;
	}

	// TODO : rename to Pwd
	public String getPw() {
		return pw;
	}

	public static LoginInput nonDsn() {
		return new LoginInput("fodie.doucourre+69202823600028@gmail.com", "Mutex2019");
	}

	public static LoginInput dsn() {
		return new LoginInput("fodie.doucoure+49426756000030@gmail.com", "Mutex2020");
	}

}
