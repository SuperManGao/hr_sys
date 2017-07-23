<%@page import="com.chinasofti.entity.*,com.chinasofti.dao.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
	<head>
		<title>职务数据</title>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<script type="text/javascript">
			//****************-删除确认***************
			function del(job_id) {
				//弹出确认框
				var flag = window.confirm("你确定要删除" + job_id + "号职务吗?");
								
				//如果单击确定，则执行DelJobsServlet，并且传入职务编号
				if (flag) {
					alert("删除成功");
					location.href = "../deljob?id="+job_id;
				}
			}
		</script>
	</head>

	<body>
		<!-- 页面头部 -->
		<jsp:include page="top.jsp"></jsp:include>
		<!-- 页面内容 -->
		<%
		
		%>
		
		<table border="0" width="950" height="350" bgcolor="#ffffff"
			align="center">
			<tr>
				<td align="center" valign="top">
					<table width="90%" border="0" cellpadding="5" cellspacing="1"
						bgcolor="#CCCCCC">
						<tr>
							<th width="16%" height="24" align="center" bgcolor="#FFCC00">
								职务编号
							</th>
							<th width="21%" height="24" align="center" bgcolor="#FFCC00">
								职务名称
							</th>
							<th width="23%" height="24" align="center" bgcolor="#FFCC00">
								最低工资
							</th>
							<th width="24%" height="24" align="center" bgcolor="#FFCC00">
								最高工资
							</th>
							<th width="16%" height="24" align="center" bgcolor="#FFCC00">
								操作
							</th>
						</tr>

						<!-- 显示职务数据 -->
						<%
							JobDao jdao = new JobDao();
						    Admin admin=(Admin)session.getAttribute("user");
						    int pageNum=(Integer)session.getAttribute("pageNum");
							List<Job> list = (List<Job>)session.getAttribute("list");
							String adminlevel = admin.getAdminLevel();
							for(Job job:list){
						 %>
						
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									<%=job.getId() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=job.getjName() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									￥<%=job.getjLow() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									￥<%=job.getjHig() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
								<%
										if("管理员".equals(adminlevel)){
									 %>
									<a href="UpdateJobs.jsp?id=<%=job.getId() %>">修改</a>
									<a href="javascript:del(<%=job.getId()%>)">删除</a>	
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
								<a href="../fy?pagename=JobsView&pageNum=<%=pageNum-1%>">上页</a>
								<font color="red"><b><%=pageNum %></b></font>
								<a href="../fy?pagename=JobsView&pageNum=<%=pageNum+1%>">下页</a>
							</td>
						</tr>
						
					</table>
					<p>
						<a href="AddJobs.jsp">增加新职务种类</a>
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