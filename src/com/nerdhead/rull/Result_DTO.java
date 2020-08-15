package com.nerdhead.rull;
/**
 * @since 2020.08.15
 * @author nerdhead
 * result에 담는 값은 Result Interface에 PLAYER_WIN, BANKER_WIN, TIE 상수로 받아 쓸 것<br>
 */
public class Result_DTO implements Result{
	private int result;
	private boolean player_pair=false;
	private boolean banker_pair=false;
	private boolean lucky6_1=false;
	private boolean lucky6_2=false;
	
	//각각의 값이 따로 판정되서 set 되므로 생성자에서 한번에 결정될 일이 아님
//	public Result_DTO(int result,boolean player_pair,boolean banker_pair,
//			boolean lucky6_1,boolean lucky6_2) {
//		this.result=result;
//		this.player_pair=player_pair;
//		this.banker_pair=banker_pair;
//		this.lucky6_1=lucky6_1;
//		this.lucky6_2=lucky6_2;
//	}
	
	
	/**GETTER*/
	public int getResult() {
		return result;
	}
	public boolean isPlayer_pair() {
		return player_pair;
	}
	public boolean isBanker_pair() {
		return banker_pair;
	}
	public boolean isLucky6_1() {
		return lucky6_1;
	}
	public boolean isLucky6_2() {
		return lucky6_2;
	}
	
	/**SETTER*/
	public void setResult(int result) {
		this.result = result;
	}
	public void setPlayer_pair(boolean player_pair) {
		this.player_pair = player_pair;
	}
	public void setBanker_pair(boolean banker_pair) {
		this.banker_pair = banker_pair;
	}
	public void setLucky6_1(boolean lucky6_1) {
		this.lucky6_1 = lucky6_1;
	}
	public void setLucky6_2(boolean lucky6_2) {
		this.lucky6_2 = lucky6_2;
	}
	
}
