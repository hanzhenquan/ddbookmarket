<%@page import="com.ddbookmarket.model.Bookaddtype"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script type="text/javascript" src="bower_components/jquery/dist/jquery.js">
</script>
<link rel="stylesheet" type="text/css" id="link" />
    <link rel="stylesheet" type="text/css" href="bower_components/fontawesome/web-fonts-with-css/css/fontawesome-all.css" />
    <script type="text/javascript" src="bower_compo ents/jquery/dist/jquery.slim.js"></script>
<script type="text/javascript" src="bower_components/jquery-cookie/jquery.cookie.js"></script>
<script type="text/javascript">
//把这些提上来，防止二次绘制
   //不要写在$(function(){})中，会导致二次绘制
				if($.cookie("bower_components")){
					//如果存在就走这一步
					 $("#link").attr("href","bower_components/bootswatch/dist/"+$.cookie("bower_components")+"/bootstrap.css");
						}else{
						$("#link").attr("href","bower_components/bootswatch/dist/sketchy/bootstrap.css");
						}
</script>

</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="navbar-toggler-icon"></span>
					</button>
					<a class="navbar-brand" href="#">
					<img src="img/logo2（s）.png">
					</a>
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="navbar-nav">
							<li class="nav-item active"><a class="nav-link" href="javascript:void(0)" >
				<!--  			href="javascript:void(0)"用于去井号：-->
							 <select id="select">
										<option>sketchy</option>
										<option>cosmo</option>
										<option>darkly</option>
										<option>yeti</option>
								</select>
							</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
							<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">Dropdown
									link</a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
									<a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another action</a> <a class="dropdown-item" href="#">Something else
										here</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" href="#">Separated link</a>
								</div></li>
						</ul>
						<form class="form-inline">
							<input class="form-control mr-sm-2" type="text" />
							<button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
						</form>
						<ul class="navbar-nav ml-md-auto">
								<a class="fa fa-window-close fa-2x" href="exit.jsp" id="navbarDropdownMenuLink" >
							</a>
						</ul>
					</div>
				</nav>
			</div>
		</div>
		
		<div class="header">
		<form class="form-inline" action="bookList" method="post"  id="searchFrm">
       <div class="col-auto">
      <label class="sr-only" for="inputbid">Username</label>
      <div class="input-group mb-2">
         <select class="form-control" id="inputbid" name="bid">
         <option value="-1"> ---请选择大类名---</option>
         </select>
        
      </div>
    </div>
   <div class="col-auto">
      <label class="sr-only" for="inputsid">Username</label>
      <div class="input-group mb-2">
         <select class="form-control" id="inputsid" name="sid" >
         <option value="-1"> ---请选择小类名---</option>
         </select>
        
      </div>
    </div>
     <div class="col-auto">
      <label class="sr-only" for="inlineFormInput">书名</label>
      <input type="text" class="form-control mb-2" id="Inputname" name="name" placeholder="书名" value="<%=request.getParameter("name")==null?"":request.getParameter("name")%>" >
    </div>	
    <div class="col-auto">
      <button type="submit" class="btn btn-primary mb-2">搜索</button>
    </div>
