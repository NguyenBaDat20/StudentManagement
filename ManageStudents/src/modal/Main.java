package modal;

import java.util.ArrayList;

import common.Library;
import view.Menu;

/*
@author Hi
@date Sep 5, 2023
*/

public class Main extends Menu<String>{
	static String[] mc = {"Create Student", "Find and Sort", "Update/Delete","Report","Exit"};
	ArrayList<Student> listStudent = new ArrayList<>();
	Library library = new Library();
	public Main() {
		super("WELCOME TO STUDENT MANAGEMENT", mc);
	}
	public static void main(String[] args) {
		new Main().run();
	}
	@Override
	public void executed(int n) {
		switch (n) {
		case 1: 
			generateStudent();
			String choice;
			if(listStudent.size() >= 10) {
				choice = new Library().getValue("Do you want to continue:(Y/N): ");
				if(library.chooseYesNo(choice)) {
					library.createStudent(listStudent);
				}else {
					System.out.println("Not continue create student");
				}
			}else {
				library.createStudent(listStudent);
			}
			break;
			
		case 2:
			library.findSort(listStudent);
			break;
		case 3:
			library.update_Delete(listStudent);
			break;
		case 4:
			library.reportNewVersion(listStudent);
			break;
		case 5:
			System.exit(0);
		default:
			throw new IllegalArgumentException("Unexpected value: " + n);
		}
	}
	public void generateStudent() {
		listStudent.add(new Student(1, "long", 1, "Java"));
		listStudent.add(new Student(1, "long", 1, "Java"));
		listStudent.add(new Student(1, "long", 1, "Java"));
		listStudent.add(new Student(1, "long", 1, "Java"));
		listStudent.add(new Student(1, "long", 1, "Java"));
		listStudent.add(new Student(1, "long", 1, "Java"));
		listStudent.add(new Student(1, "long", 1, "Java"));
		listStudent.add(new Student(1, "long", 1, "Java"));
		listStudent.add(new Student(1, "long", 1, "Java"));
		listStudent.add(new Student(1, "long", 1, "Java"));

    }
}
