package com.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.controller.DepartmentController;
import com.model.BaseResponse;
import com.model.DepartmentVO;
import com.service.DepartmentService;

@Controller
@RequestMapping(path = "/department")
public class DepartmentControllerImpl implements DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@Override
	@RequestMapping(path = "/findAll", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse findAll(DepartmentVO vo) {
		List<DepartmentVO> voList = departmentService.findAll(vo);
		BaseResponse response = new BaseResponse();
		response.getData().addAll(voList);
		return response;
	}

	@Override
	@RequestMapping(path = "/findOne", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse findOne(DepartmentVO vo) {
		DepartmentVO departmentVO = departmentService.findOne(vo);
		BaseResponse response = new BaseResponse();
		response.getData().add(departmentVO);
		return response;
	}

	@Override
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse save(DepartmentVO vo) {
		DepartmentVO departmentVO = departmentService.save(vo);
		BaseResponse response = new BaseResponse();
		response.getData().add(departmentVO);
		return response;
	}

	@Override
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(DepartmentVO vo) {
		DepartmentVO departmentVO = departmentService.update(vo);
		BaseResponse response = new BaseResponse();
		response.getData().add(departmentVO);
		return response;
	}

	@Override
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(DepartmentVO vo) {
		departmentService.delete(vo);
		return new BaseResponse();
	}

}
