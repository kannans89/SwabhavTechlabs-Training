
public class PrintStackTrace {
	public static void main(String args[]) throws Exception{
		System.out.println("Start of main");
		try {
			m1();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("End of main");
	}
	public static void m1()throws Exception {
		System.out.println("Inside m1");
		m2();
	}
	
	public static void m2() throws Exception{
		System.out.println("Inside m2");
		m3();
	}
	
	public static void m3() throws Exception {
		System.out.println("Inside m3");
		throw new Exception("Error in m3");
	}
}
