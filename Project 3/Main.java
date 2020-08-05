//*********************************************************************************************
// CLASS: Main (Main.java)
//
// CSE205 Object Oriented Programming and Data Structures, Summmer B 2020
// Project Number: 3
//
// AUTHOR: Matthew Alagala, malagala, malagala@asu.edu
//*********************************************************************************************

/**
* This is the Main Class for the program. 
*/


package proj3;

import java.io.FileNotFoundException;
import javax.swing.JFrame;

/**
 * The Main class containing the main() and run() methods.
 */
public class Main {

    /*
     * The number of exams given in the course.
     */

    public static final int NUM_EXAMS     = 3;
    public static final int NUM_HOMEWORKS = 5;

    /**
     * The Roster of students that is read from the input file "gradebook.dat".
     */

    private Roster mRoster;

    /**
     * A reference to the View object.
     */

    private View mView;

    /**
     * This is where execution starts. Instantiate a Main object and then call run().
     */
    public static void main(String[] pArgs) {
        Main main = new Main();
        main.run();
    }

     /**
     * exit() is called when the Exit button in the View is clicked. When we exit we have to write
     * the roster to the output file "gradebook.dat". Then we exit the program with a code of 0.
     */

    public void exit() {

        /* We open the file and write the roster to it in a try-catch block, where we catch a
        ** FileNotFoundException that will be thrown if for some reason, we cannot open "gradebook.dat"
        ** for writing.
        */

        try {
            GradebookWriter writer = new GradebookWriter("gradebook.dat");
            writer.writeGradebook(getRoster());
            System.exit(0);
            writer.close();
        }
        catch (FileNotFoundException pExcept) {
            getView().messageBox("Could not open gradebook.dat for writing. "
                    + "Exiting without saving.");
            System.exit(-1);
        }

    }

   
    /**
     * This method retrns the number of homwork assignmets in the class by returning the
     * consant NUM_HOMEWORKS.
     */
    public static final int getNumHomeworks() {
        return NUM_HOMEWORKS;
    }


    /**
     * Accesssor method for mRoster.
     */
    public Roster getRoster() {
        return mRoster;
    }
    
    /**
     * This method retuns the number of exams in the class by rturning the constant NUM_EXAMS.
     */
    public static final int getNumExams() {
        return NUM_EXAMS;
    }

    /**
     * Accessor metohod for mView.
     */

    public View getView() {
        return mView;
    }

    private void run() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        setView(new View(this));

        try {
            GradebookReader reader = new GradebookReader("gradebook.dat");
            setRoster(reader.readGradebook());

        }
        catch (FileNotFoundException pExcept) {
            getView().messageBox("Could not open gradebook.dat for reading. Exiting.");
            System.exit(-1);
        }

    }

    /**
     * Search Steudents
     */
    public Student search(String pLastName) {
        return getRoster().getStudent(pLastName);
    }

    
    public void setRoster(Roster pRoster) {
        mRoster = pRoster;
    }

   
    public void setView(View pView) {
        mView = pView;
    }
}
