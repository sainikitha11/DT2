package com.buddies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.buddies.model.User;
import com.buddies.service.IUserService;

@RestController
public class UserController 
{
	
	@Autowired 
	IUserService iUserService; //service which is used for performing all the data retrival/manipulation work
	
	//retrive all users
	@RequestMapping(value="/user/", method=RequestMethod.GET)
	//@GetMapping("/user")
	public ResponseEntity <List<User>> listAllUsers()
	{
		List<User> user=iUserService.viewUsers();
		if(user.isEmpty())
		{
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(HttpStatus.OK);
	}
	
	//retriving single user
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") User userid) {
        System.out.println("Fetching User with id " + userid);
        User user = iUserService.verifyMail(userid);
        if (user == null) {
            System.out.println("User with id " + userid + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
	
	//creating a user
	@RequestMapping(value = "/user/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody User user,@RequestParam("username")String mail,@RequestParam("password")String pwd)
	{
		if(user.getUserid()==null)
		{
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	//Update a User
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        System.out.println("Updating User " + id);
         
        User currentUser = iUserService.verifyMail(user);
         
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
       // iUserService.saveOrUpdate(user);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
    
    //delete a user
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id,User u) {
        System.out.println("Fetching & Deleting User with id " + id);
 
        User user = iUserService.verifyMail(u);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        iUserService.deactivateUser(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}