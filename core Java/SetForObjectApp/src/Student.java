
public class Student implements Comparable<Student>{
	private int id;
	private String name;
	Student(int id, String name){
		this.id = id;
		this.name = name;
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
	@Override
	public int compareTo(Student o) {
		if (this.id == o.getId()) {
            return 0;
        } else if (this.id < o.getId()) {
            return -1;
        }
        return 1;
	}
	
}
