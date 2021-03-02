package hw1;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public abstract class User extends Input{
	protected String first_name; 
	protected String last_name; 
	protected String username; 
	protected String password; 
	
	protected User() {
		first_name = null; 
		last_name = null; 
		username = null; 
		password = null; 
		user_list = super.user_list; 
		courselist = super.courselist; 
	}
	
	protected User(List<List<String>> user_list) {
		first_name = null; 
		last_name = null; 
		username = null; 
		password = null; 
		this.user_list = user_list; 
	}
	
	protected List<List<String>> signup() {
		Scanner inprint = new Scanner (System.in);
		System.out.println("Enter your first name please: ");
		first_name = inprint.nextLine();
		
		System.out.println("Enter your last name: ");
		last_name = inprint.nextLine(); 
		
		System.out.println("Enter a new username: ");
		username = inprint.nextLine(); 
		
		System.out.println("Enter a new password: ");
		password = inprint.nextLine(); 
		
		user_list.add(new ArrayList<String>());
		int index = user_list.size() - 1; 
		user_list.get(index).add(first_name); 
		user_list.get(index).add(last_name); 
		user_list.get(index).add(username); 
		user_list.get(index).add(password); 
		
		try{     
			  FileOutputStream fout=new FileOutputStream("user_list.txt");  
			  ObjectOutputStream out=new ObjectOutputStream(fout);  
			  out.writeObject(user_list);  
			  out.flush();  
			  out.close();  
			  System.out.println("You just created a new account. ");  
			  }catch(Exception e){System.out.println(e);}
		
		return user_list; 
	}
	
	protected boolean login(List<List<String>> user_list) { 
		boolean dummy = false; 
		Scanner inprint = new Scanner (System.in);
		System.out.println("Login");
		
		System.out.println("Enter your username: ");
		String username_input = inprint.nextLine();
		
		System.out.println("Enter your password: ");
		String password_input = inprint.nextLine();

		int user_size = user_list.size(); 
		
		for (int i = 0; i < user_size; i++) {
			if (user_list.get(i).get(2).equals(username_input)) {
				if (user_list.get(i).get(3).equals(password_input)) {
					dummy = true; 
					password = password_input; 
					username = username_input; 
					first_name = user_list.get(i).get(0); 
					last_name = user_list.get(i).get(1); 
				}
			}
		}
		return dummy; 
	}

	protected boolean login() {
		// TODO Auto-generated method stub
		return false;
	}
}
