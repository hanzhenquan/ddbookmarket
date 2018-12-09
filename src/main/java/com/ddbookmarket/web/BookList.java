package com.ddbookmarket.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddbookmarket.biz.BookaddBiz;
import com.ddbookmarket.biz.impl.BookaddBizimpl;
import com.ddbookmarket.model.Bookaddtype;
import com.ddbookmarket.util.PageZongshu;

/**
 * Servlet implementation class BookList
 */
@WebServlet("/bookList")
public class BookList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strdangqianye=request.getParameter("dangqianpage");
		if(strdangqianye==null) {
			strdangqianye="1";
		}
        int dangqianpage=Integer.parseInt(strdangqianye);	
        String name=request.getParameter("name");
        System.out.println(name+"---------name");
        String strsid=request.getParameter("sid")==null?"-1":request.getParameter("sid");
        int sid=Integer.parseInt(strsid);
        String strbid=request.getParameter("bid")==null?"-1":request.getParameter("bid");
        int bid=Integer.parseInt(strbid);
        
        
		BookaddBiz BookaddBiz=new BookaddBizimpl();
		List<Bookaddtype> ls=BookaddBiz.findbook(dangqianpage,name,sid);  
		int zongrow=BookaddBiz.zongrow(name,sid);
		int zongpage=zongrow%PageZongshu.PAGE_SIZE==0?zongrow/PageZongshu.PAGE_SIZE:zongrow/PageZongshu.PAGE_SIZE+1;
		request.setAttribute("zongpage",zongpage);
		request.setAttribute("dangqianpage",dangqianpage);
		request.setAttribute("ls",ls);
		request.setAttribute("bid",bid);
		request.setAttribute("sid",sid);
		request.setAttribute("name",name);
		request.getRequestDispatcher("BookListt.jsp").forward(request, response);
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
