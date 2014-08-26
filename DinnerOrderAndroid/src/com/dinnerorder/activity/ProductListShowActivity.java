package com.dinnerorder.activity;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.Toast;

import com.dinnerorder.R;
import com.dinnerorder.bean.Products;
import com.dinnerorder.utils.NetworkUtils;
import com.google.gson.stream.JsonReader;

public class ProductListShowActivity extends Activity {
	final int REFRESH = 0x111;
	final int NOTIFYA = 0x11112;
	final int NO = 0x222;
	private ListView product_listview;
	private SimpleAdapter adapter;
	private SwipeRefreshLayout swipeRefresh;
	private View headerView;
	private Handler handler;
	private ArrayList<Products> allList = new ArrayList<Products>();
	private ArrayList<HashMap<String, Object>> listItems = new ArrayList<HashMap<String, Object>>();
	private Handler myHandler;
	private String productType = "";
	private int COUNT = 1;
	private Thread thread = new Thread() {
		@Override
		public void run() {
			Looper.prepare();
			handler = new Handler() {
				public void handleMessage(Message msg) {
					Log.v("ZW", "havemessage in thread");
					if (msg.what == REFRESH) {
						Map<String, String> mapToSend = new HashMap<String, String>();
						Log.v("ZW", "inthread" + productType);
						mapToSend.put("type", productType);
						mapToSend.put("count", String.valueOf(COUNT));
						try {
							String str = NetworkUtils.postRequest(
									NetworkUtils.BASE_URL
											+ "showOrderServletAndroid",
									mapToSend);
							// 本菜单下面项
							COUNT++;
							if(str.equals("no")){
								Message mmmessage = new Message();
								mmmessage.what = NO;
								myHandler.sendMessage(mmmessage);
								return;
							}
							str = URLDecoder.decode(str, "utf-8");
							List<Products> list = parseJson(str);
							list.addAll(allList);
							allList = (ArrayList<Products>) list;
							ArrayList<HashMap<String, Object>> temp = new ArrayList<HashMap<String, Object>>(
									listItems);
							ArrayList<HashMap<String, Object>> temp1 = new ArrayList<HashMap<String, Object>>();

							for (int i = 0; i < list.size(); i++) {
								HashMap<String, Object> mapItem = new HashMap<String, Object>();
								mapItem.put("productname", list.get(i)
										.getProductsName());
								mapItem.put("beforprice", list.get(i)
										.getProductsPrice());
								URL url = null;
								try {
									url = new URL(list.get(i).getProductPicture());
								} catch (MalformedURLException e) {
								}
								Bitmap bitmap = null;
								try {
									HttpURLConnection conn = (HttpURLConnection) url
											.openConnection();
									InputStream inputStream = conn
											.getInputStream();
									bitmap = BitmapFactory
											.decodeStream(inputStream);
								} catch (Exception e) {
									Log.v("ZW", e.getMessage());
								}

								mapItem.put("image", bitmap);

								
								mapItem.put("nowprice", String.valueOf(Integer
										.valueOf(list.get(i).getProductsDiscount())
										* Float.valueOf(list.get(i)
												.getProductsPrice()) / 100));

								temp1.add(mapItem);
							}
							temp1.addAll(temp);
							Log.v("ZW", temp1.toString());
							Message mm = Message.obtain();
							mm.what = NOTIFYA;
							mm.obj = temp1;
							myHandler.sendMessage(mm);

						} catch (IOException e) {
							e.printStackTrace();
						}

					}
				}

			};
			Looper.loop();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		if (savedInstanceState != null) {
			savedInstanceState = null;
		}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_list);
		initial();
		Log.v("ZW", "oncreate" + thread.isAlive());
	}

