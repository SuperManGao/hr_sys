<%@ page language="java" import="java.util.*,com.chinasofti.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
Admin admin=(Admin)session.getAttribute("user");
if(admin==null){
	response.sendRedirect("/hr_sys/login.jsp");
}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'top.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<table width="950" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="80" bgcolor="#FFFFFF">
					<img src="../img/bannal.jpg" width="950" height="80">
				</td>
			</tr>
			<tr>
				<td height="24" align="right" bgcolor="#FFFFFF">
					<a href="default.jsp">首页</a>
					<a href="../fy?pageNum=1&pagename=DeptView">部门查询</a>
					<a href="../fy?pageNum=1&pagename=JobsView">职务查询</a>
					<a href="../fy?pageNum=1&pagename=EmpView">员工查询</a>
					<a href="logout.jsp">退出登陆</a>
				</td>
			</tr>
			<tr>
				<td height="24" align="right" bgcolor="#0099CC">
					当前用户：<%=admin.getUserName() %> 身份： <%=admin.getAdminLevel() %>
				</td>
			</tr>
		</table>
	</body>
</html>
