
public class Context {
	Istratergy stratergy;
	
	public int executeStratergy(int number1, int number2) {
		return stratergy.doOperation(number1, number2);
	}
	
	public void setStratergy(Istratergy stratergy) {
		this.stratergy = stratergy;
	}
}
