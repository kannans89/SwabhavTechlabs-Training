
public class CustomerDetails {
	public static void printCustomer(Customer c) {
		System.out.println(c.name);
	}
	public static void main(String[] args) {
		Customer c = new Customer(1, 123, "Manoj");
		Customer c1 = new Customer(2, 124, "Manoj");
		Customer c2 = new Customer(3, 125, "Manoj");
		Customer c3 = new Customer(4, 126, "Manoj");
		
		printCustomer(c);
		printCustomer(c1);
		printCustomer(c2);
		printCustomer(c3);
	}
}
