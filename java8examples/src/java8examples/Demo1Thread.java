package java8examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Demo1Thread {
	public static void main(String[] args) {
		// simple way two make thread
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("In other thread");
			}
		});
		thread.start();

		// lambda expression
		// method name is annoynomous
		// return type is inferred
		Thread thread1 = new Thread(() -> System.out.println("In other thread"));
		thread1.start();

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers);
		}

		for (Integer integer : numbers) {
			System.out.println(integer);
		}

		numbers.forEach(new Consumer<Integer>() {
			public void accept(Integer value) {
				System.out.println(value);
			}
		});

		numbers.forEach((Integer value) -> System.out
				.println("java 8:" + value));

		// java 8 provide type reference with lambda expression
		numbers.forEach((value) -> System.out.println("java 8:" + value));
		numbers.forEach(System.out::println);
	}

	public void add() {

	}
}
