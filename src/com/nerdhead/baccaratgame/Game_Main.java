package com.nerdhead.baccaratgame;

public class Game_Main {

	public static void main(String[] args) {
//		new Baccarat_Game().start();
		Baccarat_Game_Manager bgm=new Baccarat_Game_Manager();
		bgm.start();
		bgm.test_printResult();
	}

}
