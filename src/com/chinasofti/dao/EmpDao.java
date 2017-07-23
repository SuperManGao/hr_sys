package com.chinasofti.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.entity.Dept;
import com.chinasofti.entity.Emp;

public class EmpDao extends BaseDao {
	private PreparedStatement pstmt;		//数据库执行对象
	private ResultSet rs;					//结果集==>存放查询结果的
	
	/**
	 * 添加部门信息
	 * @param id
	 * @param dname
	 * @param dloc
	 */
	public void addEmp(Emp emp){
		String sql = "insert into hr_emp (ename,email,etel,edate,esal,did,jid) values(?,?,?,?,?,?,?)";
		try {
			pstmt = getConn().prepareStatement(sql);	//载入SQL语句
			pstmt.setString(1, emp.geteName());
			pstmt.setString(2, emp.getEmail());
			pstmt.setString(3, emp.geteTel());
			pstmt.setString(4, emp.geteDate());
			pstmt.setInt(5, emp.geteSal());	
			pstmt.setInt(6, emp.getDid());	
			pstmt.setInt(7, emp.getJid());	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 查询部门
	 * @return
	 */
	public List<Emp> selectAll(){
		String sql = "select id,ename,email,etel,edate,esal,did,jid from hr_emp ";
		List<Emp> list = new ArrayList<Emp>();
		try {
			pstmt = getConn().prepareStatement(sql);	//载入SQL语句
			rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String ename = rs.getString("ename");
				String email = rs.getString("email");
				String etel = rs.getString("etel");
				String edate = rs.getString("edate");
				int esal = rs.getInt("esal");
				int did = rs.getInt("did");
				int jid = rs.getInt("jid");
				Emp emp = new Emp();
				emp.setId(id);
				emp.seteName(ename);
				emp.setEmail(email);;
				emp.seteDate(edate);
				emp.seteTel(etel);
				emp.seteSal(esal);
				emp.setDid(did);
				emp.setJid(jid);
				list.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 删除员工信息
	 * @param id
	 */
	public void delEmp(int id){
		String sql = "delete from hr_emp where id = ?";
		try {
			pstmt = getConn().prepareStatement(sql);	//载入SQL语句
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String selectJob(int id){
		String job=null;
		JobDao jDao=new JobDao();
		job=jDao.selectById(id).getjName();
		return job;
	}
	
	public String selectDept(int id){
		DeptDao dao=new DeptDao();
		return dao.selectById(id).getdLoc();
		
	}
	/**
	 * 根据ID查询部门信息
	 * @param id
	 * @return
	 */
	public Emp selectById(int id){
		Emp emp = null;
		String sql = "select id,ename,email,etel,edate,esal,did,jid from hr_emp where id = ?";
		try {
			pstmt = getConn().prepareStatement(sql);	//载入SQL语句
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				emp = new Emp();
				int sid = rs.getInt("id");
				String ename = rs.getString("ename");
				String email = rs.getString("email");
				String etel = rs.getString("etel");
				String edate = rs.getString("edate");
				int esal = rs.getInt("esal");
				int did = rs.getInt("did");
				int jid = rs.getInt("jid");
				emp.setId(sid);
				emp.seteName(ename);
				emp.setEmail(email);;
				emp.seteDate(edate);
				emp.seteTel(etel);
				emp.seteSal(esal);
				emp.setDid(did);
				emp.setJid(jid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
	
	/*
	 * 修改部门信息
	 */
	public void updateEmp(Emp emp){
		String sql = "update hr_emp set ename = ?, email = ? ,etel = ?, edate = ?,esal = ?, did = ?,jid = ? where id = ?";
		try {
			pstmt = getConn().prepareStatement(sql);	//载入SQL语句
			pstmt.setInt(8, emp.getId());				//绑定第一个?的值(username)
			pstmt.setString(1, emp.geteName());
			pstmt.setString(2, emp.getEmail());
			pstmt.setString(3, emp.geteTel());
			pstmt.setString(4, emp.geteDate());
			pstmt.setInt(5, emp.geteSal());
			pstmt.setInt(6, emp.getDid());
			pstmt.setInt(7, emp.getJid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Emp> selectFY(int begin,int num){
		String sql = "select * from hr_emp limit ?,?";
		List<Emp> list = new ArrayList<Emp>();
		try {
			pstmt = getConn().prepareStatement(sql);	//����SQL���
			pstmt.setInt(1, begin);
			pstmt.setInt(2, num);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Emp emp = new Emp();
				int sid = rs.getInt("id");
				String ename = rs.getString("ename");
				String email = rs.getString("email");
				String etel = rs.getString("etel");
				String edate = rs.getString("edate");
				int esal = rs.getInt("esal");
				int did = rs.getInt("did");
				int jid = rs.getInt("jid");
				emp.setId(sid);
				emp.seteName(ename);
				emp.setEmail(email);;
				emp.seteDate(edate);
				emp.seteTel(etel);
				emp.seteSal(esal);
				emp.setDid(did);
				emp.setJid(jid);
				list.add(emp);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
