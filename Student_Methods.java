package hw1;

import java.util.List;

public interface Student_Methods {
	
	public List<String> viewAllCourses();
	public List<String> viewNotFullCourses();
	public List<List<String>> registerCourse();
	public List<List<String>> withdrawCourse();
	public List<String> viewRegisteredCourses();

}
