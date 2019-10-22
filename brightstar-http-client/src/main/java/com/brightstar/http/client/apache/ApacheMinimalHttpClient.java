package com.brightstar.http.client.apache;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *	ApacheMinimalHttpClient
 *
 *	private final HttpClientConnectionManager connManager:
 *	���ӳ�������������ӵ������������ڡ����������ӳ��д����������Լ��Ƴ���
 *	Connection manager��װ�˶����ӳصľ�����������������ӳ����ú͹黹���ӡ�
 *	Connection������������������״̬�������ӳع�������ʱ��У���Ƿ���open״̬�����ǵĻ������connect��
 *	connect�Ĺ��̾��� ���ڲ�ͬschema(��Ҫ��http��https)������ͬ��socket����(ssl��plain)���ҽ�http�������ӣ��󶨵�socket��
 *	ͬʱ����Ҳ����Ϊ�������߹��ڵ�ԭ��close���stale״̬��ֱ������һ��get��ʱ����������ʱ�������ȥ��
 *	ͬʱ���ӳػ��ܶ����ӽ��������Cȫ�ֺ͵�route��������
 *
 *  private final MinimalClientExec requestExecutor:
 *  ����һ�������ĵ���ִ�й���.
 *  ��ClientExecChain��һ��ʵ�֣�ֻ�Ƿ�װ���������HTTP���̣��ṩ��ֱ�ӵĿͻ��˷���������.
 *  ��֧�ִ�����֧���ڸ�������µ����ԣ��ض���Ȩ��У�飬IO�쳣�ȣ���
 *
 */
@Component
public class ApacheMinimalHttpClient {
	
	Logger logger = LoggerFactory.getLogger(ApacheMinimalHttpClient.class);

	CloseableHttpClient httpClient;
	
	
	public ApacheMinimalHttpClient() {
		this.httpClient = HttpClients.createMinimal();
	}


	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}

}
