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
	
	public static final String[] COUNT = { 						//사용될일이 없긴함, 8댁을 섞을때 확인을 위해 쓸려고 했던 것 -> 몇 번째 댁인지 hashcode로 알수있어서 안쓰는걸로...
			   "1번째 : ", "2번째 : ", 
			   "3번째 : ", "4번째 : ", 
			   "5번째 : ", "6번째 : ", 
			   "7번째 : ", "8번째 : "};
	public static final String[] SUIT =  {"◆","♠","♥","♣"};
	public static final String[] NUMBER = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	
	private int count, suit, number;
	private int score;
	
	

	public CardOne() {
		makeCard();
	}
	public void makeCard() {
		card.setLength(0);
		/*카드 조합기*/
		count = (int)(Math.random()*COUNT.length);
		suit = (int)(Math.random()*SUIT.length);
		number =  (int)(Math.random()*NUMBER.length);
		
		/*카드 String으로 출력할때의 값*/
//		card = COUNT[count] + SUIT[suit] + NUMBER[number] ;
		card.append("【");
		card/*.append(COUNT[count])*/.append(SUIT[suit]).append(NUMBER[number]);
		card.append("】");
		
		setScore(number);
	}
	
	private void setScore(int number) {
		switch (number+=1) {	//10 J Q K는 0점
		case 10:	case 11:	case 12:	case 13:			
			score=0;
			break;
		default:
			score=number;
			break;
		}
	}
	/**
	 * A부터 10까지는 1-10까지의 점수, J,Q,K는 0점으로 정해짐
	 * @return
	 */
	public int getScore() {return score;}
	
	/**
	 * card의 값을 출력해줌
	 */
	@Override
	public String toString() {return card.toString();}
	/**
	 * count, suit, number의 index+1 값을 조합하여 리턴함
	 */
	@Override
	public int hashCode() {return 10000+(count+1)*1000+(suit+1)*100+(number+1);	}
	/**
	 * Override 된 hashCode()로 값을 비교함
	 */
	@Override
	public boolean equals(Object obj) {
		CardOne card=(CardOne)obj;
		return hashCode()==card.hashCode();
	}
}
