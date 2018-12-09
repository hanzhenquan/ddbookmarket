package com.ddbookmarket.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddbookmarket.biz.BookaddBiz;
import com.ddbookmarket.biz.impl.BookaddBizimpl;

/**
 * Servlet implementation class BookdelServlet
 */
@WebServlet("/bookDel")
public class BookdelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookdelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String strdel=request.getParameter("id");
	int delid=Integer.parseInt(strdel);
	BookaddBiz BookaddBiz=new BookaddBizimpl();
	int ret=BookaddBiz.delbook(delid);
	response.sendRedirect("bookList");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