</form>
		</div>
		<div class="col-md-12" style="padding:0px">
			<table class="table table-hover " style="margin-bottom: 0px ">
				<thead>
					<tr>
						<th>id</th>
						<th>小类</th>
						<th>书名</th>
						<th>字数</th>
						<th>价格</th>
						<th>作者</th>
						<th>出版社</th>
						<th>出版日期</th>
						<th>简介</th>
						<th>图片</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<% 
				List <Bookaddtype> ls=(List <Bookaddtype>)request.getAttribute("ls");
				for(Bookaddtype book:ls){
				%>
					<tr>
						<td>
							<%=book.getId()%>
						</td>
						<td>
							<%=book.getSid()%>
						</td>
						<td>
							<%=book.getName()%>
						</td>
						<td>
							<%=book.getZishu()%>
						</td>
						<td>
							<%=book.getMoney()%>
						</td>
						<td>
							<%=book.getAuthor()%>
						</td>
						<td>
							<%=book.getAuthorhome()%>
						</td>
						<td>
							<%=book.getPublishdate()%>
						</td>
						<td style="width: 200px">
							<%=book.getJianjie()%>
						</td>
						<td>
							<img src="upload/<%=book.getPhoto()%>">
						</td>
						<td><a href="#modal-container-984785" data-toggle="modal" class="fa fa-trash fa-1x" onclick="window.delid='<%=book.getId()%>'" ></a></td>
						<td><a class="fa fa-edit fa-1x" title="修改" href="toBookAlte?id=<%=book.getId()%>"></a> </td>
					</tr>
				<% }%>
				</tbody>
			</table>
				<nav>
				<ul class="pagination">
				<% 
				 int zongpage=(Integer)request.getAttribute("zongpage");
				 int dangqianpage=(Integer)request.getAttribute("dangqianpage");
				 if(dangqianpage==1){
					 %>
					 <li class="page-item disabled"><a class="page-link" href="#">上一页</a></li>
					 <%
				 }else{
					 %>
					 <li class="page-item"><a class="page-link" href="bookList?dangqianpage=<%=dangqianpage-1%>">上一页</a></li>
					 <%
				 }
				%>
				
				<%
				 
				  
				  if(zongpage<=5){
					  for(int i=1;i<=zongpage;i++){
				%>
					<li class="page-item"><a class="page-link" href="bookList?dangqianpage=<%=i%>"><%=i%></a></li>
				<% 
				  }
				  }else if(dangqianpage<=3){
				%>
						<li class="page-item"><a class="page-link" href="bookList?dangqianpage=1">1</a></li>
						<li class="page-item"><a class="page-link" href="bookList?dangqianpage=2">2</a></li>
						<li class="page-item"><a class="page-link" href="bookList?dangqianpage=3">3</a></li>
						<li class="page-item"><a class="page-link" href="bookList?dangqianpage=4">4</a></li>
						<li class="page-item"><a class="page-link" href="bookList?dangqianpage=<%=zongpage%>">...<%=zongpage%></a></li>  
				<%
				  }else if(dangqianpage<=zongpage-3){
				%>  
				        <li class="page-item"><a class="page-link" href="bookList?dangqianpage=1">1...</a></li>
						<li class="page-item"><a class="page-link" href="bookList?dangqianpage=<%=dangqianpage-1%>"><%=dangqianpage-1%></a></li>
						<li class="page-item"><a class="page-link" href="bookList?dangqianpage=<%=dangqianpage%>"><%=dangqianpage%></a></li>
						<li class="page-item"><a class="page-link" href="bookList?dangqianpage=<%=dangqianpage+1%>"><%=dangqianpage+1%></a></li>
						<li class="page-item"><a class="page-link" href="bookList?dangqianpage=<%=zongpage%>">...<%=zongpage%></a></li>  
				
				
				
				<%
				  }else{
			    %>
			            <li class="page-item"><a class="page-link" href="bookList?dangqianpage=1">1...</a></li>
						<li class="page-item"><a class="page-link" href="bookList?dangqianpage=<%=zongpage-3%>"><%=zongpage-3%></a></li>
						<li class="page-item"><a class="page-link" href="bookList?dangqianpage=<%=zongpage-2%>"><%=zongpage-2%></a></li>
						<li class="page-item"><a class="page-link" href="bookList?dangqianpage=<%=zongpage-1%>"><%=zongpage-1%></a></li>
						<li class="page-item"><a class="page-link" href="bookList?dangqianpage=<%=zongpage%>"><%=zongpage%></a></li>  
			    <%
				  }
				  
				%>
				
				<% 
				 if(dangqianpage==zongpage){
					 %>
					 <li class="page-item disabled"><a class="page-link" href="#">下一页</a></li>
					 <%
				 }else{
					 %>
					 <li class="page-item"><a class="page-link" href="bookList?dangqianpage=<%=dangqianpage+1%>">下一页</a></li>
					 <%
				 }
				%>
				</ul>
			</nav>
		
		</div>
	
		
		<div class="row">
			<div class="col-md-12">
				<div class="alert alert-success alert-dismissable">

					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
					<h4>Alert!</h4>
					<strong>Warning!</strong> Best check yo self, you're not looking too good. <a href="#" class="alert-link">alert link</a>
				</div>
			</div>
		</div>
	</div>
	
	
	
			<div class="modal fade" id="modal-container-984785" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="myModalLabel">
								删除书本
							</h5> 
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body">
							你确定删除吗
						</div>
						<div class="modal-footer">
							 
							<button type="button" class="btn btn-primary"  onclick="exeDel(event)">
								确定
							</button> 
							<button type="button" class="btn btn-secondary" data-dismiss="modal">
								取消
							</button>
						</div>
					</div>
					
				</div>
				
			</div>
	
	
	

	<script type="text/javascript" src="bower_components/bootstrap/dist/js/bootstrap.js"></script>

	<script type="text/javascript">
      $(function(){
    	  
    	  console.log($("#Inputname").val());
  		if( $("#Inputname").val()=="null"){
  			$("#Inputname").val("书名");
  		}
    	  
            	$("#select").change(function(evt){
                    $("#link").attr("href","bower_components/bootswatch/dist/"+$(evt.target).val()+"/bootstrap.css");
                    $.cookie("bower_components",$(evt.target).val(), { expires: 7 });
    				});
            	$("#select").val($.cookie("bower_components"));
            	$('a[href="bookList?dangqianpage=<%=dangqianpage%>"]').parent("li").addClass("active");
            	
      });
      
      
      /**大类**/
  	function findsel(types){
  		document.getElementById("inputbid").innerHTML='<option value="-1"> -请选择大类名-</option>';
  		//获得所有  循环
  		for (var i = 0; i < types.length; i++) {
  			var ls=new Option(types[i].name,types[i].id);//添加选项
  			document.getElementById("inputbid").appendChild(ls);//找到位置添加
  		}
  		$("#inputbid").val('<%=request.getAttribute("bid")%>');
  		$("#inputbid").trigger("change");
  	}
  	function smallfindsel(types){
  		//获得所有  循环
  		document.getElementById("inputsid").innerHTML='<option value="-1"> -请选择小类名-</option>';
  		for (var i = 0; i < types.length; i++) {
  			var ls=new Option(types[i].name,types[i].id);//添加选项
  			document.getElementById("inputsid").appendChild(ls);//找到位置添加
  		}
  		$("#inputsid").val('<%=request.getAttribute("sid")%>');
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
       
       
       /**分页缺少表单值**/
       $('a[class="page-link"][href^="bookList?dangqianpage="]').click(function(){
    	   $(this).attr("href",$(this).attr("href")+"&"+$("#searchFrm").serialize());
    	   
       })
      
      
</script>
</body>
</html>