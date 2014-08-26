package com.dinnerorder.activity;

import java.io.IOException;

import com.dinnerorder.R;
import com.dinnerorder.utils.*;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity{
	
	private EditText username_text;
	private EditText password_text;
	private EditText passwordCheck_text;
	private EditText address_text;
	private EditText email_text;
	private EditText phoneNum_text;
	private Button register_button;
	private Button reset_button;
	private	String username;
	private String password;
	private String passwordCheck;
	private String address;
	private String email;
	private String phoneNum; 
	private String result;
	private SharedPreferences sp;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		//find all the views
		username_text = (EditText) this.findViewById(R.id.editText1);
		password_text = (EditText) this.findViewById(R.id.editText2);
		passwordCheck_text = (EditText) this.findViewById(R.id.editText3);
		address_text = (EditText) this.findViewById(R.id.editText4);
		email_text = (EditText) this.findViewById(R.id.editText5);
		phoneNum_text = (EditText) this.findViewById(R.id.editText6);
		register_button = (Button) this.findViewById(R.id.registerButton);
		reset_button = (Button) this.findViewById(R.id.resetButtom);
		sp = this.getSharedPreferences("userInfo", Context.MODE_WORLD_WRITEABLE);  
		
		register_button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
				ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
				NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
				if (networkInfo != null && networkInfo.isConnected()) {
					//The Network Is Available
				    username = username_text.getText().toString();
					password = password_text.getText().toString();
					passwordCheck = passwordCheck_text.getText().toString();
					address = address_text.getText().toString();
					email = email_text.getText().toString();
					phoneNum = phoneNum_text.getText().toString();
					
					
					//verify the input
					if ("".equals(username)
						&&"".equals(password)
						&&"".equals(passwordCheck)
						&&"".equals(address)
						&&"".equals(email)
						&&"".equals(phoneNum)) {
						
						Toast.makeText(getApplicationContext(), "Please Complete Your Information", Toast.LENGTH_LONG)
							.show();
					}else if(!passwordCheck.equals(password)){
						Toast.makeText(getApplicationContext(), "Two Passwords Don't Match", Toast.LENGTH_LONG)
							.show();
					}else{
						try {
							//JSON connect with server
							JSONObject jsonObject = new JSONObject();
							jsonObject.put("username", username);
							jsonObject.put("password", password);
							jsonObject.put("address", address);
							jsonObject.put("email", email);
							jsonObject.put("phoneNum", phoneNum);
				
							new RegisterTask().execute(jsonObject);
							validation();
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else {
			    	 Toast.makeText(
			    			 getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT)
			    			 .show();
			    }
			}
		});		
	}
	
	private void validation(){
		try {
			JSONObject responseJson = new JSONObject(result);
			//System.out.println(result);
			
			if(responseJson.getString("result").equals("Valid")) {  
                 //璁颁綇鐢ㄦ埛鍚嶃�瀵嗙爜銆� 
				
				Editor editor = sp.edit();  
				editor.putString("USERNAME", username);  
				editor.putString("PASSWORD", password);  
				editor.commit();
				int customerId = Integer.parseInt(responseJson.getString("customerId"));
				DinnerOrderApplication thisApp = (DinnerOrderApplication) getApplicationContext();
				thisApp.setPassword(password);
				thisApp.setUserName(username);
				thisApp.setId(customerId);
				//Jump
				Intent intent = new Intent();
				intent.setClass(RegisterActivity.this, MainActivity.class);
				intent.putExtra("startsign","login");
				startActivity(intent);
				} else {
                    Toast.makeText(
                            getApplicationContext(), "Registration Failed", Toast.LENGTH_SHORT).show();
         } 
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private class RegisterTask extends AsyncTask<JSONObject, Integer, String> {
	     protected String doInBackground(JSONObject... jsonObject) {
	    	
	    	result = register(jsonObject[0]);
	    	return result;
	     }

	     protected void onProgressUpdate(Integer... progress) {
	     }

	     protected void onPostExecute(String result) {
	     }
	     
	     protected String register(JSONObject jsonObject) {
	    	 
	    	 HttpClient httpclient = new DefaultHttpClient();
	    	 HttpPost httppost = new HttpPost(NetworkUtils.BASE_URL+"AndroidRegisterServlet");
	 		 try {
	 			httppost.setEntity(new StringEntity(jsonObject.toString()));
	 			 // send the variable and value, in other words post, to the URL
	 			 HttpResponse response = httpclient.execute(httppost);
	 			 HttpEntity entity = response.getEntity();
	 			 String responseString = EntityUtils.toString(entity, "UTF-8");
	 			 return responseString;
	 		 	} catch (ClientProtocolException e) {
	 			// process execption
	 		 		return null;
	 		 	} catch (IOException e) {
	 		 	// process execption
	 		 		return null;
	 		 	}
	 	}
	 }
	
}

