package com.ezen.student.service;

import java.util.ArrayList;

import com.ezen.student.dao.StudentDao;
import com.ezen.student.dto.Student;

public class SelectAllService {
	private StudentDao sdao;
	
	public SelectAllService(StudentDao sdao) {
		this.sdao = sdao;
	}
	
	public ArrayList<Student> selectAllStudent() {
		ArrayList<Student> list = null;
		list = sdao.SelectOneStudent();
		return list;
	}
}
