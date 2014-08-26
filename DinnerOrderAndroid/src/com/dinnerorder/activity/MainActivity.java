package com.dinnerorder.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.dinnerorder.R;
import com.dinnerorder.bean.Cart;
import com.dinnerorder.fragment.IndexFragment;
import com.dinnerorder.fragment.MoreFragment;
import com.dinnerorder.fragment.ShopCarFragment;
import com.dinnerorder.fragment.UserInfoFragment;
import com.dinnerorder.utils.DinnerOrderApplication;

public class MainActivity extends FragmentActivity {
	private ViewPager viewPager_vp;
	private TextView index_tv;
	private TextView shopCar_tv;
	private TextView userInfo_tv;
	private TextView more_tv;
	public static int COUNT = 4;
	private int perTranslateLength;
	private ImageView cursor_iv;
	private int currentPage = 0;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//将全局变量  cart  username  password  放入
		DinnerOrderApplication doa = (DinnerOrderApplication) getApplicationContext();
		doa.setCart(Cart.getInstance());
			
		if(getIntent().getExtras().getString("startsign").equals("first")){
			currentPage = 0 ;
		}else
		if(getIntent().getExtras().getString("startsign").equals("shopcar")){
			Intent previousIntent = getIntent();
			if(previousIntent.getExtras().containsKey("shopcar")){
				currentPage = previousIntent.getExtras().getInt("shopcar");
			}else{
				currentPage = 0 ;
			}
		}else if(getIntent().getExtras().getString("startsign").equals("login")){
			currentPage = 0 ;
		}else if(getIntent().getExtras().getString("startsign").equals("paysuccess")){
			currentPage = 0 ;
		}
		viewPager_vp = (ViewPager) this.findViewById(R.id.vPager);
		// textview
		index_tv = (TextView) this.findViewById(R.id.index);
		shopCar_tv = (TextView) this.findViewById(R.id.shop_car);
		userInfo_tv = (TextView) this.findViewById(R.id.user_info);
		more_tv = (TextView) this.findViewById(R.id.more);
		
		cursor_iv = (ImageView) this.findViewById(R.id.cursor);
		//int bitmapWidth = BitmapFactory.decodeResource(getResources(), R.drawable.a).getWidth();
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int windowWidth = dm.widthPixels;
		perTranslateLength = windowWidth/COUNT;
		// textview listener
		index_tv.setOnClickListener(new mainOnClickListener(0));
		shopCar_tv.setOnClickListener(new mainOnClickListener(1));
		userInfo_tv.setOnClickListener(new mainOnClickListener(2));
		more_tv.setOnClickListener(new mainOnClickListener(3));
		// viewPager
		viewPager_vp.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
		viewPager_vp.setCurrentItem(currentPage);
		
		viewPager_vp.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				
				TranslateAnimation anim = new TranslateAnimation(currentPage*perTranslateLength,arg0*perTranslateLength, 0, 0);
				currentPage = arg0;
				anim.setDuration(300);
				anim.setFillAfter(true);
				cursor_iv.startAnimation(anim);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});

	}

	class mainOnClickListener implements OnClickListener {
		private int num;

		public mainOnClickListener(int num) {
			super();
			this.num = num;
		}

		@Override
		public void onClick(View v) {
			viewPager_vp.setCurrentItem(num);
		}

	}

}

class ViewPagerAdapter extends FragmentStatePagerAdapter  {



	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public android.support.v4.app.Fragment getItem(int position) {
		android.support.v4.app.Fragment fragment = null;
		switch (position) {
		case 0:
			 fragment = new IndexFragment();
			break;
		case 1:
			 fragment = new ShopCarFragment();
			break;
		case 2:
			 fragment = new UserInfoFragment();
			break;
		case 3:
			 fragment = new MoreFragment();
			break;

		default:
			break;
		}
		return fragment;
	}

	@Override
	public int getCount() {
		return MainActivity.COUNT;
	}
	
}

