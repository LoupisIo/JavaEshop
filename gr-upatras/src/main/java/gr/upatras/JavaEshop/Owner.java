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
	
	
	public Owner(String name, String email) {
		super(name,email);
		this.isAdmin= true;
	}
	
	

}
