package com.ezen.student.service;

import com.ezen.student.dao.StudentDao;
import com.ezen.student.dto.Student;

public class InsertService {
	private StudentDao sdao;
	
	public InsertService(StudentDao sdao) {
		this.sdao = sdao;
	}
	
	public void insertStudent(Student std) {
		sdao.insertStudent(std);
	}
}
