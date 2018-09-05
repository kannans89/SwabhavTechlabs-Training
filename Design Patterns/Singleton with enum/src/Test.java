
public class Test {
	public static void main(String[] args) {
		Singleton singletonInstance = Singleton.INSTANCE;
		
		System.out.println(singletonInstance.getValue());
		singletonInstance.setValue(5);
		System.out.println(singletonInstance.getValue());
		Singleton singletonInstance2 = Singleton.INSTANCE;
		System.out.println(singletonInstance2.getValue());
	}
}
