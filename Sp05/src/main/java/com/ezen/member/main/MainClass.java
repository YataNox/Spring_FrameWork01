package com.ezen.member.main;

import java.util.ArrayList;

import com.ezen.member.dto.Student;
import com.ezen.member.service.StudentAssembler;
import com.ezen.member.service.StudentInsertService;
import com.ezen.member.service.StudentSelectService;

public class MainClass {
	public static void main(String[] args) {
		String[] sNums = {"H39asdfaelu42o23", "H39iiemamca8w9h4", "H39lkmn754fghia7",
				"H39plo865cuy8k92", "H39mnbviiaed89q1", "H399omjjyv56t3d5",
				"H39lczaqwg644gj8", "H39ymbcsh74thgh2", "H39lesvj7544vf89"
		};
		
		String[] sIds = {"hippo", "raccoon", "elephant", "lion", "tiger", "pig", "horse", "bird", "deer"};
		
		String[] sPws = {"94875", "15284", "48765", "28661", "60915", "30028", "29801", "28645", "28465"};
		
		String[] sNames = {"barbara", "chris", "doris", "elva", "fiona", "holly", "jasmin", "lena", "melissa"};
		
		int[] sAges = {22, 20, 27, 19, 21, 19, 25, 22, 24};
		
		String[] sGenders = {"W", "W", "M", "M", "M", "W", "M", "W", "W"};
		
		String[] sMajors = {"Korean Literature", "French Literature", "Philosophy", "History",
				"Law", "Statistics", "Computer", "Economics", "Public Admin"};
		
		Student std = new Student("H39r8djakndfae32", "rabbit", "96539", "agatha", 19,
				"M", "English Literature");
		
		// StudentDao sdao = new StudentDao();
		// sdao.insertStudent(std);
		
		// StudentDao sdao = new StudentDao();
		// StudentInsertService sis = new StudentInsertService(sdao);
		// sis.insertStudent(std);
		
		StudentAssembler assembler = new StudentAssembler();
		StudentInsertService is = assembler.getIs();
		// is.insertStudent(std);
		for(int i = 0; i < sNums.length; i++) {
			Student std1 = new Student(sNums[i], sIds[i], sPws[i], 
					sNames[i], sAges[i], sGenders[i], sMajors[i]);
			// is.insertStudent(std1);
		}
		
		StudentSelectService ss = assembler.getSs();
		ArrayList<Student> list = ss.selectStudent();
		
		for(int j = 0; j < list.size(); j++) {
			System.out.print("| sNum : " + list.get(j).getsNum() + "\t");
			System.out.print("| sId : " + list.get(j).getsId() + "\t");
			System.out.print("| sPw : " + list.get(j).getsPw() + "\t");
			System.out.print("| sName : " + list.get(j).getsName() + "\t");
			System.out.print("| sAge : " + list.get(j).getsAge() + "\t");
			System.out.print("| sGender : " + list.get(j).getsGender() + "\t");
			System.out.print("| sMajor : " + list.get(j).getsMajor() + "\n");
		}
	}
}
