package com.aliapi;

import java.util.List;

import org.springframework.util.Assert;

import com.alibaba.cloudapi.sdk.core.enums.Method;
import com.alibaba.cloudapi.sdk.core.enums.Scheme;
import com.alibaba.cloudapi.sdk.core.model.ApiResponse;

public class ApiGatewayUtil {

	private ApiClient client = null;

	public ApiGatewayUtil(String key, String secret, String groupHost) {
		Assert.notNull(key, "key must not be null");
		Assert.notNull(secret, "secret must not be null");
		Assert.notNull(groupHost, "groupHost must not be null");
		this.client = ApiClient.newBuilder(groupHost).appKey(key).appSecret(secret).build();
	}

	public ApiResponse findApi(Scheme scheme, Method method, String apiPath, List<ParamBean> paramList) {
		Assert.notNull(scheme, "scheme must not be null");
		Assert.notNull(method, "method must not be null");
		Assert.notNull(apiPath, "apiPath must not be null");
		ApiResponse response = client.request(scheme, method, apiPath, paramList);
		return response;
	}
	public ApiResponse findApi(Scheme scheme, Method method, String apiPath) {
		Assert.notNull(scheme, "scheme must not be null");
		Assert.notNull(method, "method must not be null");
		Assert.notNull(apiPath, "apiPath must not be null");
		ApiResponse response = client.request(scheme, method, apiPath, null);
		return response;
	}


}
