package ua.template.controllers;

import ua.template.models.User;

public class UserController {

	private User user;
	
	public User getUser(String name) {
		user = new User();
		user.setName(name);
		return user;
	}
	
	
	
	
}
