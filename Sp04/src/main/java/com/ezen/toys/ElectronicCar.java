package com.ezen.toys;

import com.ezen.bettery.Battery;
import com.ezen.bettery.NormalBattery;

public class ElectronicCar {
	private Battery bat; // 인터페이스 레퍼런스 변수.
	
	ElectronicCar(){
		bat = new NormalBattery();
		// 인터페이스 멤버 변수에 battery를 임플리먼트한 클래스를 대입합니다.
	}
}
// 이 장난감은 배터리가 출시 당시 탑재(내장)되서 교체가 불가능한 상태로 판매되는 형태입니다.