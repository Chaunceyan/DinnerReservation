package com.dinnerorder.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dinnerorder.R;
import com.dinnerorder.activity.ChineseCategoriesActivity;
import com.dinnerorder.activity.ProductListShowActivity;
import com.dinnerorder.activity.ShowOrderActivity;

public class IndexFragment extends Fragment implements OnClickListener{
	private TextView dinnerOrder_textview; 
	private TextView shopCar_textview; 
	private TextView chineseFood_textview; 
	private TextView westernFood_textview; 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_index,null);
		dinnerOrder_textview = (TextView) view.findViewById(R.id.fragment_index_order_dinner);
		shopCar_textview = (TextView) view.findViewById(R.id.fragment_index_shop_car);
		chineseFood_textview = (TextView) view.findViewById(R.id.fragment_index_chinese_food);
		westernFood_textview = (TextView) view.findViewById(R.id.fragment_index_western_food);
		
		
		chineseFood_textview.setOnClickListener(this);
		westernFood_textview.setOnClickListener(this);
		shopCar_textview.setOnClickListener(this);
		return view;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.fragment_index_order_dinner:
			break;
		case R.id.fragment_index_shop_car:
			ViewPager vp = (ViewPager) getActivity().findViewById(R.id.vPager);
			vp.setCurrentItem(1);
			break;
		case R.id.fragment_index_chinese_food:
			intent = new Intent(getActivity(),ChineseCategoriesActivity.class);
			startActivity(intent);
			break;
		case R.id.fragment_index_western_food:
			intent = new Intent(getActivity(),ProductListShowActivity.class);
			intent.putExtra("producttype","westernfood");
			startActivity(intent);
			break;

		default:
			break;
		}
	}

}



