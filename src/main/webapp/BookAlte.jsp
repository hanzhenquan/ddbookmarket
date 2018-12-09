<%@page import="java.io.Console"%>
<%@page import="com.ddbookmarket.model.Bookaddtype"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改图书</title>
<!-- 告诉浏览器不要缩放 -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="../../../../workspacess/ddbookmarket/src/main/webapp/bower_components/bootswatch/dist/sketchy/bootstrap.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.custom-file-label::after {
	content: "浏览"
}
</style>
</head>
<body>
	<div class="container-fluid" style="width: 70%">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body">
						<form method="post" autocomplete="off" action="doBookAlte" enctype="multipart/form-data">
						
						<% 
						     Bookaddtype book=(Bookaddtype)request.getAttribute("book");
						%>
						<input type="hidden"  name="id"  value="<%=book.getId()%>">
						
							<div class="form-group row">
								<label for="inputbid" class="col-sm-2 col-form-label text-right">大类名：</label>
								<div class="col-sm-10">
									<select name="bid" class="form-control" id="inputbid">
                                         <option value="-1">请选择</option>
									</select>
								</div>
							</div>
							<div class="form-group row">
								<label for="inputsid" class="col-sm-2 col-form-label text-right">小类名：</label>
								<div class="col-sm-10">
									<select name="sid" class="form-control" id="inputsid">

									</select>
								</div>
							</div>

							<div class="form-group row">
								<label for="inputName" class="col-sm-2 col-form-label text-right">书名：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputName" placeholder="书名" name="name" value="<%=book.getName() %>">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputName" class="col-sm-2 col-form-label text-right">字数：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputName" placeholder="书名" name="zishu" value="<%=book.getZishu() %>">
								</div>
							</div>
							
							<div class="form-group row">
								<label for="inputprice" class="col-sm-2 col-form-label text-right">价格：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputprice" placeholder="价格" name="money"  value="<%=book.getMoney() %>">
								</div>	
							</div>
							<div class="form-group row">
								<label for="inputauthor" class="col-sm-2 col-form-label text-right">作者：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputauthor" placeholder="作者" name="author"  value="<%=book.getAuthor() %>">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputcbs" class="col-sm-2 col-form-label text-right">出版社：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputcbs" placeholder="出版社" name="authorhome"  value="<%=book.getAuthorhome() %>">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputcbDate" class="col-sm-2 col-form-label text-right">日期：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputcbDate" placeholder="日期" name="publishdate"  value="<%=book.getPublishdate() %>"/>
								</div>
							</div>
							<div class="form-group row">
								<label for="inputdescn" class="col-sm-2 col-form-label text-right">简介：</label>
								<div class="col-sm-10">
									<textarea class="form-control" id="inputdescn" placeholder="简介" name="jianjie">
									 <%=book.getJianjie() %>
									</textarea>
								</div>
							</div>
							<div class="form-group row">
								<label for="inputPhoto" class="col-sm-2 col-form-label text-right">头像：</label>
								<div class="col-sm-10">
									<div class="custom-file">
										<input type="file" class="custom-file-input" id="inputPhoto" aria-describedby="inputGroupFileAddon04" name="photo"> <label
											class="custom-file-label" for="inputPhoto">选择文件</label>
									</div>
									<img src="upload/<%=book.getPhoto() %>">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-2"></div>
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary">添加</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../../../../workspacess/ddbookmarket/src/main/webapp/bower_components/jquery/dist/jquery.js"></script>
	<script type="text/javascript" src="../../../../workspacess/ddbookmarket/src/main/webapp/bower_components/bootstrap/dist/js/bootstrap.js"></script>
	<script type="text/javascript" src="../../../../workspacess/ddbookmarket/src/main/webapp/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="../../../../workspacess/ddbookmarket/src/main/webapp/bower_components/bootstrap-datepicker/dist/locales/bootstrap-datepicker.zh-CN.min.js"></script>
	<script type="text/javascript">
	      
	      /**大类**/
	  	function findsel(types){
	  		//获得所有  循环
	  		for (var i = 0; i < types.length; i++) {
	  			var ls=new Option(types[i].name,types[i].id);//添加选项
	  			document.getElementById("inputbid").appendChild(ls);//找到位置添加
	  		}
	  		$("#inputbid").val('<%=request.getAttribute("bid")%>');
	  		console.log('<%=request.getAttribute("bid")%>');
	  		$("#inputbid").trigger("change");
	  	}
	  	function smallfindsel(types){
	  		//获得所有  循环
	  		for (var i = 0; i < types.length; i++) {
	  			var ls=new Option(types[i].name,types[i].id);//添加选项
	  			document.getElementById("inputsid").appendChild(ls);//找到位置添加
	  		}
	  		$("#inputsid").val('<%=book.getSid()%>');
	  	}
	  	$.ajax({
	  		url:"findAllBigType",
	  	    dataType: "jsonp",
	  	    jsonpCallback:"findsel"
	  	});
	  	/**小类**/
	       $("#inputbid").change(function(){
	      	 $.ajax({
	      			url:"findAllSmallType",
	      		    dataType: "jsonp",
	      		    data:"bid="+$(this).val(),
	      		    jsonpCallback:"smallfindsel"
	      		});
	           });
	  	
	  	
	       function exeDel(event) {
				window.location.href="bookDel?id="+window.delid;
			}
	      
	       $('#inputcbDate').datepicker({
	           format: 'yyyy-mm-dd',
	           language: 'zh-CN',
	           autoclose: true,
	           defaultViewDate: {
	               year: new Date().getFullYear() - 18
	           }
	       });
	       
	       
	      
		
	</script>
	<!-- <script type="text/javascript" src="findAllBigtype"></script> -->
</body>
</html>