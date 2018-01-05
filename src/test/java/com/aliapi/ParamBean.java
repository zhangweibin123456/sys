package com.aliapi;

import com.alibaba.cloudapi.sdk.core.enums.ParamPosition;

public class ParamBean {
	/**
	 * 参数key
	 */
	private String paramKey;
	/**
	 * 参数value
	 */
	private Object paramValue;
	/**
	 * 传参方式
	 */
	private ParamPosition paramPosition;
	/**
	 * 是否是必须传参值
	 */
	private Boolean paramIsRequired;

	public ParamBean() {

	}

	public ParamBean(String paramKey, Object paramValue, ParamPosition paramPosition, Boolean paramIsRequired) {
		this.paramKey = paramKey;
		this.paramValue = paramValue;
		this.paramPosition = paramPosition;
		this.paramIsRequired = paramIsRequired;
	}

	public String getParamKey() {
		return paramKey;
	}

	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}

	public Object getParamValue() {
		return paramValue;
	}

	public void setParamValue(Object paramValue) {
		this.paramValue = paramValue;
	}

	public ParamPosition getParamPosition() {
		return paramPosition;
	}

	public void setParamPosition(ParamPosition paramPosition) {
		this.paramPosition = paramPosition;
	}

	public Boolean getParamIsRequired() {
		return paramIsRequired;
	}

	public void setParamIsRequired(Boolean paramIsRequired) {
		this.paramIsRequired = paramIsRequired;
	}

}
