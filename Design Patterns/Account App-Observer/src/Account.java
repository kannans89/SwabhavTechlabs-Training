import java.util.List;

public class Account {
	private int account_no;
	private String name;
	private List<IListener> listeners;
	private double balance;

	public Account(int ac_no, String name, double balance, List<IListener> listeners) {
		this.account_no = ac_no;
		this.name = name;
		this.listeners = listeners;
		this.balance = balance;
	}

	public void withDraw(double amount) {
		this.balance -= amount;
		update();
	}
	
	public int getAccount_no() {
		return account_no;
	}

	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<IListener> getListeners() {
		return listeners;
	}

	public void setListeners(List<IListener> listeners) {
		this.listeners = listeners;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void deposit(double amount) {
		this.balance = this.balance + amount;
		update();
	}
	
	public void update() {
		System.out.println("Name: "+this.getName());
		for(IListener listener: listeners) {
			listener.balanceChanged(this, "withdraw");
		}
		System.out.println();
	}
}
