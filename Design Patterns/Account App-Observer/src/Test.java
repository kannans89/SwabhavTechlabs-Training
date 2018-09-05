import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<IListener> listeners = new ArrayList<>();
		listeners.add(new SMSListeners());
		listeners.add(new EmailListeners());
		Account account1 = new Account(111, "Manoj", 15000, listeners);
		Account account2 = new Account(112, "Shubham", 2500, listeners);
		
		account1.withDraw(500);
		
		account2.deposit(5000);

	}
}
