/**
	 * HttpProcessor:�ӿڣ��̳���HttpRequestInterceptor��HttpResponseInterceptor��
	 * ˵������process���̾���Ҫ����HttpRequest��HttpResponse����
	 * ����һ��ʵ���ࣺImmutableHttpProcessor��
	 * ���ʵ���ຬ��final��HttpRequestInterceptor�����HttpResponseInterceptor���飬
	 * ����process���̾��ǽ����е�HttpRequestInterceptor��HttpResponseInterceptor��processһ�顣
	 * 
	 * HttpRequestInterceptor(#process):�ӿڡ�
	 * ÿ��ʵ�������ڴ���HttpRequestЭ���һ���֣�
	 * ��RequestClientConnControl��RequestAuthCache��RequestAddCookies�ȡ�
	 * 
	 * HttpResponseInterceptor(#process):�ӿڡ�
	 * ÿ��ʵ�������ڴ���HttpResponseЭ���һ���֣�
	 * ��RequestAcceptEncoding��RequestAuthCache�ȡ�
	 */

package com.brightstar.http.client.apache.interceptor;