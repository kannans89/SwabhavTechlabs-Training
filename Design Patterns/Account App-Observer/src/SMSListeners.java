
public class SMSListeners implements IListener {
	public void sendSMS(String type, double balance) {
		System.out.println("SMS:After performing " + type + " new balance is " + balance);
	}

	@Override
	public void balanceChanged(Account account, String type) {
		sendSMS(type, account.getBalance());
	}
}
