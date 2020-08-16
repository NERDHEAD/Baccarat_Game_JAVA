package com.nerdhead.rull;

import java.util.List;

import com.nerdhead.card.CardOne;
/**
 * 요구사항 005<br>
 * @author nerdhead
 * @since 2020.08.17
 */
public class Rull {
	//이건 if문 돌리면 머리가 깨져 버릴듯 해서 배열처리함
	private final boolean[][] bankerStandZone= {	
			{false,	false,	false,	false,	false,	false,	false,	false,	false,	false},		//뱅커 합 : 0
			{false,	false,	false,	false,	false,	false,	false,	false,	false,	false},		//뱅커 합 : 1
			{false,	false,	false,	false,	false,	false,	false,	false,	false,	false},		//뱅커 합 : 2
			{false,	false,	false,	false,	false,	false,	false,	false,	true,	false},		//뱅커 합 : 3
			{true,	true,	false,	false,	false,	false,	false,	false,	true,	true},		//뱅커 합 : 4
			{true,	true,	true,	true,	false,	false,	false,	false,	true,	true},		//뱅커 합 : 5
			{true,	true,	true,	true,	true,	true,	false,	false,	true,	true},		//뱅커 합 : 6
			{true,	true,	true,	true,	true,	true,	true,	true,	true,	true},		//뱅커 합 : 7
	};		//0		1		2		3		4		5		6		7		8		9
	
	
	
	private List<CardOne> player;
	private List<CardOne> banker;
	
	public Rull(List<CardOne> player, List<CardOne> banker) {
		this.player=player;
		this.banker=banker;
	}
	
	/**
	 *  둘중 한명이라도 합이 8,9 면 전부 뽑을수 없음!
	 *  
	 * @return
	 */
	public boolean isPlayerDraw() {
		if(isNatural()||isStand(player)) 	{return false;}
		else 									{return true;}
	}

	

	public boolean isBankerDraw() {
		if(isNatural()||isBankerStand())	{return false;}
		else 									{return true;}
	}
	
	
	/*아래는 각종 규칙 판단을 위한 Method*/
	
	/**
	 * 둘다 Natural인지 확인하고 처리함
	 * @return
	 */
	private boolean isNatural() {
		return isNatural(player)||isNatural(banker);
	}

	/**
	 * CardOne 타입의 user의 합이 8이나 9인지 확인함
	 * @param user CardOne
	 * @return boolean
	 */
	private boolean isNatural(List<CardOne> user) {
		int sum=getCardSum(user);	
		switch (sum) {
		case 8:	case 9:	return true;
		default:				return false;
		}
	}
	/**
	 * 플레이어의 카드의 합이 6, 7 인지 확인함
	 * @return
	 */
	private boolean isStand(List<CardOne> user) {
		int sum=getCardSum(user);	
		switch (sum) {
		case 6:	case 7:	return true;
		default:				return false;
		}
	}
	
	private boolean isBankerStand() {
		if(player.size()==2) {return isStand(banker);}
		else {
			int bankerSum=getCardSum(banker);				//뱅커의 카드 합
			int third_card_of_Player=player.get(2).getScore(); //player의 세번째 카드
			return bankerStandZone[bankerSum][third_card_of_Player];
		}
		
	}
	
	
	
	
	
	//***************************************************************************//
	/**
	 * Card List의 합 구해주는 놈
	 * @param List<CardOne>
	 * @return CardOne List Sum
	 */
	private int getCardSum(List<CardOne> user) {
		int sum=0;
		for(CardOne c : user) {
			sum+=c.getScore();
		}
		return sum%10;
	}

	public Result_DTO getGameResult() {
		Result_DTO gameResult=new Result_DTO();
		
		gameResult.setResult(getResult());					//Player Win , Banker Win, Tie
		gameResult.setPlayer_pair(isPair(player));		//Player Pair
		gameResult.setBanker_pair(isPair(banker));		//Banker Pair
		gameResult.setLucky6_1(islucky6(2));			//Lucky6 Double
		gameResult.setLucky6_2(islucky6(3));			//Lucky6 Triple
		
		gameResult.setPlayer(player);
		gameResult.setBanker(banker);
		gameResult.setPScore(getCardSum(player));
		gameResult.setBScore(getCardSum(player));
		
		
		return gameResult;
	}

	/**
	 * 합이 6이고 크기가 size와 같으면 lucky6
	 * @param size
	 * @return
	 */
	private boolean islucky6(int size) {
		if(getCardSum(banker)==6&&banker.size()==size) {
			return true;
		}else {return false;}
	}

	/**
	 * 첫번째와 두번째 카드가 겹치는지 확인하기
	 * @param user
	 * @return
	 */
	private boolean isPair(List<CardOne> user) {
		return user.get(0).equals(user.get(1));
	}

	private int getResult() {
		int playerScore=getCardSum(player);
		int bankerScore=getCardSum(banker);
		
		if(playerScore>bankerScore) 		return Result.PLAYER_WIN;
		else if(playerScore<bankerScore)	return Result.BANKER_WIN;
		else										return Result.TIE;
	}
	
	
	
	
}
