package java8examples;

public class TimeTaken {
	public static void code(Runnable code) {
		long start = System.nanoTime();
		try {
			code.run();
		} finally {
			long end = System.nanoTime();
			System.out.println("Time Taken" + (end - start) / 1.0e9);

		}
	}
}
