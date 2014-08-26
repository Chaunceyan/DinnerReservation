package com.dinnerorder.activity;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.dinnerorder.R;

public class FirstShowActivity extends Activity{
	Handler hande;
	Timer timer;
	final int START = 0x777;
	private SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_show);
		sp = this.getSharedPreferences("userInfo", Context.MODE_WORLD_WRITEABLE);  
		hande = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				timer.cancel();
				if(msg.what==START){
					
					//
					if(sp.getBoolean("AUTO_ISCHECK", false))  {  
							//auto login
							Intent intent = new Intent();
							intent.setClass(FirstShowActivity.this, LoginActivity.class);
							startActivity(intent);
							return;
					} else{
					
					Intent intent = new Intent(FirstShowActivity.this,MainActivity.class);
					intent.putExtra("startsign", "first");
					startActivity(intent);
					}
					
				}
			}
		};
	
		
		timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				hande.sendEmptyMessage(START);
			}
		},400);

	}
}
