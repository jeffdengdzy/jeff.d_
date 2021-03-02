package hw1;

import java.io.FileNotFoundException;
import java.util.List;

public interface Admin_Methods {
	
	public List<List<String>> createCourse(); 
	public List<List<String>> deleteCourse(); 
	public List<List<String>> editCourse();
	public List<List<String>> displayInfo();
	public List<List<String>> registerStudent();
	public List<List<String>> viewAllCourses();
	public List<List<String>> viewAllFullCourses();
	public void fullOutputFile() throws FileNotFoundException;
	public String studentNameLookUp();
	public List<String> studentRegisteredCoursesLookUp();
	public List<List<String>> sortCurrentNumber();
	public boolean login();
	public List<List<String>> signup(); 

}
