//*********************************************************************************************
// CLASS: GradebookWriter (GradebookWriter.java)
//
// CSE205 Object Oriented Programming and Data Structures, Summmer B 2020
// Project Number: 3
//
// AUTHOR: Matthew Alagala, malagala, malagala@asu.edu
//*********************************************************************************************

/**
*The GradebookWrite Class writes the changed data back to the gradebook.dat file. 
*/

package proj3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


/**
 * GradebookWriter inherits from PrintWriter and writes the gradebook info to the file whose name
 * is passed to the ctor.
 */


public class GradebookWriter extends PrintWriter
{

    private PrintWriter mOut;

    /**
     * GradebookWriter()
     * Call the super class ctor that takes a String.
     */
    public GradebookWriter(String pFname) throws FileNotFoundException {
        super(new File(pFname));
        mOut = this;
    }

   
    /**
     * Call the super class ctor that takes a String as the argument, i.e, PrintWriter(String).
     * The PrintWriter ctor opens the file named by pFname for writing. It will throw a
     * FileNotFoundException if the file could not be opened for writing. We throw the exception
     * here as well where it will eventually be caught in Main.exit() -- see SR 7.
     **/

    public void writeGradebook(Roster pRoster) {

        for (Student student : pRoster.getStudentList()) {
            mOut.println(student);
        }
        mOut.close();
    }
}