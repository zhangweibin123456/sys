package com.controller;


import com.model.BaseResponse;
import com.model.DepartmentVO;

public interface DepartmentController {
	
	public BaseResponse findAll(DepartmentVO vo);

	public BaseResponse findOne(DepartmentVO vo);
	
	public BaseResponse save(DepartmentVO vo);
	
	public BaseResponse update(DepartmentVO vo);
	
	public BaseResponse delete(DepartmentVO vo);
	

}
