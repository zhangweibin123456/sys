package com.aliapi;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.alibaba.cloudapi.sdk.core.enums.Method;
import com.alibaba.cloudapi.sdk.core.enums.ParamPosition;
import com.alibaba.cloudapi.sdk.core.enums.Scheme;
import com.alibaba.cloudapi.sdk.core.model.ApiResponse;

public class ApiGateWayTest {

	@Test
	public void test01() throws UnsupportedEncodingException {
		//分组host加密   例：www.baidu.com
		String groupHost = "b3f388f30d694d25a43f08bdbfb1f2a8-cn-hangzhou.alicloudapi.com";
		//path 接口追加路劲   例：www.baidu.com/kl/api
		String apiPath = "/kl/api";
		//key
		String key = "23828688";
		//secret
		String secret = "9596291d50f1e18acf9008442e179e76";
		List<ParamBean> paramList=new ArrayList<ParamBean>();
		//请求参数
		paramList.add(new ParamBean("id","01",ParamPosition.FORM,false));
		ApiGatewayUtil util = new ApiGatewayUtil(key, secret, groupHost);
		//Scheme[http https]  Method 请求方式  
		ApiResponse response = util.findApi(Scheme.HTTP, Method.POST_FORM, apiPath,paramList);
		System.out.println("response code = " + response.getStatusCode());
		System.out.println("response content = " + new String(response.getBody(), "utf-8"));

	}

}
