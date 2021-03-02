package hw1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
	protected List<List<String>> courselist = new ArrayList<List<String>>(); 
	protected List<List<String>> user_list; 
	
	public Input() { 
		
		//To check the existence of serialized "coarse_list txt" file. If it doesn't exist, then 
		//we'll input the original list from "MyUniversityCourses.csv" as arraylist. If it exists, 
		//we'll deserialize the txt file as arraylist. 
		
		File serialized_courselist = new File("course_list.txt"); 
		boolean exist = serialized_courselist.exists();
		if (exist == false) {
			String line = ""; 
			String splitBy = ","; 
		    try   
		    {  
		    BufferedReader br = new BufferedReader(new FileReader("MyUniversityCourses.csv")); 
		    while ((line = br.readLine()) != null)   
		    {  
			    String[] student = line.split(splitBy);   
			    courselist.add(Arrays.asList(student)); 
			    }  
		    }
		    catch (IOException e)   
		    {  
		    e.printStackTrace();  
		    }
		}
		else {
			try 
	        {
	            FileInputStream fis = new FileInputStream("course_list.txt");
	            ObjectInputStream ois = new ObjectInputStream(fis);

	            courselist = (ArrayList) ois.readObject();

	            ois.close();
	            fis.close();
	        } 
	        catch (IOException ioe) 
	        {
	            ioe.printStackTrace();
	            return;
	        } 
	        catch (ClassNotFoundException c) 
	        {
	            System.out.println("Class not found");
	            c.printStackTrace();
	            return;
	        }
		}
		
		//To check the existence of serialized "user_list txt" file. If it doesn't exist, then 
		//we'll create an empty arraylist. Otherwise, we'll deserialize the txt file as arraylist. 
		
		File serialized_userlist = new File("user_list.txt");
		exist = serialized_userlist.exists();
		if (exist == false) {
		    user_list = new ArrayList<>(); 
		}  
		else {
			try 
	        {
	            FileInputStream fis = new FileInputStream("user_list.txt");
	            ObjectInputStream ois = new ObjectInputStream(fis);

	            user_list = (ArrayList) ois.readObject();

	            ois.close();
	            fis.close();
	        } 
	        catch (IOException ioe) 
	        {
	            ioe.printStackTrace();
	            return;
	        } 
	        catch (ClassNotFoundException c) 
	        {
	            System.out.println("Class not found");
	            c.printStackTrace();
	            return;
	        }
		}
	}
}
