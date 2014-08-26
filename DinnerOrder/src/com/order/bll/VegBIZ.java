package com.order.bll;

import java.util.ArrayList;
import java.util.List;

import com.order.bean.Productcategories;
import com.order.bean.Products;
import com.order.dao.subsystem.ProductcategoriesDAO;
import com.order.dao.subsystem.ProductsDAO;

/**
 * 获得各种分类菜的业务逻辑层
 * 
 * @author 任新蕾
 * 
 */
public class VegBIZ {

	/**
	 * 获得所有类型为type的菜
	 * 
	 * @param type
	 *            菜的类型：川菜，粤菜。。。
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Products> getAllVeg(String type) {

		List<Products> products = new ArrayList<Products>();
		ProductsDAO pd = new ProductsDAO();
		// 在productcategories表中获得川菜对应的id
		ProductcategoriesDAO pcd = new ProductcategoriesDAO();
		Productcategories pcdID = ((Productcategories) pcd.findByCategoryName(
				type).get(0));
		// 在products表中通过得到的id获得所有类型为川菜的菜品(List<Products>)
		if (type.equals("all")) {
			products = pd.findAll();
			return products;
		} else {
			products = (List<Products>) pd.findByProperty("productcategories",
					pcdID);
			return products;
		}
	}

	/**
	 * 获得当前页面应该显示的8个菜品
	 * 
	 * @param pageIndex
	 *            当前页面值
	 * @return
	 */
	public List<Products> getFourProduct(int pageIndex, String type) {
		List<Products> fourProducts = new ArrayList<Products>();
		List<Products> products = getAllVeg(type);
		int index = 0;
		for (int i = (pageIndex - 1) * 8; i < pageIndex * 8
				&& index < products.size() - (pageIndex - 1) * 8; i++) {
			fourProducts.add(products.get(i));
			index++;
		}
		return fourProducts;
	}

	/**
	 * 获得所有产品显示在页面上对应的总页数
	 * 
	 * @return
	 */
	public Integer getLastPage(String type) {
		List<Products> products = getAllVeg(type);
		if (products.size() % 8 == 0)
			return products.size() / 8;
		else
			return products.size() / 8 + 1;
	}
}
