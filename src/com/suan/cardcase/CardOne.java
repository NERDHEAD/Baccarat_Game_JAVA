package com.suan.cardcase;

public class CardOne {

	/**
	 * @since : 2020.08.15
	 * @author : 이수안
	 */
	protected String card;
	
	public static final String[] COUNT = { 
			   "1번째 : ", "2번째 : ", 
			   "3번째 : ", "4번째 : ", 
			   "5번째 : ", "6번째 : ", 
			   "7번째 : ", "8번째 : "};
	public static final String[] SHAPE =  {"◆","♠","♥","♣"};
	public static final String[] NUMBER = {"1","2","3","4","5","6","7","8","9","10","J","Q","K"}; 

	public CardOne() {
		makeCard();
	}
	
	private void makeCard() {
		int s = (int)(Math.random()*SHAPE.length)+1; //4
		int n =  (int)(Math.random()*NUMBER.length)+1; //13
		int c = (int)(Math.random()*COUNT.length)+1; //8
		card = COUNT[c-1] + SHAPE[s-1] + NUMBER[n-1] ; //
	}

	@Override
	public String toString() {
		return "[" + card + "]";
	}

	@Override
	public int hashCode() {
		return card.hashCode()+137;
	}

	@Override
	public boolean equals(Object obj) {
		//contains(card) 사용하면 equals로
		boolean isc = false;
		CardOne other = (CardOne) obj; //다운 캐스팅
		// 리스트안에 있는 값을 새로 들어온 얘와 비교
		// 같은 타입이여야 비교 가능
		if(card.equals(other.card)) {
			isc = true;
		}
		return isc;
	}
}
