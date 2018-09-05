package srp.voilation.app;

public class Employee {
	private int id;
	private String name;
	private boolean isPromoted = true;;
	private double tax = 25000;
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public boolean isPromoted() {
		return this.isPromoted;
	}
	
	public double calculateTax() {
		return tax;
	}
}
