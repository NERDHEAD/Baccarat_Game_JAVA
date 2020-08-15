package com.suan.cardcase;

import java.util.Iterator;
import java.util.List;

public class CardCaseMain {

	public static void main(String[] args) {
		CardCase cards = new CardCase();
		List<CardOne> lists = cards.getCardCase();

		for (CardOne o : lists) {
			System.out.println(o);
		}
		
		System.out.println(lists.size());
	}
}
