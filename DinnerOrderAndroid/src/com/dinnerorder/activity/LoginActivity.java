package com.dinnerorder.activity;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

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
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.dinnerorder.R;
import com.dinnerorder.utils.DinnerOrderApplication;
import com.dinnerorder.utils.NetworkUtils;
import com.google.gson.stream.JsonReader;


public class LoginActivity extends Activity {
	private EditText username_text;
	private EditText password_text;
	private Button reset_button;
	private Button login_button;
	private Button register_button;
	private CheckBox rememberPassword_checkbox;
	private CheckBox autoLogin_checkbox;
	private String username;
	private String password;
	private String result;
	private SharedPreferences sp;
	JSONObject jsonObject;
	private Handler handle;
	final int FF = 0x230283;
	Thread thread = new Thread(){
		public void run() {
			Looper.prepare();
			Map<String,String> map = new HashMap<String,String>();
			map.put("logininfo",jsonObject.toString());
			try {
				result = NetworkUtils.postRequest(NetworkUtils.BASE_URL+"AndroidLoginServlet", map);
				Message mess = new Message();
				mess.what = FF;
				handle.sendMessage(mess);
				Log.v("ZW", result);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Looper.loop();
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		handle = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				if(msg.what==FF){
					//thread.destroy();
					validation();
				}
			}
		};
		username_text = (EditText) this.findViewById(R.id.username_editText);
		password_text = (EditText) this.findViewById(R.id.password_editText);
		reset_button = (Button) this.findViewById(R.id.reset_button);
		login_button = (Button) this.findViewById(R.id.login_button);
		register_button = (Button) this.findViewById(R.id.register_button);
		rememberPassword_checkbox = (CheckBox) this
				.findViewById(R.id.remember_password_checkbox);
		autoLogin_checkbox = (CheckBox) this
				.findViewById(R.id.auto_login_checkbox);
		sp = this.getSharedPreferences("userInfo", Context.MODE_WORLD_WRITEABLE);  
		
		
		if(sp.getBoolean("REM_ISCHECK", false))  
        {  
			//remember password checked
			rememberPassword_checkbox.setChecked(true);  
			username_text.setText(sp.getString("USERNAME", ""));  
			password_text.setText(sp.getString("PASSWORD", ""));   
			if(sp.getBoolean("AUTO_ISCHECK", false))  
			{  
				//auto login checked 
				//Auto Login
                DinnerOrderApplication thisApp = (DinnerOrderApplication) getApplicationContext();
                thisApp.setPassword(sp.getString("PASSWORD", ""));
                thisApp.setUserName(sp.getString("USERNAME", ""));
                thisApp.setId(Integer.parseInt(sp.getString("CUSTOMERID", "0")));
				autoLogin_checkbox.setChecked(true);
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this, MainActivity.class);
				intent.putExtra("startsign","login");
				startActivity(intent);
			}  
        }
		reset_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				username_text.setText("");
				password_text.setText("");
			}
		});
			
		login_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ConnectivityManager connMgr = (ConnectivityManager) 
				        getSystemService(Context.CONNECTIVITY_SERVICE);
				    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
				    if (networkInfo != null && networkInfo.isConnected()) {
						//The Network Is Available
				    	username = username_text.getText().toString();
						password = password_text.getText().toString();
						if ("".equals(username)) {
							Toast.makeText(getApplicationContext(), "Please input a valid username", Toast.LENGTH_LONG)
							.show();
						}else if("".equals(password)){
							Toast.makeText(getApplicationContext(), "Please input a valid password", Toast.LENGTH_LONG)
							.show();
						}else{
							//The user input is valid
							try {
								//JSON connect with server
							 jsonObject = new JSONObject();
								jsonObject.put("username", username);
								jsonObject.put("password", password);
								thread.start();
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
				    }else {
				    	 Toast.makeText(
				    			 getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
				    }
				
			}
		});
		
		register_button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this, RegisterActivity.class);
				startActivity(intent);
			}
		});
		
		//Remember Password CheckBox 
        rememberPassword_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (rememberPassword_checkbox.isChecked()) {    
                    sp.edit().putBoolean("REM_ISCHECK", true).commit();  
                } else { 
                    sp.edit().putBoolean("REM_ISCHECK", false).commit();  
                }  
			}
		});
          
        //AutoLogin CheckBox
        autoLogin_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (autoLogin_checkbox.isChecked()) {    
					sp.edit().putBoolean("AUTO_ISCHECK", true).commit();  
				} else { 
					sp.edit().putBoolean("AUTO_ISCHECK", false).commit();  
				}  
			}
		});
	}
	
	private void validation(){
		try {
			System.out.println(result+"  aaaaaaaaaaaaaaaaaa");
			JsonReader reader = new JsonReader(new StringReader(result));
			reader.beginObject();
			String result_aa = null;
			int customerid = 0;
			while(reader.hasNext()){
				String tagsign = reader.nextName();
				if(tagsign.equals("result")){
					result_aa = reader.nextString();
				}else if(tagsign.equals("customerId")){
					customerid = Integer.valueOf(reader.nextString());
				}else{
					reader.skipValue();
				}
			}
			reader.endObject();
			if(result_aa.equals("Valid")) {  
                //璁颁綇鐢ㄦ埛鍚嶃�瀵嗙爜銆�
				int customerId = customerid;
				Editor editor = sp.edit();
                editor.putString("USERNAME", username);
                editor.putString("PASSWORD", password);
                editor.putString("CUSTOMERID", String.valueOf(customerId));
                editor.commit();
                
                
                DinnerOrderApplication thisApp = (DinnerOrderApplication) getApplicationContext();
                thisApp.setPassword(password);
                thisApp.setUserName(username);
                thisApp.setId(customerId);
               	System.out.println(thisApp.getId());
				//Jump
                Intent intent = new Intent();
				intent.setClass(LoginActivity.this, MainActivity.class);
				intent.putExtra("startsign","login");
				//intent.putExtra("customerid",customerId);
				startActivity(intent);
			
            } else {
                Toast.makeText(
                               getApplicationContext(), "Invalid Password", Toast.LENGTH_SHORT).show();
            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
/*	private class UserLoginTask extends AsyncTask<JSONObject, Integer, String> {
	     protected String doInBackground(JSONObject... jsonObject) {
	    	
	    	result = userLogin(jsonObject[0]);
	    	return result;
	     }

	     protected void onProgressUpdate(Integer... progress) {
	     }

	     protected void onPostExecute(String result) {
	     }
	     
	     protected String userLogin(JSONObject jsonObject) {
	    	 
	    	 HttpClient httpclient = new DefaultHttpClient();
	    	 HttpPost httppost = new HttpPost(NetworkUtils.BASE_URL+"AndroidLoginServlet");
	 		 try {
	 			httppost.setEntity(new StringEntity(jsonObject.toString()));
	 			 // send the variable and value, in other words post, to the URL
	 			 HttpResponse response = httpclient.execute(httppost);
	 			 try {
					wait(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	 			 HttpEntity entity = response.getEntity();
	 			 String responseString = EntityUtils.toString(entity, "UTF-8");
	 			 //String responseString = response.toString();
	 			 return responseString;
	 		 	} catch (ClientProtocolException e) {
	 			// process execption
	 		 		return null;
	 		 	} catch (IOException e) {
	 		 	// process execption
	 		 		return null;
	 		 	}
	 	}
	 }*/
	 
}
