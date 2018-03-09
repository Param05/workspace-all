package com;

public class OddNumbers {
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder("snorkler");
		StringBuilder builder1 = new StringBuilder("yoodler");
		builder.append(builder1.substring(2, 5).toUpperCase());
		
		//builder1.insert(3, builder.append("a"));
		System.out.println(builder);
		String builder2 = builder1.substring(2, 5);// es nae substring kyu ni
													// kdi
		System.out.println(builder);
		System.out.println(builder2);

	}

}
