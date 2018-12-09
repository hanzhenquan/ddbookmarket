package com.ddbookmarket.web;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ddbookmarket.biz.BookaddBiz;
import com.ddbookmarket.biz.impl.BookaddBizimpl;
import com.ddbookmarket.model.Bookaddtype;
import com.ddbookmarket.util.MyBeanUtils;

/**
 * Servlet implementation class DoBookAlteServlet
 */
@WebServlet("/doBookAlte")
@MultipartConfig
public class DoBookAlteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoBookAlteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bookaddtype bookaddtype=new  Bookaddtype();
		MyBeanUtils.populate(bookaddtype, request.getParameterMap(), "yyyy-MM-dd");
		Part part = request.getPart("photo");
		String newfile = null;
		if (part.getHeader("Content-Disposition").contains("; filename=")) {
			if (part.getSubmittedFileName() != null && !part.getSubmittedFileName().equals("")) {
				String ext = part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf(".") + 1);
				newfile = UUID.randomUUID() + "." + ext;
				part.write(request.getServletContext().getRealPath("/upload/" + newfile));
			}
		}
		bookaddtype.setPhoto(newfile);
		System.out.println(bookaddtype+"===========bookaddtype");
		BookaddBiz BookaddBiz=new BookaddBizimpl();
		boolean ret=BookaddBiz.update(bookaddtype);
		if(ret) {
			response.sendRedirect("bookList");
		}else {
			request.setAttribute("book", bookaddtype);
			request.getRequestDispatcher("BookAlte.jsp").forward(request, response);
		}
	}
	}


