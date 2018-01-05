package com.header;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class VtmInfromationResolver implements HandlerMethodArgumentResolver  {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		 return parameter.getParameterAnnotation(VtmInfromation.class) != null;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
			String vtmInfromations = webRequest.getHeader("vtm_infromation");  
			RequestVtmInformation re = new RequestVtmInformation();
			re.setMachineId(vtmInfromations);
			return re; 
	}

}
