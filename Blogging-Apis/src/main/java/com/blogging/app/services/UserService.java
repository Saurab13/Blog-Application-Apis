package com.blogging.app.services;

import java.util.List;
import com.blogging.app.payloads.UserDto;


public interface UserService {
	UserDto createUser(UserDto user);

	UserDto updataUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();

	void deleteUser(Integer UserId);

}
