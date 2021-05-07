package com.mybatis.demo.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybatis.demo.mappers.UserMapper;
import com.mybatis.demo.model.User;

@RestController
@RequestMapping("/rest/users")
public class UserResource {
	
	Logger logger = LoggerFactory.getLogger(UserResource.class);
	@Autowired
	private UserMapper userMapper; 
	
	@GetMapping("/all")
	public List<User> getUsers(){
		return userMapper.findAll();
	}

	@GetMapping("/create")
	public List<User> createUsers(){
		User user = new User();
		user.setId(1003);
		user.setName("Gill");
		user.setSalary("89B");
		logger.info("putting code into here1");
		userMapper.insert(user);
		logger.info("putting code into here");
		return userMapper.findAll();
	}
}
