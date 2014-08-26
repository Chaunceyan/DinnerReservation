package com.order.bll;

import java.util.ArrayList;
import java.util.List;

import com.order.bean.Products;
import com.order.dao.subsystem.ProductsDAO;

/**
 * products��ҵ���߼���
 * 
 * @author �Խ��
 * 
 */
public class ProductsBiz {

	/**
	 * �õ�����product��Ϣ
	 */
	public List<Products> getAll() {
		ProductsDAO proDao = new ProductsDAO();
		System.out.println(proDao.toString());
		return (List<Products>) proDao.findAll();
	}

	/**
	 * 
	 * ÿһҳ�̶���ʾ8��product��Ϣ
	 * 
	 * @param pageNum
	 *            �ڼ�ҳ
	 * @param pageSize
	 *            ÿҳ��ʾ����
	 * @return
	 */
	public List<Products> getAllByPage(List<Products> list,int pageNum, int pageSize) {
		int listSize = list.size();
		List<Products> li = new ArrayList<Products>();
		int index = 0;
		//  (listSize - pageSize*(pageNum-1))  ���һҳʣ�µ�product�ĸ��� 
		for (int i = (pageNum - 1) * pageSize; i < pageNum * pageSize && index < (listSize - pageSize*(pageNum-1)); i++) {
			li.add(list.get(i));
			index++;
		}
		return li;
	}
	/**
	 * ������в�Ʒ���Թ��ɼ�ҳ
	 * @param List<Products> Ҫ��ҳ�Ĳ�Ʒ�б�
	 * @param pageNum  Ҫ��ʾ����ҳ��
	 */
	public int getPageCount(List<Products> list,int pageNum){
		int listSize = list.size();
		if (listSize%pageNum==0){
			return listSize/pageNum;
		}else{
			return listSize/pageNum +1;
		}
	}
	/**
	 * �õ�����list�д��۵���Ʒ��������listDiscount��
	 * @param list
	 * @return
	 */
	public List<Products> getAllDiscount(List<Products> list){
		List<Products> listDiscount = new ArrayList<Products>();
		for(int i =0;i<list.size();i++){
			if(list.get(i).getProductsDiscount()<100){
				listDiscount.add(list.get(i));
			}
		}
		return listDiscount;
	}
	/**
	 * �õ�����list�в����۵���Ʒ��������listNotDiscount��
	 * @param list
	 * @return
	 */
	public List<Products> getAllNotDiscount(List<Products> list){
		List<Products> listNotDiscount = new ArrayList<Products>();
		for(int i =0;i<list.size();i++){
			if(list.get(i).getProductsDiscount()==100){
				listNotDiscount.add(list.get(i));
			}
		}
		return listNotDiscount;
	}
}