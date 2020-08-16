package com.nerdhead.baccaratgame;

import java.util.LinkedList;

import com.nerdhead.dealer.DealerOneManShow;
import com.nerdhead.input_output_manager.Comment;
import com.nerdhead.input_output_manager.DealerComment;
import com.nerdhead.rull.ResultList;
import com.nerdhead.rull.Result_DTO;
/**
 * 게임을 단순하게 알아서 진행하고,<br>
 * 
 * @author nerdhead
 *
 */
public class Baccarat_Game_Manager {
	/*Member Variable*/
	protected Result_DTO gameResult;	//매 판이 끝나면 해당 결과로 바뀌는 친구
	protected ResultList gameResultList;	//매 판이 끝난 결과를 누적하는 친구
	protected Comment print=new Comment();		//출력 담당 일진 클래스	-> 원하는 대사가 알차게 들어있음
	
//	private Rull rull=new Rull();				//룰을 관리 해주는 친구 -> 딜러가 알아서 체크하새오! ㅍㄷㅍㄷ
	private DealerOneManShow dealer=new DealerOneManShow();	//딜러 -> Player, Banker의 필드를 관리 및
	
	public Baccarat_Game_Manager() {
		init();
	}
	
	protected void init() {
		gameResultList=new ResultList();
	}
	
	
	/**
	 * 게임을 룰대로 진행 하고 승패 결과만 가져 올 수 있음
	 * 대사를 위해 딜러의 진행을 놔눠서 부름  (대사 -> 진행)
	 */
	public void start() {
		//딜러 댁 세팅
		print.dealerSay_SETTING_CARD();
		dealer.init();
		dealer.setCardCase();
		
		//1. 한장 한장 나눠줌
		dealer_placeAtFirst();
		

		//2. Rull.isPlayerDraw(), isBankerDraw() 로 드로우 여부 확인후 추가로 뽑기 
		if(dealer.isPlayerDraw()) {
			dealer_placeToPlayer();
		}
		if(dealer.isBankerDraw()){
			dealer_placeToBanker();
		}
		setGameResult();	
	}

	
	private void setGameResult() {
		gameResult=dealer.getGameResult();
		gameResultList.add(gameResult);		
	}

	/**
	 * 처음 플레이어 뱅
	 */
	private void dealer_placeAtFirst() {
		dealer_placeToPlayer();
		dealer_placeToBanker();
		
		dealer_placeToPlayer();
		dealer_placeToBanker();
	}
	
	
	
	/**Player 카드 주기*/
	private void dealer_placeToPlayer() {
		print.dealerSay_TAKE_CARD(DealerComment.PLAYER);
		dealer.placeToPlayer();
	}
	/**Banker 카드 주기*/
	private void dealer_placeToBanker() {
		print.dealerSay_TAKE_CARD(DealerComment.BANKER);
		dealer.placeToBanker();
	}
	
	/**
	 * 게임 결과 출력 테스트
	 */
	public void test_printResult() {
		String s1 = gameResult.getCardOfResult();
		String s2 = gameResult.toString();
		
		int p=gameResult.getPScore();
		int b=gameResult.getBScore();
		
		System.out.printf("%s\n게임 결과 : (P=%d), (B=%d)%s\n", s1, p, b, s2);
	}
	

	
}
