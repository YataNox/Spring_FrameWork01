package com.ezen.member.service;

import com.ezen.member.dao.StudentDao;
import com.ezen.member.dto.Student;

public class StudentSelectOneService {
private StudentDao sdao;
	
	public StudentSelectOneService(StudentDao sdao) {
		this.sdao = sdao;
	}
	
	public Student selectOneStudent(String sNum) {
		return sdao.selectOneStudent(sNum); 
	}
}
