package srp.voilation.test;

import srp.voilation.app.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee employee = new Employee(101, "Manoj");
		System.out.println(employee.calculateTax());
		System.out.print(employee.isPromoted());
	}

}
