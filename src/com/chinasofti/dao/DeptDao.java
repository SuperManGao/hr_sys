package com.chinasofti.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.entity.Dept;

public class DeptDao extends BaseDao {
	private PreparedStatement pstmt;		//数据库执行对象
	private ResultSet rs;					//结果集==>存放查询结果的
	
	/**
	 * 添加部门信息
	 * @param id
	 * @param dname
	 * @param dloc
	 */
	public void addDept(Dept dept){
		String sql = "insert into hr_dept (id,dname,dloc) values(?,?,?)";
		try {
			pstmt = getConn().prepareStatement(sql);	//载入SQL语句
			pstmt.setInt(1, dept.getId());				//绑定第一个?的值(username)
			pstmt.setString(2, dept.getdName());
			pstmt.setString(3, dept.getdLoc());
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
	public List<Dept> selectAll(){
		String sql = "select id,dname,dloc from hr_dept ";
		List<Dept> list = new ArrayList<Dept>();
		try {
			pstmt = getConn().prepareStatement(sql);	//载入SQL语句
			rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String dname = rs.getString("dname");
				String dloc = rs.getString("dloc");
				Dept dept = new Dept();
				dept.setId(id);
				dept.setdName(dname);
				dept.setdLoc(dloc);
				list.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 删除部门信息
	 * @param id
	 */
	public void delDept(int id){
		String sql = "delete from hr_dept where id = ?";
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
	 * 根据ID查询部门信息
	 * @param id
	 * @return
	 */
	public Dept selectById(int id){
		Dept dept = null;
		String sql = "select id,dname,dloc from hr_dept where id = ?";
		try {
			pstmt = getConn().prepareStatement(sql);	//载入SQL语句
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				dept = new Dept();
				int did = rs.getInt("id");
				String dname = rs.getString("dname");
				String dloc = rs.getString("dloc");
				dept.setId(did);
				dept.setdName(dname);
				dept.setdLoc(dloc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dept;
	}
	
	/*
	 * 修改部门信息
	 */
	public void updateDept(Dept dept){
		String sql = "update hr_dept set dname = ?, dloc = ? where id = ?";
		try {
			pstmt = getConn().prepareStatement(sql);	//载入SQL语句
			pstmt.setInt(3, dept.getId());				//绑定第一个?的值(username)
			pstmt.setString(1, dept.getdName());
			pstmt.setString(2, dept.getdLoc());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Dept> selectFY(int begin,int num){
		String sql = "select id,dname,dloc from hr_dept limit ?,?";
		List<Dept> list = new ArrayList<Dept>();
		try {
			pstmt = getConn().prepareStatement(sql);	//����SQL���
			pstmt.setInt(1, begin);
			pstmt.setInt(2, num);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String dname = rs.getString("dname");
				String dloc = rs.getString("dloc");
				Dept dept = new Dept();
				dept.setId(id);
				dept.setdName(dname);
				dept.setdLoc(dloc);
				list.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
