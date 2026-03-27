package com.example.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.user.UserMapper;
import com.example.user.model.UserDTO;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int signup(UserDTO dto) {
		int result = userMapper.signup(dto);
		return result;
	}
	
	@Override
	public UserDTO loginCheck(String id, String password) {
		UserDTO dto = userMapper.loginCheck(id, password);
		return dto;
	}
	
	@Override
	public int checkId(String id) {
		int result = userMapper.checkId(id);
		return result;
	}

}
