import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class ScoreTrakker {
	private ArrayList<Student> students;
	
	void loadDataFromFile(String filename) throws FileNotFoundException
	{
		students = new ArrayList<Student>();
		FileReader reader = new FileReader(filename);
		Scanner scan = new Scanner(reader);
		while (scan.hasNextLine())
		{
			String names = scan.nextLine();
			String points = scan.nextLine();
			int pointsInt = Integer.parseInt(points);
			students.add(new Student(names, pointsInt));
			
		}
	}
	
	void printInOrder()
	{
		Collections.sort(students);
		for(Student i : students)
		{
			System.out.println(i.toString());
		}
	}
	
	void processFiles() throws Exception
	{
		loadDataFromFile("scores.txt");
		printInOrder();
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ScoreTrakker keeper = new ScoreTrakker();
		keeper.processFiles();
	}

}
