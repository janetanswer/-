package com.brightstar.http.client.apache;

import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class HttpTemplate {

	Logger logger = LoggerFactory.getLogger(HttpTemplate.class);
	/**
	 * 1.当使用了ResponseHandler，HttpClient 将自动确保释放连接到连接管理器中，而不管请求执行是否成功或引发异常。
	 * 2.EntityUtils 提供了一些静态方法，可以更加容易地从实体中读取内容或信息。
	 * 代替直接读取 java.io.InputStream，也可以使用这个类中的方法以字符串/字节数组的形式获取整个内容体。
	 * 然而，在不能保证服务端是可信的且已知的长度限制的情况下，EntityUtils的使用是强烈不鼓励的
	 */
	ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

		@Override
		public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
			StatusLine statusLine = response.getStatusLine();
			HttpEntity entity = response.getEntity();
			if (statusLine.getStatusCode() >= 300) {
				throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
			}
			if (entity == null) {
				throw new ClientProtocolException("Response contains no content");
			}
			
			return EntityUtils.toString(entity);
		}

	};

	@Async
	public void get(HttpClient hc, URI uri) {
		logger.info("---Get Start---");
		String responseBody = null;
		try {
			HttpGet httpGet = new HttpGet(uri);
			responseBody = hc.execute(httpGet, responseHandler);
			logger.info("---Get End---{}",responseBody);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			logger.info("FINALLY");
		}
//		return responseBody;
	}
}
