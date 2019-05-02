package containers;

// Demonstrates the "fail-fast" behavior.
import java.util.*;

public class FailFast {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		Iterator<String> it = c.iterator();// 取得迭代器时的状态已经记录,是状态1
		c.add("An object");// 又加了东西,是状态2
		try {
			if (it.hasNext()) {
				String s = it.next();
			}
		} catch (ConcurrentModificationException e) {
			System.out.println(e);
		}
	}
} /*
	 * Output: java.util.ConcurrentModificationException
	 */// :~
