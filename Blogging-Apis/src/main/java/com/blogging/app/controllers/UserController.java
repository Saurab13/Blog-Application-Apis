package com.blogging.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogging.app.payloads.ApiResponse;
import com.blogging.app.payloads.UserDto;
import com.blogging.app.services.UserService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// POST-create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}

	// PUT-update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,
			@PathVariable("userId") Integer userId) {

		UserDto updatedUser = this.userService.updataUser(userDto, userId);
		return ResponseEntity.ok(updatedUser);
	}

	// DELETE -delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId) {
		this.userService.deleteUser(userId);

		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);

	}

	// GET-getAlluser
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAlluser() {

		List<UserDto> allUsers = this.userService.getAllUsers();
		return ResponseEntity.ok(allUsers);

	}

	// GET-singleUser
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleuser(@PathVariable("userId") Integer userId) {

		UserDto userById = this.userService.getUserById(userId);
		return ResponseEntity.ok(userById);

	}

}
