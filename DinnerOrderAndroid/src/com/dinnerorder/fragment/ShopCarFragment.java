package com.dinnerorder.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.dinnerorder.R;
import com.dinnerorder.activity.OrderDetailActivity;
import com.dinnerorder.bean.Cart;
import com.dinnerorder.bean.CartItem;
import com.dinnerorder.bean.Products;
import com.dinnerorder.utils.DinnerOrderApplication;

public class ShopCarFragment extends Fragment {
	private List<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();;
	private Map<Integer,CartItem> cartItems;
	Cart cart;
	SimpleAdapter adapter;
	private Button pay;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		DinnerOrderApplication doa = (DinnerOrderApplication) getActivity()
				.getApplicationContext();
		 cart = doa.getCart();
		 cartItems = cart.getItems();
		if(cartItems.isEmpty()){
			return inflater.inflate(R.layout.fragment_shop_car_with_noelement, null);
		}else{
			return showCart(inflater);
		}
		
	}

	private View showCart(LayoutInflater inflater) {

		View view = inflater.inflate(R.layout.fragment_shop_car, null);
		ListView listView = (ListView) view
				.findViewById(R.id.fragment_shop_Car_listView);
		pay = (Button) view.findViewById(R.id.fragment_shop_car_pay);
		pay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(),OrderDetailActivity.class);
				startActivity(intent);
			}
		});
		int i = 1;
		for(Map.Entry<Integer,CartItem> entry: cartItems.entrySet()){
			HashMap<String, String> item = new HashMap<String, String>();
			item.put("number",String.valueOf(i));
			Products product = entry.getValue().getProducts();
			item.put("dishname",product.getProductsName());
			//products.getProductsPrice()*products.getProductsDiscount()/100
			item.put("price",String.valueOf(product.getProductsPrice()*product.getProductsDiscount()/100));
			item.put("amount", String.valueOf(entry.getValue().getNum()));
			item.put("subtotal",String.valueOf(entry.getValue().getPrice()));
			item.put("id",String.valueOf(product.getProductsId()));
			data.add(item);
			i++;
			
		}
		// 创建SimpleAdapter适配器将数据绑定到item显示控件上
		 adapter = new ShopCarSimpleAdapter(this
				.getActivity().getApplicationContext(), data,
				R.layout.item_shop_car, new String[] { "number", "dishname",
						"price", "amount", "subtotal" }, new int[] {
						R.id.shop_car_item_number, R.id.shop_car_item_dishname,
						R.id.shop_car_item_price, R.id.shop_car_item_amount,
						R.id.shop_car_item_subtotal });
		// 实现列表的显示
		listView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					final int arg2, final long arg3) {
				// showDialog("你好", R.string.bq_info);
				new AlertDialog.Builder(ShopCarFragment.this.getActivity())
						.setTitle("删除选项")
						.setMessage("确定删除吗？")
						.setPositiveButton("删除",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int whichButton) {
										/*
										 * setResult(REULT_OK);// 确定按钮事件
										 * finish();返回上一页
										 */
										
										cart.getItems().remove(Integer.valueOf(data.get(arg2).get("id")));
										data.remove(arg2);
										
										adapter.notifyDataSetChanged();
									}
								})

						.setNegativeButton("取消",
								new DialogInterface.OnClickListener() {

									public void onClick(DialogInterface dialog,
											int which) {
										// System.out.println("你好啊");

									}
								}).show();
				// Log.i("zsy", "BBB click the list item @ position = " + arg2 +
				// ", and id = " + arg3);
				return false;

			}

		});
		return view;
		
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	class ShopCarSimpleAdapter extends SimpleAdapter {
		Context context;
		
		public ShopCarSimpleAdapter(Context context,
				List<? extends Map<String, ?>> data, int resource,
				String[] from, int[] to) {
			super(context, data, resource, from, to);
			this.context = context;
		}

		@Override
		public int getCount() {
			return super.getCount();
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {

			View view = super.getView(position, convertView, parent);
			ImageButton plus_imagebutton = (ImageButton) view
					.findViewById(R.id.shop_car_item_add);
			ImageButton reduce_imagebutton = (ImageButton) view
					.findViewById(R.id.shop_car_item_reduce);
			final EditText text = (EditText) view.findViewById(R.id.shop_car_item_amount);
			plus_imagebutton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					String str = text.getText().toString();
					int mount = Integer.valueOf(str);
					mount += 1;
					text.setText(String.valueOf(mount));
					CartItem itemtemp = cart.getItems().get(Integer.valueOf(data.get(position).get("id")));
					itemtemp.setNum(itemtemp.getNum()+1);
					cart.getItems().put(Integer.valueOf(data.get(position).get("id")), itemtemp);
				}
			});
			reduce_imagebutton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					String str = text.getText().toString();
					int mount = Integer.valueOf(str);
					if (mount == 1) {
						return;
					} else {
						mount -= 1;
						text.setText(String.valueOf(mount));
						CartItem itemtemp = cart.getItems().get(Integer.valueOf(data.get(position).get("id")));
						itemtemp.setNum(itemtemp.getNum()-1);
						cart.getItems().put(Integer.valueOf(data.get(position).get("id")), itemtemp);
					}
				}
			});
			return view;
		}

	}
}
