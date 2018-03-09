package java8examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Demo3 {
	static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
	static int result = 0;
	 

//	public static int performaceTest() {
//		for (int i : numbers) {
//			if (i > 3 && i % 2 == 0) {
//				result = i * 2;
//				break;
//			}
//		}
//		return result;
//	}
//
//	public static void secondWay() {
//		System.out.println(numbers.stream()
//				.filter(e -> e > 3)
//				.filter(e -> e%2==0)
//				.map(e -> e*2)
//				.findFirst());
//	}
	
	static Function<Integer, Integer> func=new Function<Integer, Integer>() {

		@Override
		public Integer apply(Integer t) {
			return new Demo3().doubleIT(t);
		}
	};

	public static void thirdWay() {
		
		Supplier<String> s;
		
		
		numbers.stream()
				.filter(Demo3::isGT3)
				.filter(Demo3::isEven)
				.peek(r -> {
					System.out.println("Value of r"+ r);
				})
				.map(Demo3.func::apply)

				
				//.map(f::apply)
			
//				.map(r -> {
//					return new Demo3().doubleIT(r);
//				})
				.forEach(System.out::println);
		
	}
	
	
	public static boolean isGT3(int numbers ) {
		return numbers>3;
	}
	public static boolean isEven(int numbers ) {
		return numbers%2==0;
	}

	public Integer doubleIT(Integer numbers ) {
		return numbers*2;
	}
	
//	public static Function<Integer, Integer> callFunc(Integer numbers) {
//		return func;
//	}
	

	public static void main(String[] args) {
		thirdWay();
		//int test = performaceTest();
		//System.out.println(test);
	}
}
