package com.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.controller.EmployeeController;
import com.exception.BusinessException;
import com.exception.ServiceConstant;
import com.model.BaseResponse;
import com.model.EmployeeVO;
import com.service.EmployeeService;

@Controller
@RequestMapping(path = "/employee")
public class EmployeeControllerImpl implements EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Override
	@RequestMapping(path = "/findAll", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse findAll(EmployeeVO vo) {
		List<EmployeeVO> voList = employeeService.findAll(vo);
		if (voList == null) {
			throw new BusinessException(ServiceConstant.RETURN_VALUE_IS_NULL, "voList is null");
		}
		BaseResponse response = new BaseResponse();
		response.getData().addAll(voList);
		return response;
	}

	@Override
	@RequestMapping(path = "/findOne", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse findOne(EmployeeVO vo) {
		EmployeeVO employeeVO = employeeService.findOne(vo);
		BaseResponse response = new BaseResponse();
		response.getData().add(employeeVO);
		return response;
	}


	@Override
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse delete(EmployeeVO vo) {
		employeeService.delete(vo);
		return new BaseResponse();
	}

	@Override
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse save(EmployeeVO vo) {
		EmployeeVO employeeVO = employeeService.save(vo);
		BaseResponse response = new BaseResponse();
		response.getData().add(employeeVO);
		return response;
	}

	@Override
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse update(EmployeeVO vo) {
		EmployeeVO employeeVO = employeeService.save(vo);
		BaseResponse response = new BaseResponse();
		response.getData().add(employeeVO);
		return response;
	}

}
