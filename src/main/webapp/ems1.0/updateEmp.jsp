<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page pageEncoding="UTF-8" contentType="text/html;UTF-8" isELIgnored="false" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>update Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/ems1.0/css/style.css" />
		<script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
		<script type="application/javascript">
			$(function () {
				//获取所有部门信息
				$.ajax({
					url:"${pageContext.request.contextPath}/dept/showAllName.do",
					type:"GET",
					dataType:"JSON",
					success:function (depts){
						//遍历部门信息
						for(var i=0;i<depts.length;i++){
							//判断如果部门中的id和员工信息中的部门一致就进行显示在下拉框第一个
							if(depts[i].id == ${requestScope.employee.dept_id}){
								var option=("<option selected value="+depts[i].id+">"+depts[i].deptName+"</option>");
							}

							//如果部门中的id与员工信息中的部门不一致就在下拉框中进行选择
							if(depts[i].id != ${requestScope.employee.dept_id}){
								var option=("<option value="+depts[i].id+">"+depts[i].deptName+"</option>");
							}

							$("#deptName").append(option);
						}
					}
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
								<a href="#">Main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						update Emp info:
					</h1>
					<form action="${pageContext.request.contextPath}/emp/update.do" method="post" enctype="multipart/form-data">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">				
							<tr>
								<td valign="middle" align="right">
									id:
								</td>
								<td valign="middle" align="left">
									<input type="hidden" name="id" value="${employee.id}">
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									头像:
								</td>
								<td valign="middle" align="left">
								<img width="40px" height="40px" src="${pageContext.request.contextPath}/upload/${employee.portrait}" />
									<input type="file" class="inputgri" name="upload" value="${employee.portrait}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" value="${employee.name}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="sex" value="${employee.sex}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" value="${employee.age}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									工资:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" value="${employee.salary}"/>
								</td>
							</tr>

							<tr>
								<td valign="middle" align="right">
									部门:
								</td>
								<td valign="middle" align="left">
									<select id="deptName" name="dept_id">
									</select>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="修改" />
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
