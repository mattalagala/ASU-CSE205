//*********************************************************************************************
// CLASS: View (View.java)
//
// CSE205 Object Oriented Programming and Data Structures, Summmer B 2020
// Project Number: 3
//
// AUTHOR: Matthew Alagala, malagala, malagala@asu.edu
//*********************************************************************************************

/**
 * The View class implements the GUI. It is a subclass of JFrame and implements the ActionListener
 * interface so that we can respond to user-initiated GUI events.
 */



package proj3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class View extends JFrame implements ActionListener {

private static final long serialVersionUID = 1L;
 /**
     * The width of the View frame.
     */
public static final int FRAME_WIDTH = 500;
/**
     * The height of the View frame.
     */
public static final int FRAME_HEIGHT = 250;
/**
     * When the View() ctor is called from Main.run() to create the View, run() passes a reference
     * to the Main object as the argument to View(). We save that reference into mMain and then
     * later we can use mMain to communicate with the Main class.
     *
     * mMain is made accessible within this class via accessor/mutator methods getMain() and
     * setMain(). It shall not be directly accessed.
     */
private Main mMain;

private Student mStudent;

/*
* Declare GUI related instance variables for the buttons and text
fields.
*/
private JButton mSearchButton = new JButton("Search");

private JButton mClearButton = new JButton("Clear");
private JTextField[] mExamText = new
JTextField[Main.NUM_EXAMS];
private JButton mExitButton = new JButton("Exit");

private JTextField[] mHomeworkText = new
JTextField[Main.NUM_HOMEWORKS];
private JButton mSaveButton = new JButton("Save");

private JTextField mSearchText = new JTextField(25);



/**
* View()
*
* The View constructor creates the GUI interface and makes the frame
visible at the end.
*
* @param pMain is an instance of the
 Main class. This links the View
to the Main class so
* they may communicate with each other.
*/
public View(Main pMain) {
                /**
         * Save a reference to the Main object pMain into instance var mMain by calling setMain().
         */ 
        
        setMain(pMain);

                // PSEUDOCODE:
                // Create a JPanel named panelHomework which uses the FlowLayout
                // Add a JLabel "Homework: " to the panel
                // Create mHomeworkText which is an array of JTextFields, one for each homework assignment
                // For i = 0 to the number of homework assignments Do
                //     Create a textfield mHomeworkText[i] displaying 5 cols
                //     Add mHomeworkText[i] to the panel
                // End For
                // Note: DO NOT HARDCODE THE NUMBER OF HOMEWORK ASSIGNMENTS

        JPanel panelSearch = new JPanel();
        panelSearch.setLayout(new FlowLayout());
        panelSearch.add(new JLabel("Student Name:"));
        panelSearch.add(mSearchText);
        mSearchButton.addActionListener(this);
        panelSearch.add(mSearchButton);
        JPanel panelHomework = new JPanel();
        panelHomework.setLayout(new FlowLayout());;
        panelHomework.add(new JLabel("Homework:"));
            for(int i = 0; i <= Main.NUM_HOMEWORKS -1; i++) {
                mHomeworkText[i] = new JTextField(5);
                panelHomework.add(mHomeworkText[i]);
                }


                // Create the exam panel which contains the "Exam: " label and the two exam text fields.
                // The pseudocode is omitted because this code is very similar to the code that creates the
                // panelHomework panel above.
                // Note: DO NOT HARDCODE THE NUMBER OF EXAMS

        JPanel panelExam = new JPanel();
        panelExam.setLayout(new FlowLayout());;
        panelExam.add(new JLabel("Exam:"));
            for(int i = 0; i <= Main.NUM_EXAMS -1; i++) {
                        // System.out.println(i);
                mExamText[i] = new JTextField(5);
                panelExam.add(mExamText[i]);
                }


        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout());
        mClearButton.addActionListener(this);
        panelButtons.add(mClearButton);
        mSaveButton.addActionListener(this);
        panelButtons.add(mSaveButton);
        mExitButton.addActionListener(this);
        panelButtons.add(mExitButton);


        // PSEUDOCODE:
                // Create a JPanel named panelMain using a vertical BoxLayout
                // Add panelSearch to panelMain.
                // Add panelHomework to panelMain
                // Add panelExam to panelMain
                // Add panelButtons to panelMain
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.add(panelSearch);
        panelMain.add(panelHomework);
        panelMain.add(panelExam);
        panelMain.add(panelButtons);

        // Set the title of the View to whatever you want by calling setTitle()
        setTitle("Gradebook Editor");

        // Set the size of the View to FRAME_WIDTH x FRAME_HEIGHT
        setSize(FRAME_WIDTH, FRAME_HEIGHT);

        // Make the View non-resizable
        setResizable(false);

        // Set the default close operation to JFrame.EXIT_ON_CLOSE. What this does is if the user
        // clicks on the button in the View's titlebar to close the View, then the View will
        // be closed (as opposed to making the View dance around on the screen). ???

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add panelMain to the View.

        add(panelMain);

            // If you are a Mac user, you may need to call the pack() method which is inherited from
                // java.awt.Window() now to pack the View before displaying it. Windows and Linux users do
                // not need to do this, although if you do, it will not cause any problems. ???

        // Now display the View by calling setVisible(). .

        setVisible(true);
}

