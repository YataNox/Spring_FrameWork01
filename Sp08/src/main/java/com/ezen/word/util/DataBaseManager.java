package com.ezen.word.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

public class DataBaseManager {
	// private String driver;
	// private String url;
	// private String id;
	// private String pw;
	
	@Autowired // 스프링 컨테이너에서 해당 객체를 스스로 검색 후 꺼내서 아래 레퍼런스 변수에 할당합니다.
	private DataBaseUserinfo dbi;
	// appCtx.xml 안에서 Constructor-args를 사용하지 않고, 직접 DataBaseUserinfo 객체를
	// 꺼내다가 dbi 변수에 넣어서 사용할 수 있게 합니다.
	
	/*public DataBaseManager(DataBaseUserinfo dbi) {
		url = dbi.getUrl();
		id = dbi.getId();
		pw = dbi.getPw();
		driver = dbi.getDriver();
	}*/
	
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(dbi.getDriver());
			con = DriverManager.getConnection(dbi.getUrl(), dbi.getId(), dbi.getPw());
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(con != null)
				con.close();
			if(pstmt != null)
				pstmt.close();
			if(rs != null)
				rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
