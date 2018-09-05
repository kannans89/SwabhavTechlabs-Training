
public class DivisionByZero {
	int[] array = {0};
	public void divisionByZero() throws Exception{
		try{
			//int d = array[10];
			//double val = Double.parseDouble("1m");
			System.out.println(45/array[0]);
		}catch(ArithmeticException e) {
			e.printStackTrace();
		}
	}
}
