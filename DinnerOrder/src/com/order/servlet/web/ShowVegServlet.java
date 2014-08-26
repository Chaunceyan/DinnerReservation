package com.order.servlet.web;

/**
 * 控制各种类型的菜的显示
 * @任新蕾
 */

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.bean.Products;
import com.order.bll.VegBIZ;

public class ShowVegServlet extends HttpServlet {
	private String type = null;
	private String chinType = null;
	private String pageIndex = null;
	private Integer lastPageIndex = 0;
	VegBIZ vbiz = new VegBIZ();
	List<Products> fourProducts = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		type = request.getParameter("type");
		chinType = transformWord(type);
		pageIndex = request.getParameter("pageIndex");
		lastPageIndex = vbiz.getLastPage(chinType);
		if (pageIndex.equals("0")) {
			pageIndex = "1";
		} else if (Integer.parseInt(pageIndex) > lastPageIndex) {
			pageIndex = lastPageIndex.toString();
		}
        
		if (lastPageIndex != 0) {
			fourProducts = vbiz.getFourProduct(Integer.parseInt(pageIndex),
					chinType);

			request.getSession().setAttribute("pageIndex", pageIndex);
			request.getSession().setAttribute("fourProducts", fourProducts);
			request.getSession().setAttribute("lastPage",
					lastPageIndex.toString());

			response.sendRedirect("/DinnerOrder/" + type + ".jsp");
		} else {
			response.sendRedirect("/DinnerOrder/noProducts.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private String transformWord(String word) {
		if (word.equals("chuancai")) {
			return "川菜";
		} else if (word.equals("yuecai")) {
			return "粤菜";
		} else if (word.equals("huicai")) {
			return "徽菜";
		} else if (word.equals("xiangcai")) {
			return "湘菜";
		} else
			return "西餐";
	}

}
