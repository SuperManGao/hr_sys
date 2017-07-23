package com.chinasofti.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.entity.Dept;
import com.chinasofti.entity.Job;

public class JobDao extends BaseDao {
	private PreparedStatement pstmt;		//数据库执行对象
	private ResultSet rs;					//结果集==>存放查询结果的
	
	/**
	 * 添加工作信息
	 * @param id
	 * @param jname

	 */
	public void addJob(Job job){
		String sql = "insert into hr_job (id,jname,jlow,jhig) values(?,?,?,?)";
		try {
			pstmt = getConn().prepareStatement(sql);	//载入SQL语句
			pstmt.setInt(1, job.getId());				//绑定第一个?的值(username)
			pstmt.setString(2, job.getjName());
			pstmt.setInt(3, job.getjLow());
			pstmt.setInt(4, job.getjHig());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 查询工作
	 * @return
	 */
	public List<Job> selectAll(){
		String sql = "select id,jname,jlow,jhig from hr_job ";
		List<Job> list = new ArrayList<Job>();
		try {
			pstmt = getConn().prepareStatement(sql);	//载入SQL语句
			rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String jname = rs.getString("jname");
				int jlow = rs.getInt("jlow");
				int jhig = rs.getInt("jhig");
				Job job = new Job();
				job.setId(id);
				job.setjName(jname);
				job.setjLow(jlow);
				job.setjHig(jhig);
				list.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 删除工作信息
	 * @param id
	 */
	public void delJob(int id){
		String sql = "delete from hr_job where id = ?";
		try {
			pstmt = getConn().prepareStatement(sql);	//载入SQL语句
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据ID查询工作信息
	 * @param id
	 * @return
	 */
	public Job selectById(int id){
		Job job = null;
		String sql = "select id,jname,jlow,jhig from hr_job where id = ?";
		try {
			pstmt = getConn().prepareStatement(sql);	//载入SQL语句
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				job = new Job();
				int did = rs.getInt("id");
				String jname = rs.getString("jname");
				int jlow = rs.getInt("jlow");
				int jhig = rs.getInt("jhig");
				job.setId(did);
				job.setjName(jname);
				job.setjLow(jlow);
				job.setjHig(jhig);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return job;
	}
	
	/*
	 * 修改部门信息
	 */
	public void updateJob(Job job){
		String sql = "update hr_job set jname = ?, jlow = ?,jhig=? where id = ?";
		try {
			pstmt = getConn().prepareStatement(sql);	//载入SQL语句
			pstmt.setInt(4, job.getId());				//绑定第一个?的值(username)
			pstmt.setString(1, job.getjName());
			pstmt.setInt(2, job.getjLow());
			pstmt.setInt(3, job.getjHig());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Job> selectFY(int begin,int num){
		String sql = "select * from hr_job limit ?,?";
		List<Job> list = new ArrayList<Job>();
		try {
			pstmt = getConn().prepareStatement(sql);	//����SQL���
			pstmt.setInt(1, begin);
			pstmt.setInt(2, num);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Job job = new Job();
				int did = rs.getInt("id");
				String jname = rs.getString("jname");
				int jlow = rs.getInt("jlow");
				int jhig = rs.getInt("jhig");
				job.setId(did);
				job.setjName(jname);
				job.setjLow(jlow);
				job.setjHig(jhig);
				list.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
