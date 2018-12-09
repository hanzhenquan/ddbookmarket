<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 告诉浏览器不要缩放 -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="../../../../workspacess/ddbookmarket/src/main/webapp/bower_components/bootswatch/dist/sketchy/bootstrap.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container-fluid" style="width: 70%">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body">
						<form method="post" autocomplete="off" action="smallTypeAddServlet">
							<div class="form-group row">
								<label for="inputName" class="col-sm-2 col-form-label text-right">大类名：</label>
								<div class="col-sm-10">
									<select name="bid" class="form-control" id="inputbid">

									</select>
								</div>
							</div>

							<div class="form-group row">
								<label for="inputName" class="col-sm-2 col-form-label text-right">小类名：</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputName" placeholder="小类名" name="name">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-2"></div>
								<div class="col-sm-10">
									<button type="submit" class="btn btn-primary">提交</button>
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
	<script type="text/javascript">
		/* var xhr = new XMLHttpRequest();
		xhr.open("GET", "findAllBigtype");
		xhr.send();
		xhr.onreadystatechange=function() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					eval(xhr.responseText);
				}
			}
		}; */
		function fillSel(typs) {
			for (var i = 0; i < typs.length; i++) {
				var op = new Option(typs[i].name, typs[i].id);
				document.getElementById("inputbid").appendChild(op);
			}
		};
		/* var script=document.createElement("script");
		script.src="findAllBigtype";
		document.appendChild(script); */
		console.dir($);
		$.ajax({
			url : "findAllBigtype",
			dataType : "jsonp",
			jsonpCallback : "fillSel"
		});


		
	</script>
	<!-- <script type="text/javascript" src="findAllBigtype"></script> -->
</body>
</html>