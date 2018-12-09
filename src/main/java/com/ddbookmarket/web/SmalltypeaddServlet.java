package com.ddbookmarket.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddbookmarket.biz.SmallTypeBiz;
import com.ddbookmarket.biz.impl.SmallTypeBizimpl;
import com.ddbookmarket.model.Smalltype;
import com.ddbookmarket.util.MyBeanUtils;

/**
 * Servlet implementation class SmalltypeaddServlet
 */
@WebServlet("/smalltypeadd")
public class SmalltypeaddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SmalltypeaddServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Smalltype smalltype=new  Smalltype();
	MyBeanUtils.populate(smalltype, request.getParameterMap());
	SmallTypeBiz smalltypeBiz=new SmallTypeBizimpl();
	boolean ret=smalltypeBiz.save(smalltype);
	if(ret) {
		response.sendRedirect("main.jsp");
	}else {
		request.setAttribute("smalltype", smalltype);
		request.getRequestDispatcher("/Small_type_add.jsp").forward(request, response);
	}
	
	}

}
