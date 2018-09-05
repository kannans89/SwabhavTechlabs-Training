package com.tic.tac.toe;

public class Player {
	private Mark mark;
	private String name;
	
	public Player() {}
	
	public Player(Mark mark, String name) {
		this.mark = mark;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Mark getMark() {
		return mark;
	}

	public void setMark(Mark mark) {
		this.mark = mark;
	}
}
