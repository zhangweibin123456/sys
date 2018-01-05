package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.DepartmentPO;
import com.model.DepartmentVO;
import com.repo.DepartmentRepository;
import com.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository dmRepository;

	@Override
	public List<DepartmentVO> findAll(DepartmentVO vo) {
		List<DepartmentVO> voList = new ArrayList<DepartmentVO>();
		List<DepartmentPO> poList = dmRepository.findAll();
		if (poList != null) {
			for (DepartmentPO po : poList) {
				voList.add(this.poToVo(po));
			}
		}
		return voList;
	}

	@Override
	public DepartmentVO findOne(DepartmentVO vo) {
		DepartmentPO po = dmRepository.findOne(vo.getDeptId());
		return this.poToVo(po);
	}

	@Override
	public DepartmentVO save(DepartmentVO vo) {
		DepartmentPO po = dmRepository.save(this.voToPo(vo));
		return this.poToVo(po);
	}

	@Override
	public DepartmentVO update(DepartmentVO vo) {
		// dmRepository.s
		return null;
	}

	@Override
	public void delete(DepartmentVO vo) {
		dmRepository.delete(vo.getDeptId());
	}

	private DepartmentVO poToVo(DepartmentPO po) {
		DepartmentVO vo = new DepartmentVO();
		vo.setDeptId(po.getDeptId());
		vo.setDeptName(po.getDeptName());
		return vo;
	}

	private DepartmentPO voToPo(DepartmentVO vo) {
		DepartmentPO po = new DepartmentPO();
		po.setDeptId(vo.getDeptId());
		po.setDeptName(vo.getDeptName());
		return po;

	}

}
