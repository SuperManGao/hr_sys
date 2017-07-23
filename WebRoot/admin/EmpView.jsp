<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.chinasofti.dao.*,com.chinasofti.entity.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
	<head>
		<title>员工数据</title>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<script type="text/javascript">
			//****************-删除确认***************
			function del(employee_id) {
				//弹出确认框
				var flag = window.confirm("你确定要删除" + employee_id + "号员工吗?");
				//如果单击确定，则执行DelEmpServlet，并且传入员工编号
				if (flag) {
					alert("删除成功");
					location.href = "../delemp?id="+employee_id;
				}
			}
		</script>
	</head>

	<body>
		<!-- 页面头部 -->
		<jsp:include page="top.jsp"></jsp:include>
		<!-- 页面内容 -->
		<table border="0" width="950" height="350" bgcolor="#ffffff"
			align="center">
			<tr>
				<td align="center" valign="top">
					<table width="98%" border="0" cellpadding="5" cellspacing="1"
						bgcolor="#CCCCCC">
						<tr>
							<td width="7%" height="24" bgcolor="#FFCC00">
								员工编号
							</td>
							<td width="11%" height="24" bgcolor="#FFCC00">
								员工姓名
							</td>
							<td width="16%" height="24" bgcolor="#FFCC00">
								邮箱
							</td>
							<td width="16%" height="24" bgcolor="#FFCC00">
								电话
							</td>
							<td width="12%" height="24" bgcolor="#FFCC00">
								入职时间
							</td>
							<td width="9%" height="24" bgcolor="#FFCC00">
								职务
							</td>
							<td width="9%" height="24" bgcolor="#FFCC00">
								工资
							</td>
							<td width="7%" height="24" bgcolor="#FFCC00">
								部门
							</td>
							<td width="13%" height="24" bgcolor="#FFCC00">
								操作
							</td>
						</tr>
						<%
							EmpDao ddao = new EmpDao();
						    Admin admin=(Admin)session.getAttribute("user");
						    int pageNum=(Integer)session.getAttribute("pageNum");
							List<Emp> list = (List<Emp>)session.getAttribute("list");
							String adminlevel = admin.getAdminLevel();
							for(Emp emp:list){
						 %>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									<%=emp.getId() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=emp.geteName() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=emp.getEmail() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=emp.geteTel() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=emp.geteDate() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=ddao.selectJob(emp.getJid()) %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=emp.geteSal() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=ddao.selectDept(emp.getDid()) %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
								<%
										if("管理员".equals(adminlevel)){
									 %>
									<a href="UpdateEmp.jsp?id=<%=emp.getId() %>">修改</a>
									<a href="javascript:del(<%=emp.getId() %>)">删除</a>	
									<%}else{ %>
									 	权限不足
									 <%} %>
									</td>
							</tr>
						<%} %>
						
					</table>
<!-- 分页显示用界面 -->
					<table width="95%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						
						<tr>
							<td height="24" align="center">
								<a href="../fy?pagename=EmpView&pageNum=<%=pageNum-1%>">上页</a>
								<font color="red"><b><%=pageNum %></b></font>
								<a href="../fy?pagename=EmpView&pageNum=<%=pageNum+1%>">下页</a>
							</td>
						</tr>
						
					</table>
					<p>
						<a href="AddEmp.jsp">增加新员工</a>					</p>
				</td>
			</tr>
		</table>

		<!-- 页面底部 -->
		
<table width="950" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td><hr></td>
  </tr>
  <tr>
    <td align="center">©版权所有</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
	</body>
</html>