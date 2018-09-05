
public class NullpointerException {
	public void nullPointer() {
		String str = null;
		try {
			if(str.equals("manu")) {
				System.out.println("same");
			}
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
	}
}
