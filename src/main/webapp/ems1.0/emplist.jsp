<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html;UTF-8" isELIgnored="false" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ems1.0/css/style.css" />
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
						Welcome!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
							    头像
							</td>
							<td>
								姓名
							</td>
							<td>
								性别
							</td>
							<td>
								年龄
							</td>
							<td>
								工资
							</td>
							<td>
								部门名称
							</td>
							<td>
								操作
							</td>
						</tr>
					<c:forEach var="emp" items="${requestScope.list}" varStatus="stu">
						<tr class="row1">						   
							<td>
								${stu.index+1}
							</td>
							 <td>
							  <img width="40px" height="40px" src="${pageContext.request.contextPath}/upload/${emp.portrait}"/>
							</td>
							
							<td>
								${emp.name}
							</td>
							<td>
								${emp.sex}
							</td>
							<td>
								${emp.age}
							</td>
							<td>
								${emp.salary}
							</td>
							<td>
								${emp.dept.deptName}
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/emp/delete.do?id=${emp.id}&dept_id=${emp.dept_id}">delete emp</a>&nbsp;<a href="${pageContext.request.contextPath}/emp/toUpdate.do?id=${emp.id}">update emp</a>
							</td>
						</tr>
					</c:forEach>
					</table>
					
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
