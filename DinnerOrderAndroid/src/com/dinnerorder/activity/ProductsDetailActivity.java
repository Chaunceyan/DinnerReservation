package com.dinnerorder.activity;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dinnerorder.R;
import com.dinnerorder.bean.Products;
import com.dinnerorder.utils.DinnerOrderApplication;

public class ProductsDetailActivity extends Activity implements OnClickListener {
	private TextView productName;
	private TextView originPrice;
	private TextView discountPrice;
	private TextView discount;
	private TextView disBeginTime;
	private TextView disEndTime;
	private TextView saveMoney;
	private TextView description;
	private ImageView image;
	private Button shopCart;
	private Button cartAndBuy;
	private Products product;
	private Handler handle;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_detail);
		createAllWidget();
		product = (Products) getIntent().getSerializableExtra("productObject");
		productName.setText(product.getProductsName());
		originPrice.setText(String.valueOf(product.getProductsPrice()));
		discountPrice.setText(String.valueOf(product.getProductsDiscount()
				* product.getProductsPrice() / 100));
		discount.setText(String.valueOf(product.getProductsDiscount() / 10));
		disBeginTime.setText(product.getDiscountStartTime());
		disEndTime.setText(product.getDiscountEndTime());
		saveMoney.setText(String.valueOf(product.getProductsPrice()
				- product.getProductsDiscount() * product.getProductsPrice()
				/ 100));
		description.setText(product.getProductsDescription());
		handle = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				image.setImageBitmap((Bitmap)msg.obj);
			}
		};
		new Thread() {
			public void run() {
				URL url = null;
				try {
					url = new URL(product.getProductPicture());
				} catch (MalformedURLException e) {
				}
				Bitmap bitmap = null;
				try {
					HttpURLConnection conn = (HttpURLConnection) url
							.openConnection();
					InputStream inputStream = conn.getInputStream();
					bitmap = BitmapFactory.decodeStream(inputStream);
					Message msg = Message.obtain();
					msg.obj = bitmap;
					msg.what = 0x2323;
					handle.sendMessage(msg);
				} catch (Exception e) {
					Log.v("ZW", e.getMessage());
				}
			};
		}.start();
		// new DownloadImage(image).execute(bundle.getString("imageurl"));
		shopCart.setOnClickListener(this);
		cartAndBuy.setOnClickListener(this);
	}

	private void createAllWidget() {
		productName = (TextView) this
				.findViewById(R.id.product_detail_product_name);
		originPrice = (TextView) this
				.findViewById(R.id.product_detail_originPrice);
		originPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		discountPrice = (TextView) this
				.findViewById(R.id.product_detail_discountPrice);
		discount = (TextView) this.findViewById(R.id.product_detail_discount);
		disBeginTime = (TextView) this
				.findViewById(R.id.product_detail_disBeginTime);
		disEndTime = (TextView) this
				.findViewById(R.id.product_detail_disEndTime);
		saveMoney = (TextView) this.findViewById(R.id.product_detail_saveMoney);
		description = (TextView) this
				.findViewById(R.id.product_detail_description);
		image = (ImageView) this
				.findViewById(R.id.product_detail_product_image);
		shopCart = (Button) this.findViewById(R.id.product_detail_shopcart);
		cartAndBuy = (Button) this.findViewById(R.id.product_detail_cartAndBuy);
	}

	@Override
	public void onClick(View v) {
		DinnerOrderApplication doa= (DinnerOrderApplication) getApplicationContext();
		doa.getCart().addProducts2Cart(product);
		switch (v.getId()) {
		case R.id.product_detail_shopcart:
			
			Toast.makeText(this,"已添加至购物车",Toast.LENGTH_SHORT).show();
			break;
		case R.id.product_detail_cartAndBuy:
			Intent intent = new Intent(ProductsDetailActivity.this,MainActivity.class);
			intent.putExtra("startsign", "shopcar");
			intent.putExtra("shopcar",1);
			startActivity(intent);
			break;
		}

	}
}
