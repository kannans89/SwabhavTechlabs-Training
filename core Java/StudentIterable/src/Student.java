
public class Student {
	private int id;
	private String name;
	public static int noStudents = 0;
	
	Student(int id, String name){
		this.id= id;
		this.name = name;
		noStudents++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
