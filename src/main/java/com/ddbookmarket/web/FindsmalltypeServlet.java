package com.ddbookmarket.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.ddbookmarket.biz.SmallTypeBiz;
import com.ddbookmarket.biz.impl.SmallTypeBizimpl;
import com.ddbookmarket.model.Smalltype;

/**
 * Servlet implementation class FindsmalltypeServlet
 */
@WebServlet("/findAllSmallType")
public class FindsmalltypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindsmalltypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String strbid=request.getParameter("bid");
	int bid=Integer.parseInt(strbid);
	String callback=request.getParameter("callback");
	SmallTypeBiz smallTypeBiz=new SmallTypeBizimpl();
	List<Smalltype>ls=smallTypeBiz.fanAllbid(bid);
	System.out.println(ls+"----------");
	
	
	response.setContentType("text/javascript;charset=UTF-8");
	PrintWriter pw=response.getWriter();
	JSONArray json=new JSONArray(ls);
	//把Java的List转为js的List
	pw.println(callback+"("+json.toString()+")");
	pw.flush();
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
