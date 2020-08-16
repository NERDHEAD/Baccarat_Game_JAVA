package com.nerdhead.card;

import java.util.Iterator;
import java.util.LinkedList;
/**
 * ArrayList<CardOne>형으로 카드 8댁을 셔플 해서 만들어줌 1댁(52장)*8개=416장!<br>
 * 만들어진 댁에서 위에서 한장씩 빼가게됨.<br>
 * 댁이 전부 소모될경우 자동으로 416장이 세팅됨<br>
 * 
 * @since 2020.08.16
 * @author nerdhead<br>
 * 
 */
public class CardCase {
	private LinkedList<CardOne> cardCase;
	
	public CardCase() {
		makeCardCase();
	}
	private void makeCardCase() {
		cardCase=new LinkedList<CardOne>();
		int cardCaseLength=CardOne.COUNT.length*
									CardOne.SUIT.length*
									CardOne.NUMBER.length;
		/*
		 * 카드 생성
		 * 카드가 댁에 없으면 넣기
		 * 있으면 없을때까지 만들기
		 */
		CardOne card=new CardOne();
		while (true) {
			if(!cardCase.contains(card)) {		//1. 카드가 미포함이면 add, new Card 해주기
				cardCase.add(card);
				card=new CardOne();				//다음 카드 넣을때만 new연산자를 쓰는걸로 매모리 최적화
			}else { card.makeCard(); }			//2. 카드가 포함이면 makeCard로 돌림
			if(cardCase.size()==cardCaseLength) {
				break;									//3. 카드댁이 완성되면 break
				}
			
		}
	}
	
	/**
	 * CardCase에서 한장 빼기
	 * @return
	 */
	public CardOne drawCard() {
		CardOne card;
		if(cardCase.size()!=0) {
			card=cardCase.removeLast();	//카드를 꺼내면 댁에서 없어져야함 ㅇㅇ
		}else {							//만약 카드가 다떨어지면 재귀호출 이용해서 다시만든 카드에서 뽑을 것
			makeCardCase();
			card=drawCard();
		}
		return card;
	}
	
	//Test용 method
	public void test_printCard() {
		int cnt=0;
		for(CardOne c : cardCase) {
			if(cnt%5==0) {
				System.out.printf("\n%d : ",cnt/5+1);
			}
			System.out.printf("%-8s   \t",c);
			cnt++;
		}
		System.out.println();
	}
	
	
	
}
