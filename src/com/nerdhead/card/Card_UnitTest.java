package com.nerdhead.card;

public class Card_UnitTest {

	public static void main(String[] args) {
		Card_UnitTest c=new Card_UnitTest();
		
//		c.test_cardmake();
		c.test_compare();
	}
	
	/**
	 * 무작위 10장 생성
	 */
	public void test_cardmake() {
		CardOne card=new CardOne();
		for (int i = 0; i < 10; i++) {
			System.out.printf("카드 : %s \t/ hashcode : %d \t/ 점수 : %d\n", card, card.hashCode(), card.getScore());
			card.makeCard();
		}
	}
	/**
	 * equals로 비교
	 */
	public void test_compare() {
		CardOne card1=new CardOne();
		CardOne card2=new CardOne();
		int cnt=0;
		
//		while(card1.hashCode()!=card2.hashCode()) {
		while(!card1.equals(card2)) {
			cnt++;
			card2.makeCard();
		}
		System.out.printf("카드1 -> toString : %s \t/ hashcode : %d \t/ 점수 : %d\n", card1, card1.hashCode(), card1.getScore());
		System.out.printf("카드2 -> toString : %s \t/ hashcode : %d \t/ 점수 : %d\n", card2, card1.hashCode(), card2.getScore());
		
		System.out.printf("비교 -> toString : %b \t/ equals : %b\n", card1.toString().equals(card2.toString()), card1.equals(card2));
		System.out.printf("걸린 횟수 : %d\n", cnt);
	}

}
