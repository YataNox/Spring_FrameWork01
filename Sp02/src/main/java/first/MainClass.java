package first;

public class MainClass {
	public static void main(String[] args) {
		System.out.println("스프링 프레임워크 응용 소프트웨어 프로젝트입니다.");
		
		// 자식 인스턴스 CalSum등을 객체 부모 Calculator 객체 변수에 저장
		Calculator c = new CalSum();
		int result = c.cal(45, 78);
		System.out.println("45 + 78 => " + result);
		
		c = new CalSub();
		result = c.cal(45, 78);
		System.out.println("45 - 78 => " + result);
		
		c = new CalMul();
		result = c.cal(45, 78);
		System.out.println("45 * 78 => " + result);
	}
}