	void initial() {
		thread.start();

		productType = getIntent().getExtras().getString("producttype");
		product_listview = (ListView) this
				.findViewById(R.id.product_show_list_product_list);
		swipeRefresh = (SwipeRefreshLayout) this
				.findViewById(R.id.product_show_list_swipe_refresh);
		headerView = getLayoutInflater().inflate(R.layout.list_refresh_header,
				null);
		swipeRefresh.setColorScheme(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_purple);
		adapter = new SimpleAdapter(this, listItems,
				R.layout.item_product_list, new String[] { "productname",
						"image", "beforprice", "nowprice" }, new int[] {
						R.id.product_show_list_product_name,
						R.id.product_list_item_show_product_image,
						R.id.product_show_list_prime_cost,
						R.id.product_show_list_now_cost });
		adapter.setViewBinder(new ViewBinder() {

			@Override
			public boolean setViewValue(View view, Object data,
					String textRepresentation) {
				if (view instanceof ImageView && data instanceof Bitmap) {
					ImageView i = (ImageView) view;
					i.setImageBitmap((Bitmap) data);
					return true;
				}
				return false;
			}
		});
		product_listview.setAdapter(adapter);
		product_listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(ProductListShowActivity.this,ProductsDetailActivity.class);
				intent.putExtra("productObject",allList.get(position));
				startActivity(intent);
			}
		});
		swipeRefresh.setOnRefreshListener(new OnRefreshListener() {
			@Override
			public void onRefresh() {
				product_listview.addHeaderView(headerView);
				Message msg = new Message();
				msg.what = REFRESH;
				handler.sendMessage(msg);
			}
		});
		try {
			thread.join(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				if (msg.what == NOTIFYA) {
					Log.v("ZW", "nimeia");
					ArrayList<HashMap<String, Object>> ttt = new ArrayList<HashMap<String, Object>>(
							(ArrayList<HashMap<String, Object>>) msg.obj);

					listItems.clear();
					adapter.notifyDataSetChanged();

					for (HashMap<String, Object> ii : ttt) {
						listItems.add(ii);
					}
					adapter.notifyDataSetChanged();
					swipeRefresh.setRefreshing(false);
					product_listview.removeHeaderView(headerView);

				}else if(msg.what==NO){
					Toast.makeText(ProductListShowActivity.this, "已经没有了", Toast.LENGTH_SHORT).show();
					swipeRefresh.setRefreshing(false);
					product_listview.removeHeaderView(headerView);
				}
			}
		};

		product_listview.addHeaderView(headerView);
		Message msg = new Message();
		msg.what = REFRESH;
		handler.sendMessage(msg);

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	private List<Products> parseJson(String str) {
		List<Products> list = new ArrayList<Products>();
		JsonReader reader = new JsonReader(new StringReader(str));
		try {
			reader.beginArray();
			// 开始解析数组
			while (reader.hasNext()) {
				Products item = new Products();
				reader.beginObject();// 开始解析对象
				while (reader.hasNext()) {
					String tagName = reader.nextName();
					if (tagName.equals("productsName")) {
						String strss = reader.nextString();
						item.setProductsName(strss);
					}

					else if (tagName.equals("productPicture")) {
						item.setProductPicture(reader.nextString());
					}

					else if (tagName.equals("productsPrice")) {
						item.setProductsPrice(Float.valueOf(reader.nextString()));
					} else if (tagName.equals("productsDiscount")) {
						item.setProductsDiscount(Integer.valueOf(reader
								.nextString()));
					}

					else if (tagName.equals("productcategories")) {
						item.setProductcategoriesID(Integer.valueOf(reader
								.nextInt()));
					} else if (tagName.equals("discountStartTime")) {
						item.setDiscountStartTime(reader.nextString());
					} else if (tagName.equals("productsId")) {
						item.setProductsId(reader.nextInt());
					} else if (tagName.equals("productsDescription")) {
						item.setProductsDescription(reader.nextString());
					} else if (tagName.equals("discountEndTime")) {
						item.setDiscountEndTime(reader.nextString());
					}

					else if (tagName.equals("restaurant")) {
						item.setRestaurantID(reader.nextInt());
					}

					else
						reader.skipValue();
				}
				reader.endObject();
				list.add(item);
			}
			reader.endArray();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	};



}
