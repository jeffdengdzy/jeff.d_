package hw1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends User implements Admin_Methods{
	
	protected List<List<String>> courselist; 
	protected List<List<String>> course_display = new ArrayList<List<String>>(); 
	protected List<List<String>> view_courses = new ArrayList<List<String>>(); 
	protected List<List<String>> view_full_courses = new ArrayList<List<String>>(); 
	protected String namelist = null;
	protected List<String> registered_courses = new ArrayList<>();
	protected List<List<String>> sorted_courses = new ArrayList<List<String>>();
	
	
	protected Admin() {
		user_list = super.user_list; 
		courselist = super.courselist;
	}
	
	protected Admin(List<List<String>> course_list) {
		this.courselist = course_list; 
	}
    @Override
	public boolean login() {
	   username = "Admin"; 
	   password = "Admin001"; 
	   List<String> courselist = new ArrayList<>(); 
	   boolean dummy = false; 
	   
	   Scanner inprint = new Scanner (System.in);
		
	   System.out.println("Enter your username: ");
	   String username_input = inprint.nextLine();
		
	   System.out.println("Enter your password: ");
	   String password_input = inprint.nextLine();
	   
	   if (username.equals(username_input)) {
			if (password.equals(password_input)) {
				dummy = true; 
			}
       }
	   return dummy; 
    }
    
    @Override
    public List<List<String>> signup() {
    	System.out.println("Error, we only contain one username and one password for the administrator. ");
		return course_display;
    }

	
	public List<List<String>> createCourse() {
		Scanner inprint = new Scanner (System.in);
		List<String> new_course_info = new ArrayList<>(); 
		
		System.out.println("Create a New Course: ");
		System.out.println("Enter the New Course Name: ");
		String course_name = inprint.nextLine();
		new_course_info.add(course_name); 
		
		System.out.println("Enter the Course ID: ");
		String course_id = inprint.nextLine();
		new_course_info.add(course_id); 
		
		System.out.println("Enter the maximum student number: ");
		String max_num = inprint.nextLine();
		new_course_info.add(max_num); 
		
		String current_num = Integer.toString(0); 
		new_course_info.add(current_num); 
		
		String namelist = null; 
		new_course_info.add(namelist); 
		
		System.out.println("Enter the course instructor's name: ");
		String instructor = inprint.nextLine();
		new_course_info.add(instructor); 
		
		System.out.println("Enter the course's section number: ");
		String section = inprint.nextLine();
		new_course_info.add(section); 
		
		System.out.println("Enter the course's location: ");
		String location = inprint.nextLine();
		new_course_info.add(location); 
		
		courselist.add(new_course_info); 
		
		return courselist; 
	}
	
	public List<List<String>> deleteCourse() {
		Scanner inprint = new Scanner (System.in);
		
		System.out.println("Delete the course"); 
		System.out.println("Enter the course name for deletion: ");
		String course_name = inprint.nextLine();
		
		System.out.println("Enter the course section for deletion: ");
		String section = inprint.nextLine();
		
		for (int i = 0; i < courselist.size(); i++) {
			 if (course_name.equals(courselist.get(i).get(0)) & 
				 section.equals(courselist.get(i).get(6))) {
				     courselist.remove(i); 
			 }
		}
		return courselist; 
	}
	
	public List<List<String>> editCourse() {
		
        Scanner inprint = new Scanner (System.in);
		
		System.out.println("Edit the course"); 
		System.out.println("Enter the course name for edition: ");
		String course_name = inprint.nextLine();
		
		System.out.println("Enter the course section for edition: ");
		String section = inprint.nextLine(); 
		
		System.out.println("Which piece of information do you want to edit? ");; 
		System.out.println("Enter 1 for maximum student number"); 
		System.out.println("Enter 2 for current student number"); 
		System.out.println("Enter 3 for the name list"); 
		System.out.println("Enter 4 for the course instructor"); 
		System.out.println("Enter 5 for course section number"); 
		System.out.println("Enter 6 for course location: "); 
		String choice_str = inprint.nextLine(); 
		int choice = Integer.parseInt(choice_str); 
		
		System.out.println("Enter the textual information that you want to edit to: "); 
		String edit_to = inprint.nextLine(); 
		
		for (int i = 0; i < courselist.size(); i++) {
			 if (course_name.equals(courselist.get(i).get(0)) & 
				 section.equals(courselist.get(i).get(6))) {
				 if (choice == 1) {
					 courselist.get(i).set(2,edit_to); 
				 }
				 if (choice == 2) {
					 courselist.get(i).set(3,edit_to); 
				 }
				 if (choice == 3) {
					 courselist.get(i).set(4,edit_to); 
				 }
				 if (choice == 4) {
					 courselist.get(i).set(5,edit_to); 
				 }
				 if (choice == 5) {
					 courselist.get(i).set(6,edit_to); 
				 }
				 if (choice == 6) {
					 courselist.get(i).set(7,edit_to); 
				 }
			 }
		}
		return courselist; 
	}
	
	public List<List<String>> displayInfo() {
		Scanner inprint = new Scanner (System.in);
		
		System.out.println("Enter course ID (the last four digit number) for displayment: ");
		String course_id = inprint.nextLine();
		
		for (int i = 0; i < courselist.size(); i++) {
		    if (courselist.get(i).get(1).contains(course_id)) {
		    	course_display.add(courselist.get(i)); 
		    }
		}
		return course_display; 
	}
	
	public List<List<String>> registerStudent() {
		Scanner inprint = new Scanner (System.in);
		System.out.println("Enter the name of the student to be registered: ");
		String full_name = inprint.nextLine();
	    
	    System.out.println("Enter the course name for registration: ");
		String course_name = inprint.nextLine();
		System.out.println("Enter the course section for registration: ");
		String section = inprint.nextLine(); 
		
		for (int i = 0; i < courselist.size(); i++) {
			 if (course_name.equals(courselist.get(i).get(0)) & 
				 section.equals(courselist.get(i).get(6))) {
				 courselist.get(i).set(4, courselist.get(i).get(4).replaceAll("NULL", "")); 
				 courselist.get(i).set(4, courselist.get(i).get(4) + full_name + ", "); 
			 }
		}
		return courselist; 
	}
	
	public List<List<String>> viewAllCourses() {
		for (int i = 0; i < courselist.size(); i++) {
			List<String> view_courses_line = new ArrayList<>();
			for (int j = 0; j < 4; j++) { 
				view_courses_line.add(courselist.get(i).get(j));
			}
			view_courses.add(view_courses_line); 
		}
		return view_courses; 
	}
	
	public List<List<String>> viewAllFullCourses() {
		for (int i = 0; i < courselist.size(); i++) {
			if (courselist.get(i).get(2).equals(courselist.get(i).get(3))) {
			    List<String> view_courses_line = new ArrayList<>();
			    for (int j = 0; j < 4; j++) { 
				    view_courses_line.add(courselist.get(i).get(j));
		        }
			    view_full_courses.add(view_courses_line); 
			}
		}
		return view_full_courses; 
	}
	
	public void fullOutputFile() throws FileNotFoundException {
		viewAllFullCourses(); 
		try (PrintWriter out = new PrintWriter("full_courses.txt")) {
			for (int i = 0; i < view_full_courses.size(); i++) {
			    out.println(view_full_courses.get(i).get(0) + "\t");
			}
		}
	}
	
	public String studentNameLookUp() { 
		Scanner inprint = new Scanner (System.in);
		System.out.println("Enter the course name for look up: ");
		String course_name = inprint.nextLine();
		System.out.println("Enter the course section for look up: ");
		String section = inprint.nextLine(); 
		
		for (int i = 0; i < courselist.size(); i++) {
			 if (course_name.equals(courselist.get(i).get(0)) & 
				 section.equals(courselist.get(i).get(6))) {
				 namelist = courselist.get(i).get(4); 
			 }
		}
		return namelist; 
	}
	
	public List<String> studentRegisteredCoursesLookUp() {
		Scanner inprint = new Scanner (System.in);
		System.out.println("Enter the name of the student to look up registered courses: ");
		String full_name = inprint.nextLine();
		
		for (int i = 0; i < courselist.size(); i++) {
			if (courselist.get(i).get(4).contains(full_name)) {
				registered_courses.add(courselist.get(i).get(0)); 
		    }
		}
		return registered_courses; 
	}
	
	public List<List<String>> sortCurrentNumber() { 
		for (int j = 999; j >= 0; j--) {
			for (int i = 0; i < courselist.size(); i++) {
				if (courselist.get(i).get(3).equals(Integer.toString(j))) {
					sorted_courses.add(courselist.get(i)); 
				}
			}
		}
		return sorted_courses; 
	}
}
