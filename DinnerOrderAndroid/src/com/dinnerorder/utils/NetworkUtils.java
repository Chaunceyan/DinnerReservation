package com.dinnerorder.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class NetworkUtils {
	public static String BASE_URL = "http://10.128.50.110:8080/DinnerOrder/servlet/";// 服务器的id以及项目名
	public static HttpClient httpClient = new DefaultHttpClient();

	public static String getRquest(String url) throws ClientProtocolException,
			IOException {
		HttpGet get = new HttpGet(url);
		get.addHeader("Accept", "text/json");
		String json = "";
		HttpResponse httpResponse = httpClient.execute(get);
		if (httpResponse.getStatusLine().getStatusCode() == 200) {
			HttpEntity httpEntity = httpResponse.getEntity();
			json = EntityUtils.toString(httpEntity, "UTF-8");
			return json;
		}
		return json;
	}

	public static String postRequest(String url, Map<String, String> param)
			throws ClientProtocolException, IOException {
		HttpPost post = new HttpPost(url);
		// Toast.makeText(this, ".......",Toast.LENGTH_SHORT);
		post.addHeader("Accept", "text/json");
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		for (String nameValuePair : param.keySet()) {

			params.add(new BasicNameValuePair(nameValuePair, param
					.get(nameValuePair)));
		}
		post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		HttpResponse httpResponse = httpClient.execute(post);
		String json = "";
		if (httpResponse.getStatusLine().getStatusCode() == 200) {
			HttpEntity httpEntity = httpResponse.getEntity();
			json = EntityUtils.toString(httpEntity, "UTF-8");
			return json;
		}else
			return json;
	}
}
