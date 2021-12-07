package com.ezen;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.bettery.ChargeBattery;
import com.ezen.bettery.NormalBattery;
import com.ezen.toys.ElectronicCar;
import com.ezen.toys.ElectronicRadio;
import com.ezen.toys.ElectronicRobot;

public class MainClass {
	public static void main(String[] args) {
		// 일반적인 사용 예
		
		// 배터리가 장착된 상태로 판매되는 일체형. 객체생성 하나만으로 사용이 가능합니다.
		ElectronicCar carToy = new ElectronicCar();
		
		// 배터리가 없는 상태로 판매되어, 추후 배터리를 장착하여 사용이 가능한 형태
		ElectronicRobot robotToy = new ElectronicRobot();
		
		// 노멀 배터리 객체 생성
		NormalBattery nbatt = new NormalBattery();
		// 충전 배터리 객체 생성
		ChargeBattery cbatt1 = new ChargeBattery();
		// 배러티를 장난감에 장착 -> 사용
		robotToy.setBattery(cbatt1);
		// 멤버 변수는 Battery 인터페이스의 레퍼런스 변수이기 때문에 nbatt 또는 cbatt가
		// 모두 setBattery에 사용이 가능합니다.
		
		// 배터리는 비어있고, 배터리 하나가 동봉되어, 동봉된 배터리를 장착해야만 사용이 가능한 상태
		// ElectronicRadio radioToy = new ElectronicRadio();
		// ElectronicRadio는 생성자에 매개변수가 있고, 디폴트 생성자가 오버로딩 되어있지 않으므로
		// 위 생성은 에러입니다.
		ElectronicRadio radioToy = new ElectronicRadio(nbatt);
		// 생성자에 배터리 객체를 전달해주면 정상 생성.
		// 이렇게 객체 생성시에 다른 객체의 존재 및 생성자로의 전달이 필수인 상태
		// 객체생성에 다른 객체에 의존하고 있는 상태!
		// 이를 객체 의존이라고 부릅니다.
		// 그리고 필요 객체를 생성자의 전달인수로 넣어주는 것을 의존주입이라고 부릅니다.(Dependency Injection)
		
		// 앞선 Sp03 프로젝트와는 다르게, Sp04 예제는 스프링 컨테이너를 이용함으로써, 위의 의존주입 및
		// 객체조립이 훨씬 간단 간결 편리해집니다.
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// ElectronicCar 객체 생성 -> 사용
		ElectronicCar carToy2 = ctx.getBean("car", ElectronicCar.class);
		
		// ElectronicRobot 객체 생성 -> 사용
		ElectronicRobot robotToy2 = ctx.getBean("robot", ElectronicRobot.class);
		NormalBattery nbatt2 = ctx.getBean("nBattery", NormalBattery.class);
		robotToy2.setBattery(nbatt2);
		
		// ElectronicRadio 객체 생성 -> 사용
		ElectronicRadio radioToy2 = ctx.getBean("radio", ElectronicRadio.class);
	}
}
