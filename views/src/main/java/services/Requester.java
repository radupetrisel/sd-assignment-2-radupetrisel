package services;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class Requester {

	private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	
	private static OkHttpClient client = new OkHttpClient();
	
	public static String post(String url, String json) {
		
		System.out.println(url);
		RequestBody body = RequestBody.create(JSON, json);
		
		Request post = new Request.Builder().url(url).post(body).build();
		
		String resp = null;
		try {
			 resp = client.newCall(post).execute().body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resp;
	}
	
	public static String get(String url) {
				
		Request post = new Request.Builder().url(url).get().build();
		
		String resp = null;
		try {
			 resp = client.newCall(post).execute().body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resp;
	}
	
	
}
