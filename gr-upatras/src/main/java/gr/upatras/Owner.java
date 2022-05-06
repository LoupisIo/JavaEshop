package gr.upatras;
import java.util.*;
/**
 * 
 */

/**
 * @author loupis.io
 *
 */
public class Owner extends User {
	

	public boolean isAdmin;
	
	
	public Owner(String name, String email) {
		super(name,email);
		this.isAdmin= true;
	}
	
	

}
