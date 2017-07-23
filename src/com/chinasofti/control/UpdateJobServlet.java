package com.chinasofti.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.dao.DeptDao;
import com.chinasofti.dao.JobDao;
import com.chinasofti.entity.Dept;
import com.chinasofti.entity.Job;

/**
 * Servlet implementation class UpdateJobServlet
 */
@WebServlet("/updatejob")
public class UpdateJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("job_id"));
		String jname = request.getParameter("job_title");
		String jlow = request.getParameter("min_salary");
		String jhig = request.getParameter("max_salary");
		int low=Integer.parseInt(jlow);
		int hig=Integer.parseInt(jhig);
		Job job=new Job(id, jname, low,hig);
		JobDao ddao = new JobDao();
		ddao.updateJob(job);
		response.sendRedirect("/hr_sys/admin/JobsView.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
