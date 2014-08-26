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
 * ��ҳ��Ŀ��Ʋ� ����������ҳ��ķ�ҳ����
 * @author �Խ��
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
	 * ��ʾ��ҳ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showIndexPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//�����ҳ
		ProductsBiz proBiz = new ProductsBiz();	
		int pageCount = proBiz.getPageCount(proBiz.getAllNotDiscount(proBiz.getAll()), 8);   //��ʾ������Ʒ�в����۵���Ʒ��ÿ��ҳ����ʾ8��product��pageCount��ҳ����
		
		int pageNum;				//pageNum����ʾ��pageNumҳ
		if (request.getParameter("pageNum") != null) {    //Ϊ�գ���ʾ��ҳ
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			if(pageNum<1){           //����û���ͣ�ĵ����һҳ����ᵼ��pageNum<1 ,��ֻ��ʾ��ҳ
				pageNum = 1;
			}
			if(pageNum>pageCount){   //����û���ͣ�ĵ����һҳ����ᵼ��pageNum>pageCount,��ֻ��ʾβҳ
				pageNum = pageCount;
			}
		} else {
			pageNum = 1;
		}
		//��ʾ���в����۵���Ʒÿҳ��ʾ8��    �ڵ�pageNumҳ
		List<Products> listNotDiscount = proBiz.getAllByPage(proBiz.getAllNotDiscount(proBiz.getAll()),pageNum, 8);	
		//System.out.println(listNotDiscount.size());
		request.getSession().setAttribute("pageCount", pageCount);
		request.setAttribute("listNotDiscount", listNotDiscount);
		request.setAttribute("pageNum", pageNum);
		//��ʾ���۵���Ʒÿҳ��ʾ3�� 
		List<Products> listDiscount = proBiz.getAllByPage(proBiz.getAllDiscount(proBiz.getAll()),1, 3);
		request.setAttribute("listDiscount", listDiscount);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	public void discount(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ProductsBiz proBiz = new ProductsBiz();	
		int DiscountpageCount = proBiz.getPageCount(proBiz.getAllDiscount(proBiz.getAll()), 8);   //��ʾ������Ʒ�д��۵���Ʒ��ÿ��ҳ����ʾ4��product��pageCount��ҳ����
		
		int DiscountpageNum;				//pageNum����ʾ��pageNumҳ
		if (request.getParameter("DiscountpageNum") != null) {    //Ϊ�գ���ʾ��ҳ
			DiscountpageNum = Integer.parseInt(request.getParameter("DiscountpageNum"));
			if(DiscountpageNum<1){           //����û���ͣ�ĵ����һҳ����ᵼ��pageNum<1 ,��ֻ��ʾ��ҳ
				DiscountpageNum = 1;
			}
			if(DiscountpageNum>DiscountpageCount){   //����û���ͣ�ĵ����һҳ����ᵼ��pageNum>pageCount,��ֻ��ʾβҳ
				DiscountpageNum = DiscountpageCount;
			}
		} else {
			DiscountpageNum = 1;
		}
		//��ʾ���д��۵���Ʒÿҳ��ʾ4��    �ڵ�pageNumҳ
		List<Products> listDiscount = proBiz.getAllByPage(proBiz.getAllDiscount(proBiz.getAll()),DiscountpageNum, 8);	
		request.getSession().setAttribute("DiscountpageCount", DiscountpageCount);
		request.setAttribute("listDiscount", listDiscount);
		request.setAttribute("DiscountpageNum", DiscountpageNum);		
		request.getRequestDispatcher("discountProducts.jsp").forward(request, response);
	}
}
