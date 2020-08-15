package com.nerdhead.rull;
/**
 * @since 2020.08.15
 * @author nerdhead
 * result에 담는 값은 Result.PLAYER_WIN, BANKER_WIN, TIE
 */
public class Result_DTO implements Result{
	private int result;
	private boolean player_pair=false;
	private boolean banker_pair=false;
	private boolean lucky6_1=false;
	private boolean lucky6_2=false;
	
	//GETTER
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
	
	
	//SETTER
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
