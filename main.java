
import java.io.*;
import java.util.Scanner;
import java.lang.StringBuilder;
public class main {
   public static void main(String[]args) {
	   System.out.println("This software is currently only meant for you to add only one event");
	   /* Stores what the user enters*/
	   String response;
	   
	   /* Used for storing Descriptions */
	   StringBuilder description = new StringBuilder();
	   
	   /*used for storing an option that the user chose*/
	   int option;
	   
	   /*
	   InputStream sstderr = p.getErrorStream();
	   InputStream sstdout = p.getInputStream();
	   OutputStream sstdin  = p.getOutputStream();
	   */
	   boolean exit = true;
	   Scanner scan = new Scanner(System.in);
	   PrintWriter writer;
	   BufferedWriter buffWriter;
	   /* Begin running the interface*/
	   while(exit) {
		   
		   System.out.println("\n" + 
                   "Which of these options would you like to add? Press an number and then press enter"
                   + "\n" + "(1) Create an Event"  
		             + "\n" + "(2) Exit");
		   
		   option = scan.nextInt();
		   if(option == 1) { // Add an event
			   try {
				   scan.nextLine();
				   System.out.print("Please enter your email: ");
				   response = scan.nextLine();
				   File icsFile = new File(response + ".ics");
			       writer = new PrintWriter(icsFile);
			       buffWriter = new BufferedWriter(writer);			     
			       buffWriter.write("BEGIN:VCALENDAR");
			       System.out.println("Please enter the date");
			       buffWriter.close();
			   }
			   catch(FileNotFoundException e) {
				   System.out.println("oops");
				   
			   } catch (IOException e) {
				   // TODO Auto-generated catch block
				   e.printStackTrace();
		     	}
			   
			  
			   
			   /*
			   System.out.println("Please enter a description, "
			   		+ "and press enter a second to indicate that you have finished: "
			   		+ "to skip this option, just press enter");
		       boolean enter = false;
		       scan.nextLine();
		       
		       while(!enter) {
		    	   
		    	   response = "";
		    	   response = scan.nextLine();
		    	   if(response.length() == 0) {
		    		   enter = true;
		    		   //System.out.print(description);
		    	   }
		    	   else {
			           description.append(response + "\n");
		    	   }
		    	  
		       }*/
			   
		   }
		   
		      
	       if(option == 2) {
	    	   System.out.println("Thank you for using this software");
	    	   exit = false; 
	       }
	   }

	   
	   /*    
	   BufferedReader stdout = new BufferedReader(new InputStreamReader(sstdout));
	   BufferedWriter stdin = new BufferedWriter(new OutputStreamWriter(sstdin2));*/
	   
   }
}
