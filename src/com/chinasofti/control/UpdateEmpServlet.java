package com.chinasofti.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.dao.DeptDao;
import com.chinasofti.dao.EmpDao;
import com.chinasofti.entity.Dept;
import com.chinasofti.entity.Emp;

/**
 * Servlet implementation class UpdateEmpServlet
 */
@WebServlet("/updateemp")
public class UpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getParameter("id"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		String ename = request.getParameter("empname");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		String hire_date = request.getParameter("hire_date");
		String job=request.getParameter("job_id");
		String sal=request.getParameter("salary");
		String dep=request.getParameter("department_id");
		
		int jid=Integer.parseInt(job);
		int did=Integer.parseInt(dep);
		int salary=Integer.parseInt(sal);
		
		Emp emp=new Emp();
		emp.seteName(ename);
		emp.seteDate(hire_date);
		emp.setEmail(email);
		emp.seteTel(phone_number);
		emp.setDid(did);
		emp.setJid(jid);
		emp.seteSal(salary);
		emp.setId(id);
		
		EmpDao dao = new EmpDao();
		dao.updateEmp(emp);
		response.sendRedirect("/hr_sys/admin/EmpView.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
