import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FilenotfoundException {
	public void fileNotFound() throws IOException {
		try(FileInputStream fin =new FileInputStream("temp.txt")){
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
