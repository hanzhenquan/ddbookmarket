package com.ddbookmarket.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.ddbookmarket.biz.AdminBiz;
import com.ddbookmarket.biz.AdminBizImpl;
import com.ddbookmarket.model.Admin;
import com.ddbookmarket.util.MyBeanUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1获取参数值
		Admin admin = new Admin();
		MyBeanUtils.populate(admin, request.getParameterMap());

		String code= request.getParameter("Vcode");
		String serviceCode= (String) request.getSession().getAttribute("validateCode");
//		if(!(serviceCode.equalsIgnoreCase(code))){
//			request.setAttribute("msg","验证码错误");
//			request.setAttribute("admin", admin);
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//           return;
//		}
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//		Validator validator = factory.getValidator();
//		Set<ConstraintViolation<Admin>> constraint = validator.validate(admin);
//		if(constraint.size()>0){
//			Map<String,String> error=new HashMap<String,String>();
//		for (ConstraintViolation<Admin> cv: constraint ) {
//			error.put(cv.getPropertyPath().toString(),cv.getMessage());
//		}
//		    request.setAttribute("error",error);
//			request.setAttribute("admin", admin);
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//			return;
//	}
		Map<String,String> error=new HashMap<String,String>();
		if(!(serviceCode.equalsIgnoreCase(code))) {
		   error.put("vcode","验证码错误");
		}
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Admin>> constraint = validator.validate(admin);
		if(constraint.size()>0){
		for (ConstraintViolation<Admin> cv: constraint ) {
			error.put(cv.getPropertyPath().toString(),cv.getMessage());
		}
		}
		if(error.size()>0){
			request.setAttribute("error",error);
			request.setAttribute("admin", admin);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		//2到数据库对比
		AdminBiz adminBiz = new AdminBizImpl();
		boolean ret = adminBiz.findByAdmin(admin);
		//3根据对比结果给用户一个界面
		if (ret) {
			request.getSession().setAttribute("hasLogined",true);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} else {
			request.setAttribute("admin", admin);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
