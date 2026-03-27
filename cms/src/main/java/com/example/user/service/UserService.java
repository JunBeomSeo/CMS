package com.example.user.service;

import com.example.user.model.UserDTO;

public interface UserService {

	public int signup(UserDTO dto);
	public UserDTO loginCheck(String id, String password);
	public int checkId(String id);
}
