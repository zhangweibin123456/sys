package com.controller.impl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.controller.UserController;
import com.exception.BusinessException;
import com.exception.ServiceConstant;
import com.model.BaseResponse;
import com.model.UserVO;
import com.service.UserService;
import com.utils.UserUtil;

@Controller
@RequestMapping(path = "/user")
public class UserControllerImpl implements UserController {

	//private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserService userService;

	@Override
	@RequestMapping(path = "/findAll", method = RequestMethod.POST)
	public BaseResponse findAll(@RequestBody UserVO vo) {
		List<UserVO> voList = userService.findAll(vo);
		if(voList == null){
			throw new BusinessException(ServiceConstant.RETURN_VALUE_IS_NULL,"voList is null");
		}
		
		BaseResponse response=new BaseResponse();
		response.getData().addAll(voList);
		return response;
	}

	@Override
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public BaseResponse save(@RequestBody UserVO vo) {
		UserVO voDB = userService.save(vo);
		BaseResponse response=new BaseResponse();
		response.getData().add(voDB);
		return response;
	}

	@Override
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView  login(@RequestBody UserVO vo, HttpServletRequest request, HttpServletResponse response) {
		if(vo == null){
			throw new BusinessException(ServiceConstant.LOGON_USERNAME_PASSWORD_NOT_NULL,"username and password all empty");
		}
		if(vo.getUserName() == null){
			throw new BusinessException(ServiceConstant.LOGON_USERNAME_NOT_NULL,"username is null");
		}
		if(vo.getPassWord() == null){
			throw new BusinessException(ServiceConstant.LOGON_PASSWORD_NOT_NULL,"password is null");
		}
		
		UserVO voDB = userService.findByUserNameAndPassWord(vo);
		if(voDB == null){
			throw new BusinessException(ServiceConstant.LOGON_ERROR,"user does not exist");
		}
		
		UserUtil.saveUserToSession(request, vo);
		
		 ModelAndView mav = new ModelAndView("index");  
		
		return mav;
	}

	@Override
	@RequestMapping(path = "/logout", method = RequestMethod.POST)
	public BaseResponse logout(HttpServletRequest request) {
		request.removeAttribute("user");
		return new BaseResponse();
	}

	@Override
	@RequestMapping(path = "/test", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse test() {
		return new BaseResponse();
	}
	
	
	

}
