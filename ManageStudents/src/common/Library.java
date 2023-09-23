/*
@author Hi
@date Aug 30, 2023
*/
package common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

import modal.Report;
import modal.Student;

public class Library {
	Scanner sc = new Scanner(System.in);

	public String getValue(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}

	public int getIntForMenu(String msg, int m, int n) {
		int a = -1;
		while (true) {
			System.out.print(msg);
			try {
				a = Integer.parseInt(sc.nextLine());
				if (a >= m && a <= n) {
					break;
				}
			} catch (Exception e) {
				System.out.println("Please enter a number between " + m + " and " + n);
			}
		}
		return a;
	}

	public int getInteger(String msg) {
		int a = -1;
		while (true) {
			System.out.print(msg);
			try {
				a = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Only input number");
				continue;
			}
			break;
		}
		return a;
	}

	public double getDouble(String msg) {
		double a = -1;
		while (true) {
			System.out.print(msg);
			try {
				a = Double.parseDouble(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Only input float number");
				continue;
			}
			break;
		}
		return a;
	}

	public int generateID(ArrayList<Student> listStudent) {
		int id = 0;
		if (listStudent.size() == 0) {
			return 1;
		} else {
			id = listStudent.size() + 1;
		}
		return id;
	}
	
	public boolean chooseYesNo(String choice) {
		boolean result = false;
		while(true) {
			if(choice.equalsIgnoreCase("y")) {
				return true;
			}else if(choice.equalsIgnoreCase("n")) {
				return false;
			}else {
				String temp = new Library().getValue("Just only choice Yes or No");
				 result = chooseYesNo(temp);
				return result;
			}
		}
	}
	
	public void createStudent(ArrayList<Student> listStudent) {
		int id = getInteger("Enter student ID: ");
		String name = getValue("Enter student name: ");
		int semester = getInteger("Enter semester: ");
		String courseName = getValue("Enter course name: ");

		Student student = new Student(id, name, semester, courseName);
		listStudent.add(student);
	}

	public void displayStudent(ArrayList<Student> listS) {
		for (Student s : listS) {
			System.out.println(s);
		}
	}

	public void findSort(ArrayList<Student> listStudent) {
		ArrayList<Student> temp = listByName(listStudent);
		if (listStudent == null) {
			System.err.println("List empty");
			return;
		}
		if (temp.isEmpty()) {
			System.err.println("Not exist");
		} else {
			Collections.sort(temp);
			displayStudent(temp);
		}
	}

	public ArrayList<Student> listByName(ArrayList<Student> list_s) {
		ArrayList<Student> list_Found = new ArrayList<>();
		String name = getValue("Enter name to search: ");
		for (Student student : list_s) {
			if (student.getName().contains(name)) {
				list_Found.add(student);
			}
		}
		return list_Found;
	}

	public void update_Delete(ArrayList<Student> listStudent) {
		int id = getInteger("Enter id to search: ");
		ArrayList<Student> listId = listById(listStudent, id);
		if (listStudent == null) {
			System.err.println("List empty");
		}
		if (listId.isEmpty()) {
			System.err.println("Not exist");
		} else {
			System.out.println("Do you want to update or delete?");
			System.out.println("1.Update");
			System.out.println("2.Delete");
			int c = getInteger("Enter choice: ");
			Student s = listId.get(0);
			while (true) {
				switch (c) {
				case 1:
					
					s.setName(getValue("Enter name to update: "));
					s.setSemester(getInteger("Enter semester: "));
					s.setCourseName(getValue("Enter course name: "));
					System.out.println("Update Success");
					return;
				case 2:
					listStudent.remove(s);
					System.out.println("Delete success"); 		
					return;
				default:
					System.err.println("Not valid");
					continue;
				}
			}

		}
	}

	public ArrayList<Student> listById(ArrayList<Student> list_s, int id) {
		ArrayList<Student> list_Found = new ArrayList<>();
		for (Student student : list_s) {
			if (student.getId() == id) {
				list_Found.add(student);
			}
		}
		return list_Found;
	}
	
	public void reportNewVersion(ArrayList<Student> students) {
		HashMap<String, Integer> reports = new HashMap<>();
        for (Student student : students) {
            String key= student.getId()+"#"+student.getName()+"|"+student.getCourseName();
            if(reports.containsKey(key)){
                int total= reports.get(key);
                reports.put(key, total+1);
            }else{
                 reports.put(key, 1);
            }

        }
        for (String key : reports.keySet()) {
            System.out.println(key.split("#")[1]+"|"+reports.get(key));
        }
	}
	
}
