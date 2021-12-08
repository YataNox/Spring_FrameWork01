package com.ezen.student.service;

import com.ezen.student.dao.StudentDao;
import com.ezen.student.dto.Student;

public class SelectOneService {
	private StudentDao sdao;
	
	public SelectOneService(StudentDao sdao) {
		this.sdao = sdao;
	}
	
	public Student selectOneStudent(String sNum) {
		Student std = sdao.SelectOneStudent(sNum);
		return std;
	}
}
