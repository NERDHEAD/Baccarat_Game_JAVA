package com.nerdhead.card;
/**
 * @since 2020.08.16
 * @author nerdhead
 * 카드 한장 만들어주는 Class<br>
 * 생성자 호출시 카드를 만들어 주고,<br>
 * 이후 makeCard로 카드를 바꿀수있음 
 */
public class CardOne {
	private StringBuilder card=new StringBuilder();
	
	private final String[] COUNT = { 
			   "1번째 : ", "2번째 : ", 
			   "3번째 : ", "4번째 : ", 
			   "5번째 : ", "6번째 : ", 
			   "7번째 : ", "8번째 : "};
	private final String[] SUIT =  {"◆","♠","♥","♣"};
	private final String[] NUMBER = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	
	private int count, suit, number;
	private int score;
	
	

	public CardOne() {
		makeCard();
	}
	public void makeCard() {
		card.setLength(0);
		
		count = (int)(Math.random()*COUNT.length);
		suit = (int)(Math.random()*SUIT.length);
		number =  (int)(Math.random()*NUMBER.length);
//		card = COUNT[count] + SUIT[suit] + NUMBER[number] ;
		
		card.append("【");
		card.append(COUNT[count]).append(SUIT[suit]).append(NUMBER[number]);
		card.append("】");
		
		setScore(number);
	}
	
	private void setScore(int number) {
		switch (number+=1) {
		case 11:						//J Q K는 0점
		case 12:
		case 13:		
			score=0;
			break;
		default:
			score=number;
			break;
		}
	}
	
	public int getScore() {return score;}
	@Override
	public String toString() {return card.toString();}
	@Override
	public int hashCode() {return 10000+(count+1)*1000+(suit+1)*100+(number+1);	}
	@Override
	public boolean equals(Object obj) {
		CardOne card=(CardOne)obj;
		return hashCode()==card.hashCode();
	}
}
