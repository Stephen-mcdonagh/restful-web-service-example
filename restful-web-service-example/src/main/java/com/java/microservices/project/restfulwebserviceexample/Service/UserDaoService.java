package com.java.microservices.project.restfulwebserviceexample.Service;
import com.java.microservices.project.restfulwebserviceexample.Model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int count=2;

	static {
		users.add(new User(1,"Stephen", new Date()));
		users.add(new User(2,"Anna", new Date()));
	}

	public List<User> findAll(){
		return users;
	}

	public User findUserById(int id){
		for(User user : users){
			if(user.getId()==id){
				return user;
			}
		}
		return null;
	}

	public User saveUser(User user){
		if(user.getId()==null){
			user.setId(count++);
		}
		users.add(user);
		return user;
	}
}
