package com.dinnerorder.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.dinnerorder.R;

public class ChineseCategoriesActivity extends Activity implements
		OnClickListener {
	private TextView chuancai_textview;
	private TextView yuecai_textview;
	private TextView huicai_textview;
	private TextView xiangcai_textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chinese_categories);
		chuancai_textview = (TextView) this.findViewById(R.id.chinese_chuancai);
		yuecai_textview = (TextView) this.findViewById(R.id.chinese_yuecai);
		huicai_textview = (TextView) this.findViewById(R.id.chinese_huicai);
		xiangcai_textview = (TextView) this.findViewById(R.id.chinese_xiangcai);

		chuancai_textview.setOnClickListener(this);
		yuecai_textview.setOnClickListener(this);
		huicai_textview.setOnClickListener(this);
		xiangcai_textview.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.chinese_chuancai:
			intent = new Intent(ChineseCategoriesActivity.this,
					ProductListShowActivity.class);
			intent.putExtra("producttype", "chuan");
			this.startActivity(intent);
			break;
		case R.id.chinese_yuecai:
			intent = new Intent(ChineseCategoriesActivity.this,
					ProductListShowActivity.class);
			intent.putExtra("producttype", "yue");
			this.startActivity(intent);
			break;
		case R.id.chinese_huicai:
			intent = new Intent(ChineseCategoriesActivity.this,
					ProductListShowActivity.class);
			intent.putExtra("producttype", "hui");
			this.startActivity(intent);
			break;
		case R.id.chinese_xiangcai:
			intent = new Intent(ChineseCategoriesActivity.this,
					ProductListShowActivity.class);
			intent.putExtra("producttype", "xiang");
			this.startActivity(intent);
			break;

		default:
			break;
		}
	}

}
