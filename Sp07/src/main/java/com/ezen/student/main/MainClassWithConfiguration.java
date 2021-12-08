package com.ezen.student.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ezen.student.configuration.StudentConfiguration;
import com.ezen.student.dto.Student;
import com.ezen.student.service.SelectOneService;

public class MainClassWithConfiguration {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(StudentConfiguration.class);
		
		SelectOneService sos = ctx.getBean("selectOneService", SelectOneService.class);
		Student std = sos.selectOneStudent("H39lesvj7544vf89");
		
		System.out.print("| sNum : " + std.getsNum() + "\t");
		System.out.print("| sId : " + std.getsId() + "\t");
		System.out.print("| sPw : " + std.getsPw() + "\t");
		System.out.print("| sName : " + std.getsName() + "\t");
		System.out.print("| sAge : " + std.getsAge() + "\t");
		System.out.print("| sGender : " + std.getsGender() + "\t");
		System.out.print("| sMajor : " + std.getsMajor() + "\n");
		
		ctx.close();
	}
}
