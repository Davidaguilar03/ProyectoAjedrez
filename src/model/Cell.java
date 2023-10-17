package model;

public class Cell {
	int x;
	int y;
	char type;
	int score;
	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Cell(int x, int y, char type, int score) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.score = score;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
