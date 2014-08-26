package com.dinnerorder.activity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.dinnerorder.R;
import com.dinnerorder.bean.Cart;
import com.dinnerorder.bean.CartItem;
import com.dinnerorder.utils.DinnerOrderApplication;
import com.dinnerorder.utils.NetworkUtils;

public class OrderDetailActivity extends Activity {
	private TextView receiveName_textview;
	private TextView receiveAddress_textview;
	private TextView contactMethod_textview;
	private TextView orderCount_textview;
	private TextView orderAccount_textview;
	private TextView payMethod_textview;
	private Button payForOrder;
	static final int FINISH = 0x122;
	ProgressDialog pd;
	Cart cart;
	Map<String, String> jsonMap;
	DinnerOrderApplication doa;
	Map<String, String> jsonparam;
	int selectedIndex = 0;
	Handler handle = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (msg.what == FINISH) {
				pd.dismiss();
				cart.clear();
				new AlertDialog.Builder(OrderDetailActivity.this)
						.setTitle("返回主页")
						.setMessage("订单提交成功，返回主页吗？")
						.setPositiveButton("是",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int whichButton) {
										Intent intent = new Intent(
												OrderDetailActivity.this,
												MainActivity.class);
										intent.putExtra("startsign","paysuccess");
										startActivity(intent);
									}
								})

						.setNegativeButton("否",
								new DialogInterface.OnClickListener() {

									public void onClick(DialogInterface dialog,
											int which) {
										// System.out.println("你好啊");

									}
								}).show();
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_detail);

		doa = (DinnerOrderApplication) getApplicationContext();
		cart = doa.getCart();

		receiveName_textview = (TextView) this
				.findViewById(R.id.order_detail_receive_name);
		receiveAddress_textview = (TextView) this
				.findViewById(R.id.order_detail_receive_address);
		contactMethod_textview = (TextView) this
				.findViewById(R.id.order_detail_contact_method);
		orderCount_textview = (TextView) this
				.findViewById(R.id.order_detail_all_count);
		orderAccount_textview = (TextView) this
				.findViewById(R.id.order_detail_order_account);
		payMethod_textview = (TextView) this
				.findViewById(R.id.order_detail_pay_method);
		payForOrder = (Button) this
				.findViewById(R.id.order_detail_pay_for_order);

		orderCount_textview.setText(String.valueOf(cart.getNum()));
		orderAccount_textview.setText(String.valueOf(cart.getPrice()));

		payForOrder.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				jsonMap = new HashMap<String, String>();
				jsonMap.put("customerid", String.valueOf(doa.getId()));
				jsonMap.put("receiveName",
						String.valueOf(receiveName_textview.getText()));
				jsonMap.put("receiveAddress",
						String.valueOf(receiveAddress_textview.getText()));
				String paymethod = "baby";
				String temp_str_pay = String.valueOf(payMethod_textview.getText());
				// 此处还需操作 "支付宝支付", "银行卡支付","现金付款" };
				if(temp_str_pay.equals("支付宝支付")){
					paymethod = "baby";
				}else if(temp_str_pay.equals("银行卡支付")){
					paymethod = "bankcard";
				}else if(temp_str_pay.equals("现金付款")){
					paymethod = "cashondeliver";
				}
				jsonMap.put("paymethod",
						paymethod);
				Map<Integer, CartItem> items = cart.getItems();
				int i = 0;
				for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
					jsonMap.put(
							String.valueOf(i),
							String.valueOf(entry.getKey()) + "%"
									+ String.valueOf(entry.getValue().getNum()));
					i++;
				}

				/*
				 * JSONObject o = new JSONObject();
				 * o.put("customerid",doa.getId()); o.put("receiveName",
				 * String.valueOf(receiveName_textview.getText()));
				 * o.put("receiveAddress"
				 * ,String.valueOf(receiveAddress_textview.getText()));
				 * JSONArray array = new JSONArray();
				 */
				/*
				 * for(int i=0;;i++){ array.put(i,); }
				 */
				/*
				 * jsonparam = new HashMap<String,String>();
				 * jsonparam.put("json",json);
				 */
				new Thread() {
					public void run() {
						Looper.prepare();
						try {
							 pd = new ProgressDialog(
									OrderDetailActivity.this);
							pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
							pd.setTitle("提示");
							pd.setMessage("正在提交订单");
							pd.setCancelable(false);
							pd.show();
							String str = NetworkUtils
									.postRequest(NetworkUtils.BASE_URL
											+ "PayServletAndroid", jsonMap);
							Log.v("ZW",str);
							
							handle.sendEmptyMessage(FINISH);
						} catch (ClientProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Looper.loop();
					}

				}.start();
			}
		});

		payMethod_textview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				final String[] arrayFruit = new String[] { "支付宝支付", "银行卡支付",
						"现金付款" };

				Dialog dialog = new AlertDialog.Builder(
						OrderDetailActivity.this)
						.setTitle("请选择付款方式啊亲?")
						.setIcon(R.drawable.ic_launcher)
						.setPositiveButton("确定",
								new DialogInterface.OnClickListener() {

									public void onClick(DialogInterface dialog,
											int which) {
										payMethod_textview
												.setText(arrayFruit[selectedIndex]);
										selectedIndex = 0;
									}
								})
						.setSingleChoiceItems(arrayFruit, 0,
								new DialogInterface.OnClickListener() {

									public void onClick(DialogInterface dialog,
											int which) {
										selectedIndex = which;
									}
								})
						.setNegativeButton("取消",
								new DialogInterface.OnClickListener() {

									public void onClick(DialogInterface dialog,
											int which) {
										selectedIndex = 0;
									}
								}).create();
				dialog.show();
			}
		});
	}

}
