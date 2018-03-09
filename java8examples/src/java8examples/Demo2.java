package java8examples;

import java.util.Arrays;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Demo2 {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		int result = 0;
		for (int e : numbers) {
			if (e % 2 == 0)
				result += e * 2; // 4,8,12,16
		}
		System.out.println(result);

		System.out.println(
		numbers.stream()
			    .filter(e -> e % 2 == 0)
			    .map(e -> e * 2)
				.reduce(0, Integer::sum));
		
		System.out.println(
				numbers.stream()
					    .filter(e -> e % 2 == 0)
					    .mapToInt(e -> e * 2)
						.sum());
		
		
		
		
		
		TimeTaken.code(()->
		System.out.println(
				 numbers.stream()
				 		.filter(e -> e % 2 == 0)
				 		.mapToInt(Demo2::compute)
				 		.sum()));

		//it will take less time as compare to stream function 
		TimeTaken.code(()->
		System.out.println(
				 numbers.parallelStream()
				 		.filter(e -> e % 2 == 0)
				 		.mapToInt(Demo2::compute).sum()));

	
	
		
	
	
	}
	
	
	
	
	
	
	
	public static int compute(int numbers) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return numbers * 2;

	}
}
