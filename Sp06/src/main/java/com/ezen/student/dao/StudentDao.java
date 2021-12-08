package com.ezen.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.student.dto.DataBaseConnectionInfo;
import com.ezen.student.dto.Student;

public class StudentDao {
	String driver = null;/* "oracle.jdbc.driver.OracleDriver"; */
	String url = null;/* "jdbc:oracle:thin:@localhost:1521:xe"; */
	String id = null;
	String pw = null;
	
	// Construct
	public StudentDao(DataBaseConnectionInfo dbconinfo) {
		this.driver = dbconinfo.getDriver();
		this.url = dbconinfo.getjdbcUrl();
		this.id = dbconinfo.getuserId();
		this.pw = dbconinfo.getuserPw();
	}

	// connection object / connect/close Method
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close() {
		try {
			if(con!=null)
				con.close();
			if(pstmt!=null) {
				pstmt.close();
			}
			if(rs!=null) {
				rs.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	// Method 
	public Student SelectOneStudent(String sNum) {
		String sql = "select * from student where sNum = ?";
		Student std = null;
		con = getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				std = new Student(rs.getString("snum"), rs.getString("sid"), rs.getString("spw"), 
						rs.getString("sname") ,rs.getInt("sage"), rs.getString("sgender"), rs.getString("smajor"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return std;
	}

	public ArrayList<Student> SelectOneStudent() {
		String sql = "select * from student";
		ArrayList<Student> list = new ArrayList<Student>();
		con = getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Student svo = new Student(rs.getString("snum"), rs.getString("sid"), rs.getString("spw"), 
						rs.getString("sname") ,rs.getInt("sage"), rs.getString("sgender"), rs.getString("smajor"));
				list.add(svo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}

	public void updateStudent(Student std) {
		String sql = "update student set sid=?, spw=?, sname=?, sage=?, "
				+ "sgender=?, smajor=? where snum = ?";
		
		con = getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, std.getsId());
			pstmt.setString(2, std.getsPw());
			pstmt.setString(3, std.getsName());
			pstmt.setInt(4, std.getsAge());
			pstmt.setString(5, std.getsGender());
			pstmt.setString(6, std.getsMajor());
			pstmt.setString(7, std.getsNum());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}

	public void insertStudent(Student std) {
		String sql = "insert into student(snum, sid, spw, sname, sage, sgender, smajor) "
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		
		con = getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, std.getsNum());
			pstmt.setString(2, std.getsId());
			pstmt.setString(3, std.getsPw());
			pstmt.setString(4, std.getsName());
			pstmt.setInt(5, std.getsAge());
			pstmt.setString(6, std.getsGender());
			pstmt.setString(7, std.getsMajor());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
}
