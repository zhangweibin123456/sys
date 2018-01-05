package com.service;

import java.util.List;

import com.model.DepartmentVO;

public interface DepartmentService {

	public List<DepartmentVO> findAll(DepartmentVO vo);

	public DepartmentVO findOne(DepartmentVO vo);
	
	public DepartmentVO save(DepartmentVO vo);
	
	public DepartmentVO update(DepartmentVO vo);

	public void delete(DepartmentVO vo);
	

}