/**
* actionPerformed()
*
* Called when one of the JButtons is clicked. Detects which button was
clicked and handles it.
*/
@Override
public void actionPerformed(ActionEvent pEvent) {
String lastName;

    if (pEvent.getActionCommand() == "Search") {
    lastName = mSearchText.getText();


        if (lastName == "") {
        messageBox("Please enter the student's last name.");
                                // System.out.println(i);
        } else {
            Student student = getMain().search(lastName);

            if(student == null){messageBox("Student not found. Try again.");
            } else {
                setStudent(student);
                                        // System.out.println(lastName);
                displayStudent(student);
            }
        }
    }
    else if (pEvent.getActionCommand() == "Save") {
        if(getStudent() != null) {
        saveStudent(getStudent());
        }
    }
    else if (pEvent.getActionCommand() == "Clear") {
        clear();
    }   
    else if(pEvent.getActionCommand() == "Exit") {

        if(getStudent() != null) {
        saveStudent(getStudent());
        // System.out.println(i);
        }
        getMain().exit();
    }
}

/**
* clear()
*
* Called when the Clear button is clicked. Clears all of the text
fields by setting the
* contents of each to the empty string. After clear() returns, no
student information
* is being edited or displayed and mStudent has been set to null.
*/
private void clear() {
    mSearchText.setText("");
    for(int i = 0; i < Main.NUM_HOMEWORKS; i++)
    mHomeworkText[i].setText("");
    for(int i = 0; i < Main.NUM_EXAMS; i++)
    mExamText[i].setText("");
    setStudent(null);
}

/**
* displayStudent()
*
* Displays the homework and exam scores for a student in the
mHomeworkText and mExamText text
* fields.
*
* @param pStudent is the Student who's scores we are going to use to
populate the text fields.
*/
private void displayStudent(Student pStudent) {
        for(int i = 0; i < Main.NUM_HOMEWORKS; i++) {
            int hw = pStudent.getHomework(i);
            String hwstr = Integer.toString(hw);
            // System.out.println(hw);
            mHomeworkText[i].setText(hwstr);
        }
        for(int i = 0; i < Main.NUM_EXAMS ; i++) {
            int exm = pStudent.getExam(i);
            // System.out.println(i);
            String exmstr = Integer.toString(exm);
            mExamText[i].setText(exmstr);
        }

}

/**
* Accessor method for mMain.
*/
private Main getMain() {
    return mMain;
}


private Student getStudent() {
    return mStudent;
}

/**
* messageBox()
*
* Displays a message box containing some text. Note: pass 'this' as
the first argument to
* JOptionPane.showMessageDialog() to make the View the parent window
of the message dialog.
* This will cause the message dialog to be centered in the View. If
you pass null as the
* first argument, then the message dialog will not have a parent
window and it will be
* displayed in the center of the screen.
*/
public void messageBox(String pMessage) {
    JOptionPane.showMessageDialog(this, pMessage, "Message",
    JOptionPane.PLAIN_MESSAGE);
}

/**
* saveStudent()
* @param pStudent
* Retrieves the homework and exam scores for pStudent from the text
fields and writes the
* results to the Student record in the Roster.
*/
private void saveStudent(Student pStudent) {
        for (int i = 0; i < Main.NUM_HOMEWORKS; i++) {
            String hwstr = mHomeworkText[i].getText();
            int hw = Integer.parseInt(hwstr);
            // System.out.println(hwstr);
            pStudent.setHomework(i, hw);
        }
        for (int i = 0; i < Main.NUM_EXAMS ; i++) {
            String exmstr = mExamText[i].getText();
            int exm = Integer.parseInt(exmstr);
            // System.out.println(exm);
            pStudent.setExam(i, exm);
        }
}

/**
* Mutator method for mMain.
*/
private void setMain(Main pMain) {
    mMain = pMain;
// System.out.println(pMain;
}

/**
* Mutator method for mStudent.
*/
private void setStudent(Student pStudent) {
    mStudent = pStudent;
}



}