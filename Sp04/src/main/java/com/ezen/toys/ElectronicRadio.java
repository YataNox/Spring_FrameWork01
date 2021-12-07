package com.ezen.toys;

import com.ezen.bettery.Battery;

public class ElectronicRadio {
	private Battery bat; // 인터페이스 레퍼런스 변수.
	
	public ElectronicRadio(Battery bat){
		this.bat = bat;
	}
	// 구매와 동시에 동봉된 새 배터리를 장착할 수 있는 기능이 있습니다.
	
	public void setBattery(Battery battery) {
		this.bat = battery;
		// 추후 배터리를 새로 교체할 수 있는 기능이 있습니다.
	}
}
