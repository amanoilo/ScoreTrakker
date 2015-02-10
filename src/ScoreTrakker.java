import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class ScoreTrakker {
	private ArrayList<Student> students;
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt"};
	void loadDataFromFile(String filename) throws FileNotFoundException
	{
		students = new ArrayList<Student>();
		FileReader reader = new FileReader(filename);
		Scanner scan = new Scanner(reader);
		while (scan.hasNextLine())
		{
			String names = scan.nextLine();
			String points = scan.nextLine();
			try
			{
			int pointsInt = Integer.parseInt(points);
			students.add(new Student(names, pointsInt));

			}
			catch (NumberFormatException e)
			{
				System.out.println("\"" + points + "\" is not a valid score for " + names+".");
				System.out.println();
			}
	
			
		}
	}
	
	void printInOrder()
	{
		Collections.sort(students);
		System.out.println("Students and Scores");
		for(Student i : students)
		{
			System.out.println(i.toString());
		}
		System.out.println();
	}
	
	void processFiles()
	{
		for (String i : files)
		{
			try{
				loadDataFromFile(i);
				printInOrder();
			}
			catch (FileNotFoundException e)
			{
				System.out.println(i + " does not exist in the current directory.");
			}
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ScoreTrakker keeper = new ScoreTrakker();
		keeper.processFiles();
	}

}
