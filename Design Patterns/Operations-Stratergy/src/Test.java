
public class Test {

	public static void main(String[] args) {
		Context context = new Context();
		DoAddition add = new DoAddition();
		context.setStratergy(add);
		System.out.println("Addition "+context.executeStratergy(5, 8));
		context.setStratergy(new DoSubtract());
		System.out.println("Subtraction "+context.executeStratergy(5, 8));
		context.setStratergy(new DoMultiplication());
		System.out.println("Multiplication "+context.executeStratergy(5, 8));
	}

}
