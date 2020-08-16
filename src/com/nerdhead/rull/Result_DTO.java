package com.nerdhead.rull;

import java.util.List;

import com.nerdhead.card.CardOne;
import com.nerdhead.input_output_manager.DealerComment;

/**
 * @since 2020.08.15
 * @author nerdhead
 * result에 담는 값은 Result Interface에 PLAYER_WIN, BANKER_WIN, TIE 상수로 받아 쓸 것<br>
 */
public class Result_DTO implements Result{
	private int result;
	private boolean player_pair=false;
	private boolean banker_pair=false;
	private boolean lucky6_1=false;
	private boolean lucky6_2=false;
	
	private List<CardOne> player;
	private int pScore;
	private List<CardOne> banker;
	private int bScore;
	
	//각각의 값이 따로 판정되서 set 되므로 생성자에서 한번에 결정될 일이 아님
//	public Result_DTO(int result,boolean player_pair,boolean banker_pair,
//			boolean lucky6_1,boolean lucky6_2) {
//		this.result=result;
//		this.player_pair=player_pair;
//		this.banker_pair=banker_pair;
//		this.lucky6_1=lucky6_1;
//		this.lucky6_2=lucky6_2;
//	}


	
	/**GETTER*/
	public int getResult() {
		return result;
	}
	public boolean isPlayer_pair() {
		return player_pair;
	}
	public boolean isBanker_pair() {
		return banker_pair;
	}
	public boolean isLucky6_1() {
		return lucky6_1;
	}
	public boolean isLucky6_2() {
		return lucky6_2;
	}
	public int getPScore() {
		return pScore;
	}
	public int getBScore() {
		return bScore;
	}
	
	//판 끝날때 결과 출력용으로 밖에 안쓸듯
//	public List<CardOne> getPlayer() {
//		return player;
//	}
//	public List<CardOne> getBanker() {
//		return banker;
//	}
	
	
	/**SETTER*/
	public void setResult(int result) {
		this.result = result;
	}
	public void setPlayer_pair(boolean player_pair) {
		this.player_pair = player_pair;
	}
	public void setBanker_pair(boolean banker_pair) {
		this.banker_pair = banker_pair;
	}
	public void setLucky6_1(boolean lucky6_1) {
		this.lucky6_1 = lucky6_1;
	}
	public void setLucky6_2(boolean lucky6_2) {
		this.lucky6_2 = lucky6_2;
	}
	public void setPlayer(List<CardOne> player) {
		this.player = player;
	}
	public void setBanker(List<CardOne> banker) {
		this.banker = banker;
	}
	public void setPScore(int cardSum) {
		pScore=cardSum;		
	}
	public void setBScore(int cardSum) {
		bScore=cardSum;				
	}
	
	
	/******Override******/
	/**
	 * Player가 승리하면 P, Banker가 승리하면 B, 무승부는 T를 돌려줌
	 */
	@Override
	public String toString() {
		switch (result) {
		case Result.PLAYER_WIN: 	return "P";
		case Result.BANKER_WIN:	return "B";
		case Result.TIE:					return "T";
		default:							return "?";
		}
	}
	public String getCardOfResult() {
		StringBuilder str=new StringBuilder();
		
		str.append(DealerComment.PLAYER).append(" : ");
		for (CardOne c : player) {
			str.append(String.format("%-8s", c.toString()));
		}
		str.append("\n");
		str.append(DealerComment.BANKER).append(" : ");
		for (CardOne c : banker) {
			str.append(String.format("%-8s", c.toString()));
		}
		
		return str.toString();
	}

	
}
