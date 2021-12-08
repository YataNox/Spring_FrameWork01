package com.ezen.student.service;

import com.ezen.student.dao.StudentDao;
import com.ezen.student.dto.Student;

public class UpdateService {
	private StudentDao sdao;
	
	public UpdateService(StudentDao sdao) {
		this.sdao = sdao;
	}
	
	public void UpdateStudent(Student std) {
		sdao.updateStudent(std);
	}
}
