package com.nerdhead.input_output_manager;
/**
 * @since 2020.08.15
 * @author nerdhead
 * 딜러의 대사를 가지고만 있는 Interface<br>
 * String.format의 형태도 가능<br>
 */
public interface DealerComment {
	public static final String DEALER = "【딜러】   ";

	
	public static final String PLAYER = "【Player】 ";
	public static final String BANKER= "【Banker】";
	public static final String WIN= "【승리】";
	public static final String TIE= "【무승부】";
	
	
	
	/**시작*/
	public static final String WELCOME="환영...";
	
	/**손님 접대*/
	public static final String ASK_GUESTS_COUNT="몇명";
	public static final String ASK_GUESTS_NAME="이름?";
	
	public static final String BET_PLZ="배팅";
	public static final String BET_END="그만";
	
	/**게임 중*/
	public static final String SETTING_CARD="촤라라라락 차ㅏㄱ착 파라랅! (대충 412장의 카드를 멋지게 두손으로 셔플하는소리)";
	public static final String TAKE_CARD="자 %s, 카드";
	public static final String CHECK_RULL="( 생각중... )";
	public static final String GAME_RESULT="%s의 %s";		//(Player/Banker)의 승리! or 무승부! 로 뜨게
	
	public static final String DRAW_CARD_AT_FIRST="%s의 카드합 : %d"; // Player의 카드의 합 : 7
	
	
	
//	public static final String	 

	
	
	
	
}