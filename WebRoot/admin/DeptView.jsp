<%@page import="com.chinasofti.dao.*,com.chinasofti.entity.*"%>
<%@ page language="java" import="java.util.*,com.chinasofti.entity.Dept" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
	<head>
		<title>部门数据</title>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<script type="text/javascript">
			//****************-删除确认***************
			function del(department_id) {
				//弹出确认框
				var flag = window.confirm("你确定要删除" + department_id + "号部门吗?");
								
				//如果单击确定，则执行DelDeptServlet，并且传入部门编号
				if (flag) {
					alert("删除成功");
					location.href = "../deldept?id="+department_id;
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
					<table width="90%" border="0" cellpadding="5" cellspacing="1"
						bgcolor="#CCCCCC">
						
						<tr>
							<th width="17%" bgcolor="#FFCC00">
								部门编号
							</th>
							<th width="25%" bgcolor="#FFCC00">
								部门名称
							</th>
							<th width="37%" bgcolor="#FFCC00">
								部门地址
							</th>
							<th width="21%" bgcolor="#FFCC00">
								操作
							</th>
						</tr>

						<!-- 循环输出部门记录 -->
						<%
							DeptDao ddao = new DeptDao();
						    Admin admin=(Admin)session.getAttribute("user");
							//List<Dept> list = ddao.selectAll();
							int pageNum=(Integer)session.getAttribute("pageNum");
							List<Dept> list = (List<Dept>)session.getAttribute("list");
							String adminlevel = admin.getAdminLevel();
							for(Dept dept:list){
						 %>
							<tr>
								<td bgcolor="#FFFFFF">
									<%=dept.getId() %>
								</td>
								<td bgcolor="#FFFFFF">
									<%=dept.getdName() %>
								</td>
								<td bgcolor="#FFFFFF">
									<%=dept.getdLoc() %>
								</td>
								<td bgcolor="#FFFFFF">
									<%
										if("管理员".equals(adminlevel)){
									 %>
										 <a href="UpdateDept.jsp?id=<%=dept.getId() %>">修改</a>
										<a href="javascript:del(<%=dept.getId() %>)">删除</a>		
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
								<a href="../fy?pagename=DeptView&pageNum=<%=pageNum-1%>">上页</a>
								
								<font color="red"><b><%=pageNum %></b></font>
							
								<a href="../fy?pagename=DeptView&pageNum=<%=pageNum+1%>">下页</a>
							</td>
						</tr>
					</table>
					
					<p>
						<a href="AddDept.jsp">增加新部门</a>		
					</p>
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