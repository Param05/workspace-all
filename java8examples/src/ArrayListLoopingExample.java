import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListLoopingExample {
	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("Text 1");
		list.add("Text 2");
		list.add("Text 3");

		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		while (iterator.hasNext()) {
			System.out.println("iteraort" + iterator.next());
		}

	}
}