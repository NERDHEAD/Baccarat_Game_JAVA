package com.suan.cardcase;

import java.util.ArrayList;
import java.util.List;

/**
 * @since : 2020.08.15
 * @author : 이수안
 *
 * Arraylist인 cardCase 생성 클래스 
 */
public class CardCase {
	protected List<CardOne> cardCase;

	/**
	 * default 생성자
	 * CardCase 클래스가 메모리에 올라오면(객체화)하면
	 * 생성 : 
	 * ArrayList : cardCase
	 * Method : makeCardCase()
	 */
	public CardCase() {
		cardCase = new ArrayList<CardOne>();
		makeCardCase(); 
	}

	/**
	 * 
	 */
	protected void makeCardCase() {
		int len = CardOne.SHAPE.length * CardOne.NUMBER.length * CardOne.COUNT.length;
		System.out.println(len);
		while (true) {
			CardOne card = new CardOne(); //makeCard();
			if (!cardCase.contains(card)) 
				//contains는 equals비교 equals는 해쉬코드비교
				//같지 않다면 카드 케이스에 카드를 넣어줌
				cardCase.add(card);
			if (cardCase.size() == len) { //52장의 카드 생성
				break;
			}
		}
	}

	public List<CardOne> getCardCase() {
		return cardCase;
	}
}
