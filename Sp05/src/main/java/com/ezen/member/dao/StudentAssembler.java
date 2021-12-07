package com.ezen.member.dao;

import com.ezen.member.service.StudentInsertService;

// 서비스의 클래스 형태의 객체들을 하나씩 생성-보유하고 있다가 요청시 리턴해서 사용할 수 있게합니다.
// 프로젝트 내에 유일할 객체들입니다.
public class StudentAssembler {
	private StudentDao sdao;
	private StudentInsertService is;
	
	public StudentAssembler() {
		sdao = new StudentDao(); // 객체 생성
		is = new StudentInsertService(sdao); // 조립
	}
	
	public StudentInsertService getIs() {
		return is;
	}
}
