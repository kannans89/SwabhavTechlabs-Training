
public class CurrentThread {
	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println("Name: "+t.getName());
		
		t.setName("Name changed: My thread");
		
		System.out.println(t.getName());
		
		try {
			for(int i=5; i>0; i--) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}	
