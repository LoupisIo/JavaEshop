package gr.upatras.JavaEshop;

import java.util.*;

/**
 * @author loupis.io
 *
 */
public class MyUser {
	public String name;
	public String email;
	private String passWord;
	
	
	//Constructor
	public MyUser(String name, String email,String password){
		this.name=name;
        this.email=email;
        this.passWord = password;
    }
	
	//Setters and getters
	
	


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassWord(String newPass) {
		this.passWord = newPass;
	}
	public Boolean checkPass(String password ) {
		if (this.getPassWord().equals(getPassWord())) {
			return true;
		}
		return false ;
	}


	public String getPassWord() {
		return passWord;
	}

}
