package com.dinnerorder.fragment;

import java.io.IOException;
import java.io.StringReader;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dinnerorder.R;
import com.dinnerorder.activity.LoginActivity;
import com.dinnerorder.bean.Customers;
import com.dinnerorder.utils.DinnerOrderApplication;
import com.dinnerorder.utils.NetworkUtils;
import com.google.gson.stream.JsonReader;


public class UserInfoFragment extends Fragment {
	final int USERINFO = 0x44324; 
	TextView username;
	TextView registerTime;
	TextView eMail;
	TextView address;
	TextView totalCost;
	TextView phone;
	Handler handle;
	String customerid;
	ProgressDialog pda;
	Thread thread = new Thread(){
		public void run() {
			Looper.prepare();
			Map<String, String> map = new HashMap<String,String>();
			map.put("customerid", customerid);
			try {
	
				String strJson = NetworkUtils.postRequest(NetworkUtils.BASE_URL+"ShowCustomerInfoServlet", map);
				strJson = URLDecoder.decode(strJson, "utf-8");
				Log.v("ZW",strJson);
				Customers customer = parseJson(strJson);
				Message message = Message.obtain();
				message.what = USERINFO;
				message.obj = customer;
				handle.sendMessage(message);
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
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		System.out.println(((DinnerOrderApplication)getActivity().getApplicationContext()).getId());
		if(String.valueOf(((DinnerOrderApplication)getActivity().getApplicationContext()).getId()).equals("0")){
			View view =  inflater.inflate(R.layout.fragment_user_info_not_login, null);
			Button button = (Button) view.findViewById(R.id.user_info_login_button);
			button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intentb = new Intent(getActivity(),LoginActivity.class);
					startActivity(intentb);
				}
			});
			return view;
		}
		View view = inflater.inflate(R.layout.fragment_user_info,null);
		username = (TextView) view.findViewById(R.id.usernameShow_textView);
		registerTime = (TextView) view.findViewById(R.id.registerTimeShow_textView);
		eMail = (TextView) view.findViewById(R.id.emailShow_textView);
		address = (TextView) view.findViewById(R.id.addressShow_textView);
		totalCost = (TextView) view.findViewById(R.id.totalPayShow_textView);
		phone = (TextView) view.findViewById(R.id.telShow_textView);
		customerid = String.valueOf(((DinnerOrderApplication)getActivity().getApplicationContext()).getId());
		
		handle = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				if(msg.what==USERINFO){
					pda.cancel();
					Customers customerTemp = (Customers) msg.obj;
					username.setText(customerTemp.getUserName());
					registerTime.setText(customerTemp.getRegisterDate());
					address.setText(customerTemp.getAddress());
					eMail.setText(customerTemp.getEmail());
					totalCost.setText(String.valueOf(customerTemp.getTotalCost()));
					phone.setText(customerTemp.getCustomerPhone());
				}
			}
		};
		thread.start();
		 pda = new ProgressDialog(
					getActivity());
			pda.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pda.setTitle("提示");
			pda.setMessage("请稍等");
			pda.setCancelable(false);
			pda.show();

		return view;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
	
	
	private Customers parseJson(String str) {
		Customers item = null;
		JsonReader reader = new JsonReader(new StringReader(str));
		try {
			
						 item = new Customers();
						reader.beginObject();// 开始解析对象
						while (reader.hasNext()) {
							String tagName = reader.nextName();
							if (tagName.equals("customerId")) {
								int id = reader.nextInt();
								item.setCustomerId(id);
							}

							else if (tagName.equals("userName")) {
								item.setUserName(reader.nextString());
							}

							else if (tagName.equals("password")) {
								item.setPassword(reader.nextString());
							} else if (tagName.equals("registerDate")) {
								item.setRegisterDate(reader
										.nextString());
							}

							else if (tagName.equals("email")) {
								item.setEmail(reader.nextString());;
							} else if (tagName.equals("address")) {
								item.setAddress(reader.nextString());
							} else if (tagName.equals("totalCost")) {
								item.setTotalCost(reader.nextInt());
							} else if (tagName.equals("customerPhone")) {
								item.setCustomerPhone(reader.nextString());
							}

							else
								reader.skipValue();
						}
						reader.endObject();
				} catch (IOException e) {
					e.printStackTrace();
				}

				return item;
			}


}
