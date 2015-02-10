
public class Student implements Comparable<Student> {
	private String name;
	private int score;
	
	public Student(String text, int number) {
		name = text;
		score = number;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Student compTo) {
		// TODO Auto-generated method stub
		int order = name.compareTo(compTo.name);
		return order;
	}

	@Override
	public String toString() {
		return name + " " + score;
	}
	
}
