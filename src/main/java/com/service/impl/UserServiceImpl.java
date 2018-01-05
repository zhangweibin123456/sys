package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bean.UserPO;
import com.exception.BusinessException;
import com.exception.ServiceConstant;
import com.model.UserVO;
import com.repo.UserRepository;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserVO> findAll(UserVO vo) {
		List<UserVO> voList = new ArrayList<UserVO>();
		List<UserPO> poList = userRepository.findAll();
		if (poList != null && !poList.isEmpty()) {
			for (UserPO po : poList) {
				voList.add(this.poToVO(po));
			}
		}else{
			throw new BusinessException(ServiceConstant.RETURN_VALUE_IS_NULL,"poList is null");
		}
		return voList;
	}

	@Override
	public UserVO save(UserVO vo) {
		UserPO po = this.voToPO(vo);
		UserPO poDB = userRepository.save(po);
		return this.poToVO(poDB);
	}

	/**
	 * voToPO
	 */
	private UserPO voToPO(UserVO vo) {
		UserPO po = new UserPO();
		po.setId(vo.getId());
		po.setPassWord(vo.getPassWord());
		po.setUserName(vo.getUserName());
		return po;
	}

	/**
	 * poToVO
	 */
	private UserVO poToVO(UserPO po) {
		UserVO vo = new UserVO();
		vo.setId(po.getId());
		vo.setPassWord(po.getPassWord());
		vo.setUserName(po.getUserName());
		return vo;
	}

	@Override
	public UserVO findByUserNameAndPassWord(UserVO vo) {
		UserPO poDB = 	userRepository.findByUserNameAndPassWord(vo.getUserName(), vo.getPassWord());
		return this.poToVO(poDB);
	}
	
	public Specification<UserPO> dynamicQueryActivityAuditLog(final UserVO vo) {
		return new Specification<UserPO>() {
			public Predicate toPredicate(Root<UserPO> root, CriteriaQuery<?> query,
					CriteriaBuilder builder) {
				List<Predicate> list = new ArrayList<Predicate>();


				if (!StringUtils.isEmpty(vo.getUserName())) {
					list.add(builder.and(builder.equal(root.get("userName()"), vo.getUserName())));
				}

				Predicate[] p = new Predicate[list.size()];
				query.where(builder.and(list.toArray(p)));
				return null;
			}
		};
	}
	
	
	public Page<UserPO> searchAndPagingService(final UserPO userPO, int page, int count, Sort sort)
			throws Exception {
			Specification<UserPO> specification = new Specification<UserPO>() {
			@Override
			public Predicate toPredicate(Root<UserPO> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				List<Predicate> list = new ArrayList<Predicate>();
//				if (!StringUtils.isEmpty(vtmProfilePO.getId())) {
//					list.add(builder.and(builder.equal(root.get("id"), vtmProfilePO.getId())));
//				}
//				if (!StringUtils.isEmpty(vtmProfilePO.getMachineId())) {
//					list.add(builder.like(builder.lower(root.get("machineId").as(String.class)),
//							"%" + vtmProfilePO.getMachineId().toLowerCase() + "%"));
//				}
//				if (!StringUtils.isEmpty(vtmProfilePO.getLogCode())) {
//					list.add(builder.like(builder.lower(root.get("logCode").as(String.class)),
//							"%" + vtmProfilePO.getLogCode().toLowerCase() + "%"));
//				}
//				if (!StringUtils.isEmpty(vtmProfilePO.getBankName())) {
//					list.add(builder.like(builder.lower(root.get("bankName").as(String.class)),
//							"%" + vtmProfilePO.getBankName().toLowerCase() + "%"));
//				}
//				if (!StringUtils.isEmpty(vtmProfilePO.getLocation())) {
//					list.add(builder.like(builder.lower(root.get("location").as(String.class)),
//							"%" + vtmProfilePO.getLocation().toLowerCase() + "%"));
//				}
				return builder.and(list.toArray(new Predicate[] {}));

			}
		};
		Pageable pageable = new PageRequest(page - 1, count, sort);
		Page<UserPO> vtmProfilePoPage = userRepository.findAll(specification, pageable);
//		if (vtmProfilePoPage.getContent().size() == 0) {
//			throw new DataNotFoundException("data not found!");
//		}
		return vtmProfilePoPage;
	}


}
