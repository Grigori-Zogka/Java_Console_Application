package App;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;


//Console application


public class consoleApplication {

	public static void main(String[] args) {
		
		//declaring variables
		String output;
		String option = "";
		//all the records/lines can be stored in an Array list- the Array list was used as we do not know the total size of the Array
		ArrayList <String> myRecords = new ArrayList <String> ();
		
		//The required lines are initially stored in the ArrayList
		myRecords.add("Welcome to the timewarp of programs! ");
		myRecords.add("Applications like this were used in in the 1980s. ");
		myRecords.add("Then I can do much more complicated things. ");

		//the main loop of the application
		while(option != "EXIT") {


			//printing the main Menu in the console
			output = "----------------------------------------\n";	
			output = output + "-------------------MENU-----------------\n";
			output = output + "----------------------------------------\n";

			output = output + "Select a menu option \n";
			output = output + "----------------------------------------\n";
			output = output + "Type L - Display  all records \n";
			output = output + "Type A - Add a new  record \n";
			output = output + "Type I - Insert new record at a specific index \n";
			output = output + "Type D - Delete an record \n";
			output = output + "Type R - Swap the position of two records \n";
			output = output + "Type E - Edit records \n";
			output = output + "Type S - Save records \n";
			output = output + "Type L - Load records \n";
			output = output + "Type Exit - Quit \n";
			output = output + "----------------------------------------\n";
			output = output + "Type Below: " ;

			System.out.println(output);//print
			
			//asking for user input in order to select the menu options
			Scanner userOption = new Scanner(System.in);

			option = userOption.nextLine();
			option = option.toUpperCase();//convert user input to Upper case - this ensures that the user input can be recognised by the aplication

			System.out.println("Function => " + option);//this line make the UI clearer as is displaying the user input
			
			//Switch between different  menu options
			switch (option) {


			case "L" ://requirement 1 - display all records 
				displayList(myRecords);///call relevant method
				break;

			case "A" ://requirement 2 - add a new line - the new record/line is being stored in the ArrayList 
				System.out.println("------------- ");
				System.out.println("Type a string:");

				myRecords.add(userOption.nextLine());//add the user input as at the end of the ArrayList
				System.out.println("Number of string in array: " + myRecords.size());
				// Display everything in the Array list
				displayList(myRecords);//call relevant method
				System.out.println("The new record has been added");
				break;
				
			case "I": //requirement 3 - insert a new line at a specified index 
				insertNewRecondAtAnyPoint(myRecords);//call the relevant method
				break;

			case "D": //requirement 4 - delete a record 
				System.out.println("-------------------------------------");
				System.out.println("Which index would you like to delete?");
				Scanner indexDel = new Scanner(System.in);
				int intIndexDel = indexDel.nextInt();//the user chooses the index he wishes to delete
				
				myRecords.remove(intIndexDel);//remove
				System.out.println("----------------------------------------------");
				System.out.println("Recornd in Index " + intIndexDel + " has been removed");//confirm the action to the user
				break;	
					
			case "R": //requirement 5 - Swap lines based on their indexes
				swapLines(myRecords); //call the relevant method
				break;
			case "E": //requirement 6 - Edit a line - the user can choose the index the he wishes to be removed form the ArrayList
				editLine(myRecords);
				break;
			case "S": //requirement 7 (optional) - Save the records
				saveRecords(myRecords);
				break;	
			case "LD"://requirement 7 (optional) - Load the records
				lodRecords(myRecords);
				break;

			case "EXIT": //Close the application by tiping EXIT
				System.out.println("Application closed!");
				System.exit(0);//exit application


			default ://Default me message informing the user that this input does not corespond to any of the menu options
				System.out.println("-------------------------------");
				System.out.println("I did not recognise your entry ");

			}//end switch

		}//end while

	}//end main

