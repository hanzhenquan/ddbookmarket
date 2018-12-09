package com.ddbookmarket.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddbookmarket.biz.BookaddBiz;
import com.ddbookmarket.biz.SmallTypeBiz;
import com.ddbookmarket.biz.impl.BookaddBizimpl;
import com.ddbookmarket.biz.impl.SmallTypeBizimpl;
import com.ddbookmarket.model.Bookaddtype;

/**
 * Servlet implementation class BookalteServlet
 */
@WebServlet("/toBookAlte")
public class BookalteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookalteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId=request.getParameter("id");
		int id=Integer.parseInt(strId);
		
		BookaddBiz bookaddBiz=new BookaddBizimpl();
		Bookaddtype book=bookaddBiz.findbookid(id);
		
		SmallTypeBiz smallTypeBiz=new SmallTypeBizimpl();
		int bid=smallTypeBiz.findbidByid(book.getSid());
		System.out.println(bid);
		request.setAttribute("bid",bid);
		request.setAttribute("book",book);
		request.getRequestDispatcher("BookAlte.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
