package com.service;

import java.util.List;

import com.model.EmployeeVO;

public interface EmployeeService {

	public List<EmployeeVO> findAll(EmployeeVO vo);

	public EmployeeVO findOne(EmployeeVO vo);
	
	public EmployeeVO save(EmployeeVO vo);
	
	public EmployeeVO update(EmployeeVO vo);
	
	public void delete(EmployeeVO vo);

}
