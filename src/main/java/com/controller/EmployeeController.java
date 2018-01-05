package com.controller;


import com.model.BaseResponse;
import com.model.EmployeeVO;

public interface EmployeeController {
	
	public BaseResponse findAll(EmployeeVO vo);

	public BaseResponse findOne(EmployeeVO vo);
	
	public BaseResponse save(EmployeeVO vo);
	
	public BaseResponse update(EmployeeVO vo);
	
	public BaseResponse delete(EmployeeVO vo);
	

}
