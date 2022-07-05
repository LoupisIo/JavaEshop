package gr.upatras.JavaEshop;
import java.util.*;
/**
 * 
 */

/**
 * @author loupis.io
 *
 */
public class Owner extends MyUser {
	

	public boolean isAdmin;
	
	
	public Owner(String name, String email,String password) {
		super(name,email, password);
		this.isAdmin= true;
	}
	
	

}
