package com.chinasofti.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.dao.DeptDao;
import com.chinasofti.entity.Dept;

/**
 * Servlet implementation class AddDeptServlet
 */
@WebServlet("/adddept")
public class AddDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDeptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8"); //接收汉字编码方式的
		int id = Integer.parseInt(request.getParameter("id"));//转换String 为int类型
		String dname = request.getParameter("department_name");
		String dloc = request.getParameter("location_name");
		Dept dept=new Dept(id,dname,dloc);
		DeptDao ddao = new DeptDao();
		ddao.addDept(dept);
		response.sendRedirect("/hr_sys/admin/DeptView.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
