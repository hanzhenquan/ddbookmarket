package com.ddbookmarket.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ddbookmarket.biz.BigtypeBiz;
import com.ddbookmarket.biz.impl.BigtypeBizImpl;
@WebServlet("/bigtypeadd")
public class Big_typeadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Big_typeadd() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得name属性的值
		String name=request.getParameter("name");
		//让小弟把name保存到数据库
		//声明个接口让接口=让接口实现
		BigtypeBiz bigtypebiz=new BigtypeBizImpl();
		//返回一个布尔值，然后判断下一步
		 boolean ret=bigtypebiz.save(name);
		if (ret) {
		     response.sendRedirect("main.html");
		} else {
			request.setAttribute("name",name);// 把用户填写的User信息带过去
			request.getRequestDispatcher("Big_typeadd.jsp").forward(request, response);
		}		
		
	}

}
