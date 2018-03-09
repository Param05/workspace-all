package com.singleton;


public class Point {
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	private int x;
	private int y;

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

}
