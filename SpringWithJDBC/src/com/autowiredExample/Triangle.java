package com.autowiredExample;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class Triangle {

	@Autowired
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
