package com.order.bll;

import java.util.ArrayList;
import java.util.List;

import com.order.bean.Products;
import com.order.dao.subsystem.ProductsDAO;

/**
 * products的业务逻辑层
 * 
 * @author 赵金灿
 * 
 */
public class ProductsBiz {

	/**
	 * 得到所有product信息
	 */
	public List<Products> getAll() {
		ProductsDAO proDao = new ProductsDAO();
		System.out.println(proDao.toString());
		return (List<Products>) proDao.findAll();
	}

	/**
	 * 
	 * 每一页固定显示8个product信息
	 * 
	 * @param pageNum
	 *            第几页
	 * @param pageSize
	 *            每页显示几个
	 * @return
	 */
	public List<Products> getAllByPage(List<Products> list,int pageNum, int pageSize) {
		int listSize = list.size();
		List<Products> li = new ArrayList<Products>();
		int index = 0;
		//  (listSize - pageSize*(pageNum-1))  最后一页剩下的product的个数 
		for (int i = (pageNum - 1) * pageSize; i < pageNum * pageSize && index < (listSize - pageSize*(pageNum-1)); i++) {
			li.add(list.get(i));
			index++;
		}
		return li;
	}
	/**
	 * 求出所有产品可以构成几页
	 * @param List<Products> 要分页的产品列表
	 * @param pageNum  要显示的总页数
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
	 * 得到所有list中打折的商品，并存入listDiscount中
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
	 * 得到所有list中不打折的商品，并存入listNotDiscount中
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