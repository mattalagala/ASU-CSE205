//*********************************************************************************************
// CLASS: GradebookReader (GradebookReader.java)
//
// CSE205 Object Oriented Programming and Data Structures, Summmer B 2020
// Project Number: 3
//
// AUTHOR: Matthew Alagala, malagala, malagala@asu.edu
//*********************************************************************************************

/**
* The GradebookReader Class reads the "gradebook.dat" file through Scanner in object. It reads the Students first and last name, homework and exam scores. 
*/

package proj3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * GradebookReader() reads the gradebook info from the file whose name is passed to the ctor.
 * Once the input file has been read, it will return a Roster object containing the list of
 * Students in the course.
 */

 public class GradebookReader  {

     /**
     * mIn is used to read from the input file.
     */

    private Scanner mIn;

    /**
     * Attempts to open the gradebook file for reading. If successful, mIn will be used to read from the file. If the file
     * cannot be opened, a FileNotFoundException will be thrown.
     */
    public GradebookReader(String pFname) throws FileNotFoundException {
        mIn = new Scanner(new File(pFname));
    }

  
    /**
     * Reads the exam scores for a Student.
     *
     * The number of exams is retrieved by calling the static getNumExams() method in Main.
     * */

    private void readExam(Student pStudent) {
        for (int n = 0; n < Main.NUM_EXAMS; ++n) {
            pStudent.addExam(mIn.nextInt());
        }
    }

   /**
     * Called to read the gradebook information. Calls readRoster() to read the student records and
     * then sorts the roster by last name.
     *
     * Called from Main.run().**/

    public Roster readGradebook() {
        Roster roster = readRoster();
        roster.sortRoster();
        return roster;
    }

   /**
     * Reads the homework scores for a Student.
     *
     * The number of homework assignments is retrieved by calling the static getNumHomeworks()
     * method in Main. **/

    private void readHomework(Student pStudent) {
        for (int n = 0; n < Main.NUM_HOMEWORKS; ++n) {
            pStudent.addHomework(mIn.nextInt());
        }
    }

   /**
     * Reads the student information for each student in the input file, adding each student to
     * the roster.
     *
     * Called from readGradebook().
     **/
    
    private Roster readRoster() {
        Roster roster = new Roster();
        while (mIn.hasNext()) {
            String lastName = mIn.next();
            String firstName = mIn.next();
            Student student = new Student(firstName, lastName);
            readHomework(student);
            readExam(student);
            roster.addStudent(student);
        }
        return roster;
    }
}