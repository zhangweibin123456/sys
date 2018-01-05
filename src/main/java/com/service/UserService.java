package com.service;

import java.util.List;

import com.model.UserVO;

public interface UserService {

	public List<UserVO> findAll(UserVO vo);

	public UserVO save(UserVO vo);
	
	public UserVO findByUserNameAndPassWord(UserVO vo);

}
