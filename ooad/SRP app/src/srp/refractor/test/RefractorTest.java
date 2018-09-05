package srp.refractor.test;

import srp.refractor.app.Employee;
import srp.refractor.app.Finance;
import srp.refractor.app.HR;
import srp.refractor.*;

public class RefractorTest {
	public static void main(String[] args) {
		Employee employee = new Employee(101, "abc");
		HR hr = new HR();
		Finance finance = new Finance();
		
		System.out.println(hr.isPromoted(employee));
		System.out.print(finance.calcTax(employee));
	}
}
