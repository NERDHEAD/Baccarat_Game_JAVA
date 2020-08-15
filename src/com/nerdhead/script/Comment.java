package com.nerdhead.script;

import com.nerdhead.rull.Result;
import com.nerdhead.rull.Result_DTO;

public class Comment implements DealerComment{
	private StringBuilder sb=new StringBuilder();
	
	private void dealerSay(String str) {
		sb.setLength(0);
		
		sb.append(DEALER).append(" : ").append(str);

		System.out.println(sb);

	}

	private void systemSay(String str) {
		sb.setLength(0);
		System.out.println(str);
	}
	
	public void dealerSay_WELCOME() {
		dealerSay(WELCOME);
	}
	public void dealerSay_ASK_GUESTS_COUNT() {
		dealerSay(ASK_GUESTS_COUNT);
	}
	public void dealerSay_ASK_GUESTS_NAME() {
		dealerSay(ASK_GUESTS_NAME);
	}
	public void dealerSay_BET_PLZ() {
		dealerSay(BET_PLZ);
	}
	public void dealerSay_BET_END() {
		dealerSay(BET_END);
	}
	
	public void dealerSay_TAKE_CARD() {
		dealerSay(TAKE_CARD);
	}
	
	public void dealerSay_CHECK_RULL() {
		dealerSay(CHECK_RULL);
	}
	public void dealerSay_GAME_RESULT(Result_DTO dto) {
		int result=dto.getResult();
		if(result==Result.PLAYER_WIN) {			//Player 승리
			dealerSay(String.format(GAME_RESULT, PLAYER, WIN));
		}else if(result==Result.BANKER_WIN) {	//Banker 승리
			dealerSay(String.format(GAME_RESULT, BANKER, WIN));
		}else if(result==Result.TIE) {			//무승부
			dealerSay(TIE);
		}
	}
	
	public void dealerSay_DRAW_CARD_AT_FIRST(String who, int sum) {
			dealerSay(String.format(DRAW_CARD_AT_FIRST, who, sum));
	}
	
}