package com.order.bll;

import java.util.ArrayList;
import java.util.List;

import com.order.bean.Productcategories;
import com.order.bean.Products;
import com.order.dao.subsystem.ProductcategoriesDAO;
import com.order.dao.subsystem.ProductsDAO;

/**
 * ��ø��ַ���˵�ҵ���߼���
 * 
 * @author ������
 * 
 */
public class VegBIZ {

	/**
	 * �����������Ϊtype�Ĳ�
	 * 
	 * @param type
	 *            �˵����ͣ����ˣ����ˡ�����
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Products> getAllVeg(String type) {

		List<Products> products = new ArrayList<Products>();
		ProductsDAO pd = new ProductsDAO();
		// ��productcategories���л�ô��˶�Ӧ��id
		ProductcategoriesDAO pcd = new ProductcategoriesDAO();
		Productcategories pcdID = ((Productcategories) pcd.findByCategoryName(
				type).get(0));
		// ��products����ͨ���õ���id�����������Ϊ���˵Ĳ�Ʒ(List<Products>)
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
	 * ��õ�ǰҳ��Ӧ����ʾ��8����Ʒ
	 * 
	 * @param pageIndex
	 *            ��ǰҳ��ֵ
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
	 * ������в�Ʒ��ʾ��ҳ���϶�Ӧ����ҳ��
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
