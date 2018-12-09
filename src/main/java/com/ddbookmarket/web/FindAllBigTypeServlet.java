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

import com.ddbookmarket.biz.BigtypeBiz;
import com.ddbookmarket.biz.impl.BigtypeBizImpl;
import com.ddbookmarket.model.Bigtype;

/**
 * Servlet implementation class FindAllBigTypeServlet
 */
@WebServlet("/findAllBigType")
public class FindAllBigTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindAllBigTypeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		
//		BigtypeBiz bigtypeBiz=new BigtypeBizImpl();
//		List<Bigtype> ls=bigtypeBiz.findAllBigType();
//		
//		//往客户端网页传获得的内容，要是js代码
//		//告诉要写js
//		response.setContentType("text/javascript;charset=UTF-8");
//		PrintWriter out=response.getWriter();
//		//把获得的内容转换成js内容，然后填到select中的option值中
//		JSONArray jsonArray=new JSONArray(ls);
//		out.print("findsel("+jsonArray.toString() +")");
//		out.flush();
		
		
		  String callback=request.getParameter("callback");
			System.out.println(callback+"----------");
			BigtypeBiz bigBiz=new BigtypeBizImpl();
			List<Bigtype> ls=bigBiz.findAllBigType();
			response.setContentType("text/javascript;charset=UTF-8");
			PrintWriter pw=response.getWriter();
			JSONArray json=new JSONArray(ls);
			//把Java的List转为js的List
			pw.println(callback+"("+json.toString()+")");
			pw.flush();
		
		
//		
//		BigtypeBiz bigBiz=new BigtypeBizImpl();
//		List<Bigtype> ls=bigBiz.findAllBigType();
//		response.setContentType("text/javascript;charset=UTF-8");
//		PrintWriter pw=response.getWriter();
//		JSONArray json=new JSONArray(ls);
//		//把Java的List转为js的List
//		pw.write("findsel("+json.toString()+")");
//		pw.flush();

		
	}

}
