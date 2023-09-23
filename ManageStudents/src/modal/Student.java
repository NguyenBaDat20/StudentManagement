/*
@author Hi
@date Sep 5, 2023
*/
package modal;

import java.util.Objects;

public class Student implements Comparable<Student>{
	private int id;
	private String name;
	private int semester;
	private String courseName;
	
	
	public Student() {}


	public Student(int id, String name, int semester, String courseName) {
		super();
		this.id = id;
		this.name = name;
		this.semester = semester;
		this.courseName = courseName;
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


	public int getSemester() {
		return semester;
	}


	public void setSemester(int semester) {
		this.semester = semester;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", semester=" + semester + ", courseName=" + courseName + "]";
	}


	@Override
	public int compareTo(Student o) {
		
		return o.name.compareTo(this.name);
	}


	
	
}
