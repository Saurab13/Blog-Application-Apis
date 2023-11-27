package com.blogging.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blogging.app.entities.User;
import com.blogging.app.payloads.UserDto;
import com.blogging.app.repository.UserRepo;
import com.blogging.app.services.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {

		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);

		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updataUser(UserDto user, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer UserId) {
		// TODO Auto-generated method stub

	}

	public User dtoToUser(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(user.getPassword());
		return user;

	}

	public UserDto userToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());

		return userDto;

	}

}
