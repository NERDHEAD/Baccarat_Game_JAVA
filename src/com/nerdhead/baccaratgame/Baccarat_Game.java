package com.nerdhead.baccaratgame;

public class Baccarat_Game {
	
	/**
	 * constructor
	 */
	public Baccarat_Game() {
		init();						//환경 초기화
	}
	
	/**
	 * initialize
	 */
	private void init() {
		
	}
	
	
	
	/**
	 * 게임 시작 Method
	 */
	public void start() {
		//수하~ (대충 수안이 ㅎㅇ 라는 뜻)
		/*
		 * 1. 딜러 :  몇명이서 왔는지? 	-> 몇명인지 입력 받음	-> 손님수 만큼 이름을 입력 받음 ( 4번째는 넘어가고 5번째로 감 )
		 * 		-> 몇개의 칩 / 몇판 할껀지 정함				-----> 손님수 + 칩수 + 판수 + 매판 20%이상의 칩 사용 룰 = 손님들끼리의 승패 룰 적용
		 * 2. 딜러 :  배팅하새오			-> 순서대로 배팅 ( 각각 최소 20%의 칩을 사용해야함 )
		 * 3. 딜러 :  배팅 끗~				-> 카드 세팅
		 * 4. 딜러 : 카드 받으새오~~		-> 플레이어&뱅커 한테 2장씩 줌
		 * 5. 딜러 : (생각중...)				-> 룰 판정 하는 Method에 플레이어, 뱅커를 던짐 	-> 조건에 따라 플레이어&뱅커에게 한장씩 줌 -> 이후 둘을 비교함
		 * 6. 딜러 : ~~~의 승리!/무승부	-> 판정+플레이어&뱅커의 댁을 배팅Class에 던짐	-> 배팅 정산(팩토리 패턴 : 각자에게 결과 전달)
		 * 	-> 결과 ( P / B / T )가 누적 및 출력	-> 손님의 칩 현황 출력
		 * 7. 딜러 : 계속 진행 하시겠습니까? 
		 * 			a. 게임 계속 진행 							->	2번부터
		 * 			b. 칩과 판수 재설정 ->					-> 1번의 중간 부터
		 * 			c. 손님 수변경 + 칩과 판수 재설정 		-> 처음부터
		 * 			d. 게임 종료 								-> break;
		 */
	}
}
