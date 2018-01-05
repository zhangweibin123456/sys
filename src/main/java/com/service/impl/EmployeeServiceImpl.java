package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bean.DepartmentPO;
import com.bean.EmployeePO;
import com.model.DepartmentVO;
import com.model.EmployeeVO;
import com.repo.EmployeeRepository;
import com.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;

	@Override
	public List<EmployeeVO> findAll(EmployeeVO vo) {
		List<EmployeeVO> voList = new ArrayList<EmployeeVO>();
		List<EmployeePO> poList = empRepository.findAll();
		if (poList != null) {
			for (EmployeePO po : poList) {
				voList.add(this.poToVo(po));
			}
		}
		return voList;
	}

	@Override
	public EmployeeVO findOne(EmployeeVO vo) {
		EmployeePO po = empRepository.findOne(vo.getEmpId());
		return this.poToVo(po);
	}

	@Override
	public EmployeeVO save(EmployeeVO vo) {
		EmployeePO po = empRepository.save(this.voToPo(vo));
		return this.poToVo(po);

	}

	@Override
	public EmployeeVO update(EmployeeVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(EmployeeVO vo) {
		empRepository.delete(vo.getEmpId());

	}

	/**
	 * po 转 vo
	 */
	private EmployeeVO poToVo(EmployeePO po) {
		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setEmpId(po.getEmpId());
		employeeVO.setEmpName(po.getEmpName());
		employeeVO.setEmail(po.getEmail());
		DepartmentVO dmVO = new DepartmentVO();
		dmVO.setDeptId(po.getDepartment().getDeptId());
		dmVO.setDeptName(po.getDepartment().getDeptName());
		employeeVO.setDepartment(dmVO);
		return employeeVO;
	}

	/**
	 * po 转 vo
	 */
	private EmployeePO voToPo(EmployeeVO vo) {
		EmployeePO employeePO = new EmployeePO();
		employeePO.setEmpId(vo.getEmpId());
		employeePO.setEmpName(vo.getEmpName());
		employeePO.setEmail(vo.getEmail());
		DepartmentPO dmPO = new DepartmentPO();
		dmPO.setDeptId(vo.getDepartment().getDeptId());
		dmPO.setDeptName(vo.getDepartment().getDeptName());
		employeePO.setDepartment(dmPO);
		return employeePO;
	}

	
}
