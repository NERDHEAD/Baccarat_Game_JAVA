package com.nerdhead.baccaratgame;

import com.nerdhead.input_output_manager.Comment;
/**
 * @since 2020.08.16
 * @author nerdhead
 * Manager는 단순히 게임 로직 + 결과(Result_DTO)의 LinkedList만 가지고있음(결과는 순서대로 누적되어야 하기 떄문)
 * Manager를 상속받아 손님의 기능을 추가함
 */
public class Baccarat_Game extends Baccarat_Game_Manager{	//manager는 게임 시작후 단순히 진행, 게임 결과만 가지는 class
	private final static int GIVE_UP=-1;
	private final static int RETRY=0;
	private final static int CONTINUE=1;
	private int ask;
	
	
	
	
	/*Member Variable*/
	private Comment print=new Comment();		//출력 담당 일진 클래스	-> 원하는 대사가 알차게 들어있음
	private AskAbout ask=new AskAbout();			//입력 담당 일진 클래스	-> 요구한 값이 맞는지 전부 검증해줌
	private Guests guests;								//손님 담당 일진 클래스	-> 손님수, 손님칩수, 턴수를 정해줘야함	-> 안하면 화냄
	

	
	/**
	 * constructor
	 */
	public Baccarat_Game() {
		init();						//환경 초기화
	}
	
	/**
	 * initialize
	 */
	protected void init() {
		super.init();
		
		/*게스트 초기화*/
		guests=new Guests();
		guests.setChip(Guests.DefaultChip);
		guests.setMaxTurn(Guests.DefaultTurn);
		
	}
	
	
	
	/**
	 * 게임 시작 Method
	 */

	public void start() {
		/************************************************* 기본 흐름 ****************************************************
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
		 *************************************************************************************************************/
		while(true) {
			if(guests.isFirst()) {guestsSetting();}												//1. 손님수, 손님이름 둘다 체크 후 없으면 받기
			guestsBetting();																		//2. 게스트 배팅하기
			super.start();		//SuperClass														//3. 딜러가 게임을 진행함 -> Result_DTO(protected)에 결과가 저장됨
			gameResult();																			//4. 배팅 정산 및 결과 출력
																										//계속할껀지 상태보고 정하기 
			askResult();
			if(ask==CONTINUE) {
				continue;
			}else if(ask==RETRY) {
				init();
				continue;
			}else if(ask==GIVE_UP) {
				break;
			}
			
		}
		
		
		
		

		
		
	}
	private void guestsSetting() {
		print.dealerSay_ASK_GUESTS_COUNT();			//몇명이서 온지 질문 출력
		guests.setCount(ask.checkGeustCount());
//		guests.setChip(1000);									//받지 않으면 default 값으로 init에서 처리함
//		guests.setMaxTurn(20);								//받지 않으면 default 값으로 init에서 처리함
		
		print.dealerSay_ASK_GUESTS_NAME();
		guests.setName(ask.checkGuestName(guests.getGuestInfo()));
	}
	
	private void guestsBetting() {
		print.dealerSay_BET_PLZ();
		guests.betChips(ask.checkGuestBet(guests.getGuestInfo()));			//손님들의 dto array받아서 순차 질문 후 해당 질문을 다시 dto에 담아서 return함
		print.dealerSay_BET_END();
	}
	
	private void gameResult() {
		print.dealerSay_GAME_RESULT(gameResult);							//게임 결과 dto를 통해 결과를 딜러가 출력
		
		guests.setGameResult(gameResult);										//결과 입력 
		print.systemSay_GEUSTS_RESULT(guests.getGameResult());			//결과 출력	(모든 손님의 배팅결과가 출력됨)		//파산 포함
		//ex)  "누구누구"님이 칩 800개 Luck6!! 18배율!	 등등 출력후 정산표 출력
		print.systemSay_HISTORY_BOARD(gameResultList);					//게임 누적 결과를 받아서 출력해줌
	}
	private void askResult() {
		//TODO : ask에 선택 결과 저장하게하면됨
	}
	
	
}
