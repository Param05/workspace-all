import org.apache.naming.factory.BeanFactory;
import org.springframework.util.SystemPropertyUtils;

public class EnumTest extends Thread {

	static int count = 0;

	public EnumTest() {
		super("My ");
		start();
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println(A.b);
	}

	public void run() {

		System.out.println(this);
	}
}
enum A{
	a,b,c,d,e;
}
