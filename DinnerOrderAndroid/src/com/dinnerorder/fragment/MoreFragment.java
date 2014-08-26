package com.dinnerorder.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.dinnerorder.R;
import com.dinnerorder.activity.LoginActivity;
import com.dinnerorder.utils.DinnerOrderApplication;


public class MoreFragment extends Fragment {
	private SharedPreferences sp;
	private DinnerOrderApplication thisApp ;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sp = this.getActivity().getSharedPreferences("userInfo", Context.MODE_WORLD_WRITEABLE);  
		thisApp = (DinnerOrderApplication) this.getActivity().getApplicationContext();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_more,null);
		Button signOut = (Button)view.findViewById(R.id.SignoutButton);
		signOut.setOnClickListener(new OnClickListener(){
			public void onClick(View v)
			{
				Editor editor = sp.edit();
				editor.clear();
				editor.commit();
				thisApp.setPassword("");
                thisApp.setUserName("");
                thisApp.setId(0);
                Intent intent = new Intent(MoreFragment.this.getActivity(),LoginActivity.class);
                startActivity(intent);
			}
		});
		return view;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}
