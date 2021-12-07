package com.ezen.member.service;

import com.ezen.member.dao.StudentDao;
import com.ezen.member.dto.Student;

public class StudentUpdateService {
	private StudentDao sdao;
	
	public StudentUpdateService(StudentDao sdao) {
		this.sdao = sdao;
	}
	
	public void updateStudent(Student sdt) {
		sdao.updateStudent(sdt);
	}
}
