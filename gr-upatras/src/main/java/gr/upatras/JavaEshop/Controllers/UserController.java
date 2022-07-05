package gr.upatras.JavaEshop.Controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gr.upatras.JavaEshop.MyUser;
import gr.upatras.JavaEshop.IServices.IUserService;
import gr.upatras.JavaEshop.Services.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author loupis.io
 *
 */

@RestController
public class UserController {
	@Autowired
	private IUserService userService;
	
	@ApiOperation(value="Returns all the Users",
			notes="This operation retrieves all User objects",
			response = MyUser.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = MyUser.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/user" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.GET)
	public List<MyUser> getMyUser(){
		List<MyUser> users = userService.getAll();
		return users;
	}
	@ApiOperation(value="Adds an User to the shop",
			notes="This operation adds an User Object to the shop",
			response = MyUser.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = MyUser.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/user" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.POST)
	public ResponseEntity<MyUser> createUser(@ApiParam(value = "The MyUser Object to be added", required = true) @RequestBody MyUser user) {
		MyUser tempuser = userService.addUser(user);
		if(tempuser != null) {
			return new ResponseEntity<MyUser>( tempuser, HttpStatus.OK);
		}
		return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
	}
	

	@ApiOperation(value="Returns an MyUser from the shop maching the given email",
			notes="This operation returns an User Object from the shop maching the given email address",
			response = MyUser.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = MyUser.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/user/email" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.GET)
	public ResponseEntity<MyUser> findUserByEmail(@ApiParam(value = "The email address", required = true) @RequestBody String email) {
		MyUser user = userService.findByEmail(email);
		if(user != null) {
			return new ResponseEntity<MyUser>( user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	

	@ApiOperation(value="Deletes an User from the shop",
			notes="This operation deletes an user from the shop")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success" ),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 406, message = "Not Acceptable", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/user" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.DELETE)
	public ResponseEntity<Void> removeUser(@ApiParam(value = "The User to deleted", required = true) @RequestBody MyUser user) {
		MyUser toDelete = userService.deleteUser(user);
		if(toDelete != null) {
			return new ResponseEntity<Void>(HttpStatus.OK);	
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	
	@ApiOperation(value="Updates the email of a User",
			notes="This operation updates the email of a user",response = MyUser.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success",response = MyUser.class ),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 406, message = "Not Acceptable", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/user/email" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.PATCH)
	public ResponseEntity<MyUser> setEmail(@ApiParam(value = "The User object", required = true) @RequestBody MyUser user,
			@ApiParam(value = "The new email for the user", required = true)@PathVariable("email")String newEmail) {
			if(user != null) {
				MyUser tempUser = userService.changeEmail(user.email,user.getPassWord(),newEmail);
				if(tempUser != null) {
					return new ResponseEntity<MyUser>(user,HttpStatus.OK);	
				}else {return new ResponseEntity<MyUser>(user,HttpStatus.NOT_ACCEPTABLE);}
			}
			return new ResponseEntity<MyUser>(user,HttpStatus.BAD_REQUEST);
	}
	
	@ApiOperation(value="Updates the passWord of a User",
			notes="This operation updates the passWord of a user",response = MyUser.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success",response = MyUser.class ),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
			@ApiResponse(code = 403, message = "Forbidden", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
			@ApiResponse(code = 406, message = "Not Acceptable", response = Error.class),
			@ApiResponse(code = 409, message = "Conflict", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
			@RequestMapping(value = "/user/passWord" , produces = { "application/json;charset=utf-8" }, method =
			RequestMethod.PATCH)
	public ResponseEntity<MyUser> setPassWord(@ApiParam(value = "The User object", required = true) @RequestBody MyUser user,
			@ApiParam(value = "The new passWord for the user", required = true)@PathVariable("passWord")String newPassWord) {
			if(user != null) {
				MyUser tempUser = userService.changePassWord(user.email,user.getPassWord(),newPassWord);
				if(tempUser != null) {
					return new ResponseEntity<MyUser>(user,HttpStatus.OK);	
				}else {return new ResponseEntity<MyUser>(user,HttpStatus.NOT_ACCEPTABLE);}
			}
			return new ResponseEntity<MyUser>(user,HttpStatus.BAD_REQUEST);
	}
	
	

}
