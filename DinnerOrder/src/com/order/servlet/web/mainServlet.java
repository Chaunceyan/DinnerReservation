package com.order.servlet.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.bean.Cart;
import com.order.bean.Products;
import com.order.bll.ProductsBiz;
/**
 * 主页面的控制层 用来处理主页面的分页问题
 * @author 赵金灿
 *
 */
public class mainServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		if(request.getSession().getAttribute("customer")==null){
			request.getSession().setAttribute("isSignIn",false);
		}else{
			request.getSession().setAttribute("isSignIn",true);
		}
		request.getSession().setAttribute("cart", Cart.getInstance());
		if(request.getParameter("action")==null){
			showIndexPage(request,response);
		}
		else if(request.getParameter("action").equals("discount")){
			discount(request,response);		
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doGet(request, response);
	}
	/**
	 * 显示主页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showIndexPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//处理分页
		ProductsBiz proBiz = new ProductsBiz();	
		int pageCount = proBiz.getPageCount(proBiz.getAllNotDiscount(proBiz.getAll()), 8);   //显示所有商品中不大折的商品，每个页面显示8个product，pageCount总页面数
		
		int pageNum;				//pageNum：显示第pageNum页
		if (request.getParameter("pageNum") != null) {    //为空，显示首页
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			if(pageNum<1){           //如果用户不停的点击上一页，则会导致pageNum<1 ,则只显示首页
				pageNum = 1;
			}
			if(pageNum>pageCount){   //如果用户不停的点击下一页，则会导致pageNum>pageCount,则只显示尾页
				pageNum = pageCount;
			}
		} else {
			pageNum = 1;
		}
		//显示所有不打折的商品每页显示8个    在第pageNum页
		List<Products> listNotDiscount = proBiz.getAllByPage(proBiz.getAllNotDiscount(proBiz.getAll()),pageNum, 8);	
		//System.out.println(listNotDiscount.size());
		request.getSession().setAttribute("pageCount", pageCount);
		request.setAttribute("listNotDiscount", listNotDiscount);
		request.setAttribute("pageNum", pageNum);
		//显示打折的商品每页显示3个 
		List<Products> listDiscount = proBiz.getAllByPage(proBiz.getAllDiscount(proBiz.getAll()),1, 3);
		request.setAttribute("listDiscount", listDiscount);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	public void discount(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ProductsBiz proBiz = new ProductsBiz();	
		int DiscountpageCount = proBiz.getPageCount(proBiz.getAllDiscount(proBiz.getAll()), 8);   //显示所有商品中打折的商品，每个页面显示4个product，pageCount总页面数
		
		int DiscountpageNum;				//pageNum：显示第pageNum页
		if (request.getParameter("DiscountpageNum") != null) {    //为空，显示首页
			DiscountpageNum = Integer.parseInt(request.getParameter("DiscountpageNum"));
			if(DiscountpageNum<1){           //如果用户不停的点击上一页，则会导致pageNum<1 ,则只显示首页
				DiscountpageNum = 1;
			}
			if(DiscountpageNum>DiscountpageCount){   //如果用户不停的点击下一页，则会导致pageNum>pageCount,则只显示尾页
				DiscountpageNum = DiscountpageCount;
			}
		} else {
			DiscountpageNum = 1;
		}
		//显示所有打折的商品每页显示4个    在第pageNum页
		List<Products> listDiscount = proBiz.getAllByPage(proBiz.getAllDiscount(proBiz.getAll()),DiscountpageNum, 8);	
		request.getSession().setAttribute("DiscountpageCount", DiscountpageCount);
		request.setAttribute("listDiscount", listDiscount);
		request.setAttribute("DiscountpageNum", DiscountpageNum);		
		request.getRequestDispatcher("discountProducts.jsp").forward(request, response);
	}
}
