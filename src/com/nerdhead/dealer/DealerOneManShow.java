package com.nerdhead.dealer;

import java.util.ArrayList;
import java.util.List;

import com.nerdhead.card.CardCase;
import com.nerdhead.card.CardOne;
import com.nerdhead.rull.Result_DTO;
import com.nerdhead.rull.Rull;
/**
 * 요구사항 004<br>
 * @author nerdhead
 *
 */
public class DealerOneManShow{
	/* TODO : Neeeeeed Refactoring
	 *  나중에 List<CardOne> Extends 받아서 toStirng으로 소유한거 출력하게 구현하고
	 *  구현 되면 Result_DTO의 getCardOfResult() 구현도 손 볼 것!
	 */
	
	private List<CardOne> player;
	private List<CardOne> banker;
	private CardCase cardCase;
	
	private Rull rull;
	
	public void init() {
		player=new ArrayList<CardOne>();
		banker=new ArrayList<CardOne>();
		rull=new Rull(player, banker);
	}
	/*게임 결과 돌려줌*/
	public Result_DTO getGameResult() {
		return rull.getGameResult();
	}
	/**
	 * Player가 세번째 카드 받을수있는지 확인하는 기능
	 * @return rull.isPlayerDraw()
	 */
	public boolean isPlayerDraw() {
		return rull.isPlayerDraw();
	}
	/**
	 * Banker가 세번째 카드 받을수있는지 확인하는 기능
	 * @return rull.isBankerDraw()
	 */
	public boolean isBankerDraw() {
		return rull.isBankerDraw();
	}
	
	
	
	
	
	public void setCardCase() {
		cardCase=new CardCase();
	}
	public void placeToPlayer() {
		placeCard(player);
	}
	public void placeToBanker() {
		placeCard(banker);
	}
	
	/**
	 * cardCase에서 한장 빼서 user에 추가
	 * @param user
	 */
	private void placeCard(List<CardOne> user) {
		user.add(cardCase.drawCard());
	}

	
	

}
