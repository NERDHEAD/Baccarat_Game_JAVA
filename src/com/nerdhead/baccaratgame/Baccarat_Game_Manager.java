package com.nerdhead.baccaratgame;

import java.util.LinkedList;

import com.nerdhead.rull.Result_DTO;

public class Baccarat_Game_Manager {
	Result_DTO gameResult;
	LinkedList<Result_DTO> gameResultList;
	
	public Baccarat_Game_Manager() {
		init();
	}
	
	private void init() {
		gameResultList=new LinkedList<Result_DTO>();
	}
	
	
	/**
	 * 게임을 룰대로 진행 하고 승패 결과만 가져 올 수 있음
	 */
	public void start() {
		
	}
	

	
}
