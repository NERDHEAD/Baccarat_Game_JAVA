package com.suan.cardcase;

import java.util.ArrayList;
import java.util.List;

public class CardCase {
	protected List<CardOne> cardCase;

	public CardCase() {
		cardCase = new ArrayList<CardOne>();
		makeCardCase(); 
	}

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
