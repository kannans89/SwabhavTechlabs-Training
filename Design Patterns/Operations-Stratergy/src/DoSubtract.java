
public class DoSubtract implements Istratergy {

	@Override
	public int doOperation(int number1, int number2) {
		if(number1 > number2) {
			return number1-number2;
		} else
			return number2-number1;
	}

}
