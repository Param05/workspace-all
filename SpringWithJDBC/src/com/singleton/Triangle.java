package com.singleton;


public class Triangle {

	private Point point;

	public Point getPointA() {
		return point;
	}

	public void setPointA(Point pointA) {
		this.point = pointA;
	}

	public void draw() {
		System.out.println("PointA is (" + point.getX() + ", " + point.getY()
				+ ")");
	}

}
