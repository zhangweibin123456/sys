package com.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.model.BaseResponse;
import com.model.UserVO;

public interface UserController {
	
	public BaseResponse findAll(UserVO vo);

	public BaseResponse save(UserVO vo);
	
	public ModelAndView  login(UserVO vo, HttpServletRequest request, HttpServletResponse response);
	
	public BaseResponse logout(HttpServletRequest request);
	
	public BaseResponse test();
	

}
