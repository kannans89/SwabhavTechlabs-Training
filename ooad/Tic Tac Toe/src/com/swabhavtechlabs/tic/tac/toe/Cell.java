package com.swabhavtechlabs.tic.tac.toe;

public class Cell {
	Mark mark;

	public Cell() {
		this.mark = Mark.EMPTY;
	}

	public Mark getMark() {
		return this.mark;
	}

	public void setMark(Mark mark) {
		if (mark != Mark.EMPTY)
			this.mark = mark;
	}
	
	public void setMarkToEmpty() {
		this.mark = Mark.EMPTY;
	}
}