package com.board.service;

import com.board.domain.UserDTO;

public interface UserService {
	public boolean insertUser(UserDTO params);
	boolean loginUser(UserDTO params);
}
