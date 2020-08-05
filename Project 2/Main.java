//**************************************************************************************************************
// CLASS: Main
//
// DESCRIPTION
// Main Class, Project 2 Module 2
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Session B SUmmer
// Project Number: 2
//
// AUTHOR Matthew Alagala, malagala, malagala@asu.edu
//**************************************************************************************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * Instantiate a Main object and call run() on the object. Note that essentially now, run()
     * becomes the starting point of execution for the program.
     */

    public static void main(String[] args) throws FileNotFoundException {

        
        Main mainObject = new Main();
        mainObject.run();
        System.out.println("THIS IS THE MAIN OBJECT");
    }

  /**
     * Calculates the tuition for each Student in pStudentList. Write an enhanced for loop that
     * iterates over each Student in pStudentList. For each Student, call calcTuition() on that
     * Student object. Note: this is a polymorphic method call. What does that mean?
     *
     * PSEUDOCODE
     * Enhanced ForEach student in pStudentList Do
     *     student.calcTuition()
     * End Enhanced ForEach
     */
    private void calcTuition(ArrayList<Student> pStudentList) {
		for(Student student : pStudentList) {
            // System.out.println(student.calcTuition());
			student.calcTuition();
		}
    }

    /**
     * Reads the student information from "p02-students.txt" and returns the list of students as an ArrayList
     * <Stude
     */
    private ArrayList<Student> readFile() throws FileNotFoundException {
		ArrayList<Student> studentList = new ArrayList<Student>();

		Scanner in = new Scanner(new File("p02-students.txt"));

		while(in.hasNext() == true)
		{
			String studentType = in.next();
			if((studentType).equals("C")) {
            // System.out.println(studentType);

				studentList.add(readOnCampusStudent(in));
			} else {
				studentList.add(readOnlineStudent(in));
			}
		} in.close();
		return studentList;
    }

     /**
     * Reads the information for an on-campus student from the input file.
     *
     * PSEUDOCODE
     * Declare String object id and assign pIn.next() to id
     * Declare String object named lname and assign pIn.next() to lname
     * Declare String object named fname and assign pIn.next() to fname
     * Declare and create an OnCampusStudent object. Pass id, fname, and lname as params to ctor.
     * Declare String object named res and assign pIn.next() to res
     * Declare double variable named fee and assign pIn.nextDouble() to fee
     * Declare int variable named credits and assign pIn.nextInt() to credits
     * If res.equals("R") Then
     *    Call setResidency(OnCampusStudent.RESIDENT) on student
     * Else
     *    Call setResidency(OnCampusStudent.NON_RESIDENT) on student
     * End If
     * Call setProgramFee(fee) on student
     * Call setCredits(credits) on student
     * Return student
     */

    private OnCampusStudent readOnCampusStudent(Scanner pIn){
        String id = pIn.next();
        String lname = pIn.next();
        String fname = pIn.next();
        System.out.println(pIn);
        OnCampusStudent student = new OnCampusStudent(id, fname, lname);
        String res = pIn.next();
        double fee = pIn.nextDouble();
        int credits = pIn.nextInt();
        if((res).equals("R")){
        	student.setResidency(1);
		}
        else{
        	student.setResidency(2);
        }
        student.setProgramFee(fee);
        System.out.println(fee + " TEST THIS IS FEES");
		student.setCredits(credits);

        return student;
    }

    /**
     * Reads the information for an online student from the input file.
     *
     * PSEUDOCODE
     * Declare String object id and assign pIn.next() to id
     * Declare String object named lname and assign pIn.next() to lname
     * Declare String object named fname and assign pIn.next() to fname
     * Declare and create an OnlineStudent student. Pass id, fname, lname as params to the ctor.,
     * Declare String object named fee and assign pIn.next() to fee
     * Declare int variable named credits and assign pIn.nextInt() to credits
     * If fee.equals("T")) Then
     *     Call setTechFee(true) on student
     * Else
     *     Call setTechFee(false) on student
     * End If
     * Call setCredits(credits) on student
     * Return student
     */

    private OnlineStudent readOnlineStudent(Scanner pIn) {
        String id = pIn.next();
        String lname = pIn.next();
        String fname = pIn.next();
        OnlineStudent student = new OnlineStudent(id, fname, lname);
        String fee = pIn.next();
        int credits = pIn.nextInt();

            if((fee).equals("T")) {
                System.out.println(fee + " TEST THIS IS FEES AGAIN");
                student.setTechFee(true);
            } else {
                student.setTechFee(false);
            }

        student.setCredits(credits);
        // System.out.println(credits + " Thisi is credits !!!#(((##(");
        return student;
    }

    /**
     *  Method to read input file and or exit if no file is available
     */

     
    private void run() throws FileNotFoundException {
        // Exception handler
        try {
			Scanner readFile = new Scanner(new File("p02-students.txt"));
		} catch (FileNotFoundException pExcept) {
            System.out.println("Oh no! Could not open 'p02-students.txt', make sure the file is available to read!");

            // Immediately exits when system cannont find the above file to read.
			System.exit(-1);
		}
        ArrayList<Student> studentList = readFile();

        calcTuition(studentList);

        // Calls provided sorting alogrithm
        Sorter.insertionSort(studentList, Sorter.SORT_ASCENDING);
        writeFile(studentList);
        // System.out.println(studentList + " HOPE THIS WORKS");
    }

    /**
     * Writes the output to "p02-tuition.txt" per the software requirements. Note that this method 
     * throws FileNotFoundException if the output file could not be opened. The exception is caught
     * and handled in run().
     *
     * PSEUDOCODE
     * Declare and create a PrintWriter object named out, opening "p02-tuition.txt" for writing
     * Enhanced ForEach student in pStudentList Do
     *     Using out.printf() output the student information per SW Requiremment 3
     * End Enhanced ForEach
     * Close the output file
     */
    private void writeFile(ArrayList<Student> pStudentList) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("p020-tuition.txt"));
            for(Student student : pStudentList) {
                out.print(student.getId() + " " + student.getLname() + " " + student.getFname() + " ");
                // out.print("WHY ISNT THIS WORKING")
                out.printf("%.3f%n", student.getTuition());
            } out.close();
    }
}
