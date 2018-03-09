package com;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ArrayListDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("aman");
		list.add("daae");
		Consumer<String> consumer = new ArrayListDemo().new Demo();
		list.forEach(consumer);
		
		//lambda style
		list.forEach(x -> {System.out.println("Processed "+x);});
	}

	class Demo implements Consumer<String> {

		@Override
		public void accept(String t) {
			System.out.println("hiii" + t);
		}
	}
}
