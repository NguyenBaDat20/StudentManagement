/*
@author Hi
@date Sep 5, 2023
*/
package modal;

public class Report {
	private String name;
	private String courseName;
	private int totalCourse;
	public Report() {
	}
	
	public Report(String name, String courseName, int totalCourse) {
		super();
		this.name = name;
		this.courseName = courseName;
		this.totalCourse = totalCourse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getTotalCourse() {
		return totalCourse;
	}

	public void setTotalCourse(int totalCourse) {
		this.totalCourse = totalCourse;
	}

	@Override
	public String toString() {
		return "Report [name=" + name + ", courseName=" + courseName + ", totalCourse=" + totalCourse + "]";
	}
	
	
}
