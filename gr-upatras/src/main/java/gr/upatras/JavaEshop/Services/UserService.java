package gr.upatras.JavaEshop.Services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.upatras.JavaEshop.Item;
import gr.upatras.JavaEshop.MyUser;
import gr.upatras.JavaEshop.IServices.IItemService;
import gr.upatras.JavaEshop.IServices.IPenService;
import gr.upatras.JavaEshop.IServices.IUserService;
import gr.upatras.JavaEshop.Pen;


/**
 * 
 * @author loupis.io
 *
 */
@Service

public class UserService implements IUserService {
	@Autowired
	List<MyUser> users = new ArrayList<MyUser>();
	
	public UserService() {
		super();
	}
	

	@Override
	public List<MyUser> getAll() {
		return users;
	}
	//

	@Override
	public MyUser findByEmail(String email) {
		for(MyUser user : users) {
				return user;				
				
		}
		return null;
	}//

	@Override
	public MyUser changeEmail(String email, String password,String newEmail) {
		for(MyUser tempuser : users) {
			if(tempuser.email.equals(email)) {
				if(tempuser.checkPass(password)) {
					tempuser.setEmail(newEmail);
					return tempuser;				
				}
			}
		}
		return null;
	}
	//

	@Override
	public MyUser changePassWord(String email, String password, String newPassWord) {

		for(MyUser tempuser : users) {
			if(tempuser.email.equals(email)) {
				if(tempuser.checkPass(password)) {
					tempuser.setPassWord(newPassWord);
					return tempuser;				
				}
			}
		}
		return null;
	}
	//

	@Override
	public MyUser addUser(MyUser user) {
		for(MyUser tempUser : users) {
			if(tempUser.email.equals(user.email)) {
				return null;				
			}
		}
		users.add(user);
		
		return user;
	}
	//

	@Override
	public MyUser deleteUser(MyUser user) {
		for(MyUser tempuser : users) {
			if(tempuser.email.equals(user.email)) {
				if(tempuser.checkPass(user.getPassWord())) {
					users.remove(user);
					return user;				
				}
			}
		}
		return null;
	}
	//

}