	//the below method is being used to take  user input in order to add an recored at the index of his choice
	public static void insertNewRecondAtAnyPoint(ArrayList myRecords) {
		//ask the user to specify the the index he wishes the new record to be inserted
		System.out.println("-------------------------------------------------------");
		System.out.println("Select the index that you want to insert the new record");
		Scanner index = new Scanner(System.in);
		int intIndex = index.nextInt();
		
		//validate user input - it cannot be less that 0 or bigger that the Array size
		while(intIndex<0 || intIndex > myRecords.size() ) {
			
			//prompting the user to provide a valid index
			System.out.println("Invalid index! - Please input a number between 0 and " + myRecords.size());
			intIndex = index.nextInt();
		} 
		
		//ask the user to type specify the new record
		System.out.println("------------------------------------");
		System.out.println("Type the record that you want to add");
		Scanner index1 = new Scanner(System.in);
		String intIndex1 = index1.nextLine();
		
		myRecords.add(intIndex, intIndex1);//add user input to the required ArrayList index
		System.out.println("The new entry has been added");
		//displayList(myRecords); 

	}//end insertNewRecondAtAnyPoint

	//Method to swap the records stored in the ArrayList base on their index positions - using user input
	public static void swapLines(ArrayList myRecords) {

		//asking the user to specify the index of the 1st line that he wants to swap
		System.out.println("----------------------------------------------");
		System.out.println("Select the first index that you want to swap.");
		Scanner index = new Scanner(System.in);
		int intIndex1 = index.nextInt();// take user input
		
		//asking the user to specify the index of the 2nd line that he wants to swap
		System.out.println("Select the second index that you want to swap.");
		int intIndex2 = index.nextInt();// take user input

		//validate user input for the first line - it cannot be less that 0 or bigger that the Array size
		while(intIndex1<0 || intIndex1 > myRecords.size()) {

			System.out.println("Invalid index! - Please input a number between 0 and " + myRecords.size());
			System.out.println("----------------------------------------------");
			System.out.println("Select the first index that you want to swap.");
			intIndex1 = index.nextInt();

		} 
		//validate user input for the second line - it cannot be less that 0 or bigger that the Array size
		while(intIndex2<0 || intIndex2 > myRecords.size()) {

			System.out.println("Invalid index! - Please input a number between 0 and " + myRecords.size());
			System.out.println("Select the second index that you want to swap.");
			intIndex2 = index.nextInt();

		} //end swapLines

		//swaping the records
		Collections.swap(myRecords, intIndex1, intIndex2);

		System.out.println("Line " + intIndex1 + " Has been swapped with line " + intIndex2 );//confirming the swap to the user
		//displayList(myRecords);

	}//end swapLines

	//method to display all the records stored in the Array
	public static void displayList(ArrayList myRecords) {
		System.out.println("--------------------------------------");
		System.out.println("            All records");
		System.out.println("---------------------------------------");
		//for loop runs though the Array list and prints it's contents
		for(int i = 0; i < myRecords.size(); i++) 
			System.out.println(myRecords.get(i));
	}//end displayList


	//method to edit any record in the Array List - user uses the index as an indicator
	public static void editLine(ArrayList myRecords) {
		System.out.println("---------------------------------------------");
		System.out.println("Select the index to be edited.");

		Scanner index = new Scanner(System.in);
		int userIndex = index.nextInt();

		//validate user input for the second line - it cannot be less that 0 or bigger that the Array size
		while(userIndex<0 || userIndex > myRecords.size()) {

			System.out.println("Invalid index! - Please input a number between 0 and " + myRecords.size());
			System.out.println("----------------------------------------------");

			userIndex = index.nextInt();

		} 


		System.out.println("Index " +  userIndex +" to be edited.");
		System.out.println("Please type the new record");

		Scanner editLine = new Scanner(System.in);

		//Adding the new record in the specified by the user index
		myRecords.set(userIndex, editLine.nextLine());


	}//end editLine

	
	//method to save the records
	public static void saveRecords(ArrayList myRecords) {

		File fileName = new File("Records.txt");

		try {

			FileWriter fw = new FileWriter(fileName);

			Writer output = new BufferedWriter(fw);

			int size = myRecords.size();

			for(int i = 0; i<size; i++) {
				output.write(myRecords.get(i).toString() +"\n");
					

			} 	
			System.out.println("Records saved");
			output.close();
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to save");
		}
	}//saveRecords

	//method to load the records
	public static void lodRecords(ArrayList myRecords) {

		String fileName = "Records.txt";
		String line;

		try {
			BufferedReader input = new BufferedReader(new FileReader(fileName));		
			if(!input.ready()) {
				
				throw new IOException();
			}
			while ((line = input.readLine())!= null) {
				
				myRecords.add(line);
			}
			
			input.close();
		}catch (IOException e) {
			
			System.out.println(e);
		}
		
		displayList(myRecords);

		
	}//end lodRecords

}//end class

