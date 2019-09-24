<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html;UTF-8" isELIgnored="false" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<title>regist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ems1.0/css/style.css" />
		<script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
		<script type="application/javascript">
			$(function () {
				//给input标签添加对应的onblur事件
				$("#input").blur(function () {
					//获取输入的用户名
					var username=$("#input").val();
					//发送ajax请求，去后台效验
					$.ajax({
						url:"${pageContext.request.contextPath}/user/queryName.do",
						type:"GET", //以GET形式发送异步请求
						data:"username="+username, //接收数据
						dataType:"text",  //指定后台传输的数据格式
						success:function (flag) { //监听响应， 后台的数据自动封装到message
							//清空jQuery标签中的内容
							$("#span").empty();
							if("N"==flag){
								$("#span").append("<font color='red'>你输入的用户名已使用，请重新输入！</font>");
								$("#img").prop("img","${pageContext.request.contextPath}/images/error.jpg");
							}
							if("Y"==flag){
								$("#span").append("<font color='#228b22'>你输入的用户名可用</font>");
								$("#img").prop("img","${pageContext.request.contextPath}/images/ok.gif");
							}
						}
					});
				})
			});
		</script>

	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"/>
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						注册
					</h1>
					<form action="${pageContext.request.contextPath}/user/regist.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" id="input" class="inputgri" name="username"/>
									<span id="span"></span><img id="img" src="" width="20px" height="20px"/>
								</td>
							</tr>

							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" name="sex" value="男" checked="checked"/>
									女
									<input type="radio" class="inputgri" name="sex" value="女"/>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Submit &raquo;" />
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
