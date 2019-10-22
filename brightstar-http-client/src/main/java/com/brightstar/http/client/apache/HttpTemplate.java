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
	 * 1.��ʹ����ResponseHandler��HttpClient ���Զ�ȷ���ͷ����ӵ����ӹ������У�����������ִ���Ƿ�ɹ��������쳣��
	 * 2.EntityUtils �ṩ��һЩ��̬���������Ը������׵ش�ʵ���ж�ȡ���ݻ���Ϣ��
	 * ����ֱ�Ӷ�ȡ java.io.InputStream��Ҳ����ʹ��������еķ������ַ���/�ֽ��������ʽ��ȡ���������塣
	 * Ȼ�����ڲ��ܱ�֤������ǿ��ŵ�����֪�ĳ������Ƶ�����£�EntityUtils��ʹ����ǿ�Ҳ�������
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
