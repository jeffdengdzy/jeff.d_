package hw1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends User implements Student_Methods{
	protected List<List<String>> courselist;
	protected List<String> all_courses = new ArrayList<>(); 
	protected List<String> unfull_courses = new ArrayList<>(); 
	protected List<String> registered_courses = new ArrayList<>();
	
	public Student() {
		courselist = super.courselist; 
		user_list = super.user_list; 
	}

	public Student(List<List<String>> course_list) {
		this.courselist = course_list; 
	}
	
	public Student(List<List<String>> user_list, 
			List<List<String>> course_list) {
		this.user_list = user_list; 
		this.courselist = course_list; 
	}
	
	public List<String> viewAllCourses() {
		for (int i = 0; i < courselist.size(); i++) {
			all_courses.add(courselist.get(i).get(0)); 
	    }
		return all_courses; 
	}
	
	public List<String> viewNotFullCourses() {
		for (int i = 0; i < courselist.size(); i++) {
			if (courselist.get(i).get(2).equals(courselist.get(i).get(3)) == false) {
				unfull_courses.add(courselist.get(i).get(0)); 
			}
	    }
		return unfull_courses; 
	}
	
	public List<List<String>> registerCourse() {
		boolean dummy = true; 
		for (int i = 0; i < courselist.size(); i++) {
		    if (courselist.get(i).get(2).equals(courselist.get(i).get(3))) {
			    System.out.print("The course is full. You can no longer register this course. ");
			    dummy = false; 
		    }
		}
		if (dummy) {
		   Scanner inprint = new Scanner (System.in);
		   System.out.println("Course Registration");
		   System.out.println("Enter the course name you want to register: ");
		   String course_name = inprint.nextLine();
		   System.out.println("Enter the course section number you select: ");
		   String course_section = inprint.nextLine();
		   System.out.println("Enter your first name");
		   first_name = inprint.nextLine();
		   System.out.println("Enter your last name");
		   last_name = inprint.nextLine();
		   String full_name = first_name + " " + last_name; 
		   for (int i = 0; i < courselist.size(); i++) {
			   if (course_name.equals(courselist.get(i).get(0)) & 
					   course_section.equals(courselist.get(i).get(6))) {
				   courselist.get(i).set(4, courselist.get(i).get(4).replaceAll("NULL", "")); 
				   courselist.get(i).set(4, courselist.get(i).get(4) + full_name + ", "); 
				   int class_size = Integer.parseInt(courselist.get(i).get(3)) + 1;
				   courselist.get(i).set(3, Integer.toString(class_size)); 
			   }
		   }
	    }
		return courselist;
	}
	
	public List<List<String>> withdrawCourse() {
		Scanner inprint = new Scanner (System.in);
		System.out.println("Course Withdrawal");
		System.out.println("Enter the course name you want to withdraw: ");
		String course_name = inprint.nextLine();
		System.out.println("Enter your first name");
		first_name = inprint.nextLine();
		System.out.println("Enter your last name");
		last_name = inprint.nextLine();
		String full_name = first_name + " " + last_name; 
		for (int i = 0; i < courselist.size(); i++) {
			 if (course_name.equals(courselist.get(i).get(0)) & 
			     courselist.get(i).get(4).contains(full_name)) {
				     courselist.get(i).set(4, courselist.get(i).get(4).replaceAll(full_name + ", ", ""));  
				     int class_size = Integer.parseInt(courselist.get(i).get(3)) - 1;
				     courselist.get(i).set(3, Integer.toString(class_size)); 
		     }
		}
        return courselist; 
  	}
	
	public List<String> viewRegisteredCourses() { 
		String full_name = first_name + " " + last_name; 
		for (int i = 0; i < courselist.size(); i++) {
		    	if (courselist.get(i).get(4).contains(full_name)) {
		    		registered_courses.add(courselist.get(i).get(0)); 
		    }
		}
		return registered_courses; 
	}
}
