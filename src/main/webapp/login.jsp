<%@page import="com.ddbookmarket.model.Admin"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Set" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>小鸟</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker3.css" rel="stylesheet" type="text/css" />
<link href="bower_components/bootswatch/dist/sketchy/bootstrap.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<div class="container-fluid" style="width: 80%">
		<div class="row">
			<div class="col-md-12">
				<div class="card text-white bg-success mb-3" style="max-width: 100rem;">
					<div class="card-body">

						<%--
							Map<String,String> error= (Map<String, String>) request.getAttribute("error");
							if(error!=null){
								Set<String> keyset=error.keySet();
								for (String key:keyset) {
									out.print(key+"----->"+error.get(key));
								}
							}

						--%>

                        <%--
                            if(request.getAttribute("msg")!=null){

                        %>
                        <h1> <%=request.getAttribute("msg"	)%></h1>
                        <%
                            }

                        --%>
						<form method="post" action="login" autocomplete="off" id="inputForm">
							<%
								Map<String,String> error= (Map<String, String>) request.getAttribute("error");
							    Admin admin = (Admin) request.getAttribute("admin");
								if (admin != null) {
									SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							%>
							<h3 class="text-center">登录</h3>
							<br> <br>
							<div class="form-group row">
								<label for="inputName" class="col-sm-2 col-form-label text-right ">用户名</label>
								<div class="col-sm-10">
									<%
										if(error!=null&&error.get("name")!=null){
									%>
									<input type="text" class="form-control is-invalid" id="inputName" placeholder="用户名" name="name" value="<%=admin.getName()==null?"":admin.getName()%>">
									<div class="invalid-feedback">
										<%=error.get("name")%>
									</div>
									<%
									}else {
									%>
									<input type="text" class="form-control" id="inputName" placeholder="用户名" name="name" value="<%=admin.getName()==null?"":admin.getName()%>">
									<%
										}
									%>
								</div>
							</div>
							<div class="form-group row">
								<label for="inputPwd" class="col-sm-2 col-form-label text-right">密码</label>
								<div class="col-sm-10">
									<%
										if(error!=null&&error.get("pwd")!=null){
									%>
									<input type="password" class="form-control is-invalid" id="inputPwd" placeholder="密码" name="pwd" value="<%=admin.getPwd()==null?"":admin.getPwd()%>">
									<div class="invalid-feedback">
										<%=error.get("pwd")%>
									</div>
									<%
									}else{
									%>
									<input type="password" class="form-control" id="inputPwd" placeholder="密码" name="pwd" value="<%=admin.getPwd()==null?"":admin.getPwd()%>">
									<%
										}
									%>

								</div>
							</div>
							<div class="form-group row">
								<label for="inputPwd" class="col-sm-2 col-form-label text-right">验证码</label>
								<div class="col-sm-5">

									<%
									if(error!=null&&error.get("vcode")!=null){
									    %>
									<input  class="form-control is-invalid" id="inputVcode" placeholder="验证码" name="Vcode">
									<div class="invalid-feedback">
										<%=error.get("vcode")%>
									</div>
									    <%
									}else{
									    %>
									    <input  class="form-control" id="inputVcode" placeholder="验证码" name="Vcode">
									    <%
									}
									%>

								</div>
								<div class="col-sm-3">
									<img src="vcode.png" id="yanZheng" style="display: block" title="换一张">

								</div>

							</div>


							<div class="form-group row">
								<div class="col-sm-2"></div>
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary">登录</button>
								</div>
							</div>
							<p style="text-align: center">
								<img src="bower_components/bootstrap/site/docs/4.1/assets/img/favicons/timg.gif">
							</p>
						</form>   
						<%
							} else {
						%>
						<h3 class="text-center">登录</h3>
						<br>
						<br>
						<div class="form-group row">
							<label for="inputName" class="col-sm-2 col-form-label text-right ">用户名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputName" placeholder="用户名" name="name">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputPwd" class="col-sm-2 col-form-label text-right">密码</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="inputPwd" placeholder="密码" name="pwd">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputPwd" class="col-sm-2 col-form-label text-right">验证码</label>
							<div class="col-sm-5">
								<input  class="form-control" id="inputVcode" placeholder="验证码" name="Vcode">
							</div>
							<div class="col-sm-3">
							<img src="vcode.png" id="yanZheng" title="换一张">
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-2"></div>
							<div class="col-sm-10">
								<button type="submit" class="btn btn-primary">登录</button>
							</div>
						</div>
						<p style="text-align: center">
							<img src="bower_components/bootstrap/site/docs/4.1/assets/img/favicons/wow.gif">
						</p>
						</form>
						<%
							}
						%>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="bower_components/jquery/dist/jquery.slim.js"></script>
	<script type="text/javascript" src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("#yanZheng").click(function () {
			$(this).attr("src","vcode.png?t="+Math.random())
        })
	</script>
	<script type="text/javascript" src="bower_components/jquery-validation/dist/jquery.validate.js"></script>
	<script type="text/javascript" src="bower_components/jquery-validation/dist/additional-methods.js"></script>
	<script type="text/javascript" src="bower_components/jquery-validation/src/localization/messages_zh.js"></script>
	<script type="text/javascript">
        $(function () {
            $("#inputForm").validate({
                rules: {
                    name: {
                        required: true,
						maxlength:45,
						minlength:3
                    },
                    pwd: {
                        required: true,
                        maxlength:45,
                        minlength:3
                    },
                    Vcode:{
                        required: true,
                        maxlength:4,
                        minlength:4
					}
                },
                messages: {
                },
                errorElement: "div",
                errorClass: "invalid-feedback",//验证不合法的样式显示样式
                highlight: function (element, errorClass, validClass) {//高亮显示
                    $(element).addClass("is-invalid").removeClass(validClass);
                    // $(element.form).find("label[for=" + element.id + "]")
                    //     .addClass(errorClass);
                },
                unhighlight: function (element, errorClass, validClass) {//不高亮显示
                    $(element).removeClass("is-invalid").addClass(validClass);
                    // $(element.form).find("label[for=" + element.id + "]")
                    //     .removeClass(errorClass);
                },
                validClass: "is-valid"//修改正确后的显示样式
            });
        });
	</script>
</body>
</html>