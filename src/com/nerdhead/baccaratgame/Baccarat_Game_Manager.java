package com.nerdhead.baccaratgame;

import java.util.LinkedList;

import com.nerdhead.rull.ResultList;
import com.nerdhead.rull.Result_DTO;

public class Baccarat_Game_Manager {
	protected Result_DTO gameResult;
	protected ResultList gameResultList;
	
	public Baccarat_Game_Manager() {
		init();
	}
	
	protected void init() {
		gameResultList=new ResultList();
	}
	
	
	/**
	 * 게임을 룰대로 진행 하고 승패 결과만 가져 올 수 있음
	 */
	public void start() {
		
	}
	

	
}
