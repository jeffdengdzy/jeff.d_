package hw1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class MainClass extends Input{
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner inprint = new Scanner (System.in);
		System.out.println("Welcome to our course registration system! ");
		System.out.println("Are you a student or an administrator? ");
		System.out.println("Enter 1 if you're a student");
		System.out.println("Enter 2 if you're a administrator: ");
		String identity = inprint.nextLine();
		if (Integer.parseInt(identity) == 1) {
			Student student = new Student(); 
			System.out.println("Enter 1 to sign up");
			System.out.println("Enter 2 to log in");
			String maneuver = inprint.nextLine(); 
			if (Integer.parseInt(maneuver) == 1) {
				student.signup(); 
			}
			if (Integer.parseInt(maneuver) == 2) {
				if (student.login(student.user_list))  {
					System.out.println("You just logged in! What step do you want to do next? ");
					boolean quit = false; 
				    do {
				        System.out.println("Select the next action"); 
				        System.out.println("Enter 1 to view all courses"); 
				        System.out.println("Enter 2 to veiw all courses that are not full"); 
				        System.out.println("Enter 3 to register on a course"); 
				        System.out.println("Enter 4 to withdraw from a course"); 
				        System.out.println("Enter 5 to view all courses that the current student is being registered in"); 
				        System.out.println("Enter 6 to quit: ");
				        String studentchoice = inprint.nextLine();
				        if (Integer.parseInt(studentchoice) == 1) {
							student.viewAllCourses(); 
							for (int i = 0; i < student.all_courses.size(); i++) {
								System.out.println(student.all_courses.get(i)); 
							}
						}
				        if (Integer.parseInt(studentchoice) == 2) {
							student.viewNotFullCourses(); 
							for (int i = 0; i < student.unfull_courses.size(); i++) {
								System.out.println(student.unfull_courses.get(i)); 
							}
						}
				        if (Integer.parseInt(studentchoice) == 3) {
							student.registerCourse(); 
							for (int i = 0; i < student.courselist.size(); i++) {
								System.out.println(student.courselist.get(i)); 
							}
						}
				        if (Integer.parseInt(studentchoice) == 4) {
							student.withdrawCourse(); 
							for (int i = 0; i < student.courselist.size(); i++) {
								System.out.println(student.courselist.get(i)); 
							}
						}
				        if (Integer.parseInt(studentchoice) == 5) {
							student.viewRegisteredCourses(); 
							for (int i = 0; i < student.registered_courses.size(); i++) {
								System.out.println(student.registered_courses.get(i)); 
							}
						}
				        if (Integer.parseInt(studentchoice) == 6) {
							System.out.println("You're quitting the system. "); 
							try{     
								  FileOutputStream fout=new FileOutputStream("course_list.txt");  
								  ObjectOutputStream out=new ObjectOutputStream(fout);  
								  out.writeObject(student.courselist);  
								  out.flush();  
								  out.close();  
								  System.out.println("Your updates have been saved and serialized. ");  
								  }catch(Exception e){System.out.println(e);}
							quit = true; 
						}
				        
				    }while (quit == false); 
				}
				else {
					System.out.println("Failed! Your userword and password don't match. ");
				}
			}
		}
		if (Integer.parseInt(identity) == 2) {
			Admin admin = new Admin(); 
			System.out.println("Please Log in");
			if (admin.login()) {
				System.out.println("You just logged in! What step do you want to do next? ");
			    System.out.println("Enter 1 for course management"); 
			    System.out.println("Enter 2 for reports: "); 
			    String adminchoice1 = inprint.nextLine(); 
			    if (Integer.parseInt(adminchoice1) == 1) {
				    boolean quit = false; 
				    do {
				    System.out.println("Select the next action"); 
				    System.out.println("Enter 1 to create a new course"); 
				    System.out.println("Enter 2 to delete a course"); 
				        System.out.println("Enter 3 to edit a course"); 
				        System.out.println("Enter 4 to display information for a given course"); 
				        System.out.println("Enter 5 to register a student"); 
				        System.out.println("Enter 6 to quit: ");
				        String adminchoice2 = inprint.nextLine(); 
					if (Integer.parseInt(adminchoice2) == 1) {
						admin.createCourse(); 
						for (int i = 0; i < admin.courselist.size(); i++) {
							System.out.println(admin.courselist.get(i)); 
						}
					}
					if (Integer.parseInt(adminchoice2) == 2) {
						admin.deleteCourse(); 
						for (int i = 0; i < admin.courselist.size(); i++) {
							System.out.println(admin.courselist.get(i)); 
						}
					}
					if (Integer.parseInt(adminchoice2) == 3) {
						admin.editCourse(); 
						for (int i = 0; i < admin.courselist.size(); i++) {
							System.out.println(admin.courselist.get(i)); 
						}
					}
					if (Integer.parseInt(adminchoice2) == 4) {
						admin.displayInfo(); 
						for (int i = 0; i < admin.course_display.size(); i++) {
							System.out.println(admin.course_display.get(i)); 
						}
					}
					if (Integer.parseInt(adminchoice2) == 5) {
						admin.registerStudent(); 
						for (int i = 0; i < admin.courselist.size(); i++) {
							System.out.println(admin.courselist.get(i)); 
						}
					}
					if (Integer.parseInt(adminchoice2) == 6) {
						System.out.println("You're quitting the system. "); 
						try{     
							  FileOutputStream fout=new FileOutputStream("course_list.txt");  
							  ObjectOutputStream out=new ObjectOutputStream(fout);  
							  out.writeObject(admin.courselist);  
							  out.flush();  
							  out.close();  
							  System.out.println("Your updates have been saved and serialized. ");  
							  }catch(Exception e){System.out.println(e);}
						quit = true; 
					}
			   }while(quit == false); 
			}
			if (Integer.parseInt(adminchoice1) == 2) {
				boolean quit = false; 
				do {
				    System.out.println("Select the next action"); 
				    System.out.println("Enter 1 to view all courses"); 
				    System.out.println("Enter 2 to view all courses that are full"); 
				    System.out.println("Enter 3 to write to a file the list of course that are full"); 
				    System.out.println("Enter 4 to view the names of the students being registered in a specific course"); 
				    System.out.println("Enter 5 to view the list of courses that a given student is being registered on");
				    System.out.println("Enter 6 to sort courses based on the current number of student registers: ");
				    System.out.println("Enter 7 to quit: ");
				    String adminchoice2 = inprint.nextLine(); 
					if (Integer.parseInt(adminchoice2) == 1) {
						admin.viewAllCourses(); 
						for (int i = 0; i < admin.view_courses.size(); i++) {
							System.out.println(admin.view_courses.get(i)); 
						}
					}
					if (Integer.parseInt(adminchoice2) == 2) {
						admin.viewAllFullCourses(); 
						for (int i = 0; i < admin.view_full_courses.size(); i++) {
							System.out.println(admin.view_full_courses.get(i)); 
						}
					}
					if (Integer.parseInt(adminchoice2) == 3) {
						admin.fullOutputFile(); 
					}
					if (Integer.parseInt(adminchoice2) == 4) {
						admin.studentNameLookUp(); 
						System.out.println(admin.namelist); 
					}
					if (Integer.parseInt(adminchoice2) == 5) {
						admin.studentRegisteredCoursesLookUp(); 
						for (int i = 0; i < admin.registered_courses.size(); i++) {
							System.out.println(admin.registered_courses.get(i)); 
						}
					}
					if (Integer.parseInt(adminchoice2) == 6) {
						admin.sortCurrentNumber(); 
						for (int i = 0; i < admin.sorted_courses.size(); i++) {
							System.out.println(admin.sorted_courses.get(i)); 
						}
					}
					if (Integer.parseInt(adminchoice2) == 7) {
						System.out.println("You're quitting the system. "); 
						try{     
							  FileOutputStream fout=new FileOutputStream("course_list.txt");  
							  ObjectOutputStream out=new ObjectOutputStream(fout);  
							  out.writeObject(admin.courselist);  
							  out.flush();  
							  out.close();  
							  System.out.println("Your updates have been saved and serialized. ");  
							  }catch(Exception e){System.out.println(e);}
						quit = true; 
					}
			   }while(quit == false); 
			}
		}
			else {
				System.out.println("Failed! Your userword and password don't match. ");
			}
			
		}
	}
}
