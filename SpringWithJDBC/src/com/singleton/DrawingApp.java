package com.singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
		Triangle triangle = (Triangle) context.getBean("triangle");
		triangle.draw();
		
		
//
//		Point point1 = (Point) context.getBean("zeroPoint");
//
//		Point point2 = (Point) context.getBean("zeroPoint");
//		if (point1 == point2)
//			System.out
//					.println("In Singleton Demo >> Both are same objects values are.."
//							+ "n 1. point1= "
//							+ point1
//							+ " n 2. point2= "
//							+ point2);
//		else
//			System.out
//					.println("In Protptype Demo >> Both are different objects values are.."
//							+ "n 1. point1= "
//							+ point1
//							+ " n 2. point2= "
//							+ point2);
	}

}
