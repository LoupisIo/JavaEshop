package gr.upatras.JavaEshop.IServices;

import java.util.List;

import gr.upatras.JavaEshop.Buyer;
import gr.upatras.JavaEshop.MyUser;

/**
 * 
 * @author loupis.io
 *
 *
 */

public interface IUserService {
	
	List<MyUser> getAll();
	
	
	MyUser findByEmail(String email);
	
	MyUser changeEmail(String email, String password, String newEmail);
	
	MyUser changePassWord(String email, String password, String newPassWord);
	
	MyUser addUser(MyUser user);
	
	MyUser deleteUser(MyUser user);
	
	List<Buyer> getBuyers();
	
	

}
