package com.ezen.word.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ezen.word.dto.WordSet;
import com.ezen.word.util.DataBaseManager;

public class WordDao {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// DataBaseManager dbm = new DataBaseManager();
	DataBaseManager dbm = null;
	
	public WordDao(DataBaseManager dbm) {
		this.dbm = dbm;
	}

	public void insert(WordSet wordset) {
		con = dbm.getConnection();
		
		dbm.close(con, pstmt, rs);
	}
	
	public WordSet search(String kw) {
		con = dbm.getConnection();
		
		dbm.close(con, pstmt, rs);
		return null;
	}
}
