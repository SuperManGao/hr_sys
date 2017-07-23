package com.chinasofti.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.chinasofti.dao.DeptDao;
import com.chinasofti.dao.EmpDao;
import com.chinasofti.dao.JobDao;
import com.chinasofti.entity.Dept;
import com.chinasofti.entity.Emp;
import com.chinasofti.entity.Job;

/**
 * Servlet implementation class FYServlet
 */
@WebServlet("/fy")
public class FYServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FYServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String pagename=request.getParameter("pagename");
		System.out.println(pagename);
		int num = 4; 		
		int pageNum = Integer.parseInt(request.getParameter("pageNum")) ; 
		int begin = (pageNum-1)*num + 1;	
		switch (pagename) {
		case "DeptView":
			DeptDao ddao = new DeptDao();
			List<Dept> list = ddao.selectFY(begin-1, num);
			session.setAttribute("list", list);
			break;

		case "JobsView":
			JobDao jobdao = new JobDao();
			List<Job> joblist = jobdao.selectFY(begin-1, num);
			session.setAttribute("list", joblist);
			break;
		case "EmpView":
			EmpDao empdao = new EmpDao();
			List<Emp> emplist = empdao.selectFY(begin-1, num);
			session.setAttribute("list", emplist);
			break;
		}
		session.setAttribute("pageNum", pageNum);
		response.sendRedirect("/hr_sys/admin/"+pagename+".jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
