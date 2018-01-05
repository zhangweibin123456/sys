package com.aliapi;

import java.util.List;

import org.springframework.util.Assert;

import com.alibaba.cloudapi.sdk.core.BaseApiClient;
import com.alibaba.cloudapi.sdk.core.BaseApiClientBuilder;
import com.alibaba.cloudapi.sdk.core.annotation.NotThreadSafe;
import com.alibaba.cloudapi.sdk.core.annotation.ThreadSafe;
import com.alibaba.cloudapi.sdk.core.enums.Method;
import com.alibaba.cloudapi.sdk.core.enums.Scheme;
import com.alibaba.cloudapi.sdk.core.model.ApiRequest;
import com.alibaba.cloudapi.sdk.core.model.ApiResponse;
import com.alibaba.cloudapi.sdk.core.model.BuilderParams;

@ThreadSafe
public final class ApiClient extends BaseApiClient {
	private static String GROUP_HOST = null;

	private ApiClient(BuilderParams builderParams) {
		super(builderParams);
	}

	@NotThreadSafe
	public static class Builder extends BaseApiClientBuilder<ApiClient.Builder, ApiClient> {
		@Override
		protected ApiClient build(BuilderParams params) {
			return new ApiClient(params);
		}
	}

	public static Builder newBuilder(String groupHost) {
		Assert.notNull(groupHost, "groupHost must not be null");
		GROUP_HOST = groupHost;
		return new ApiClient.Builder();
	}

	public ApiResponse request(Scheme scheme, Method method, String apiPath, List<ParamBean> paramList) {
		Assert.notNull(scheme, "scheme must not be null");
		Assert.notNull(method, "method must not be null");
		Assert.notNull(apiPath, "apiPath must not be null");
		Assert.notNull(GROUP_HOST, "group_host must not be null");
		ApiRequest _apiRequest = new ApiRequest(scheme, method, GROUP_HOST, apiPath);
		if (paramList != null) {
			for (ParamBean param : paramList) {
				_apiRequest.addParam(param.getParamKey(), param.getParamValue(), param.getParamPosition(),
						param.getParamIsRequired());
			}
		}
		return syncInvoke(_apiRequest);
	}
}