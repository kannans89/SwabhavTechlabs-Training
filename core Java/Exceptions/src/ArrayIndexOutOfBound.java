
public class ArrayIndexOutOfBound {
	int[] array = new int[6];
	public void indexOutOfBound() {
		try{
			array[8] = 9;
		}catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
}
