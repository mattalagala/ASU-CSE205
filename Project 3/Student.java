//*********************************************************************************************
// CLASS: Student (Student.java)
//
// CSE205 Object Oriented Programming and Data Structures, Summmer B 2020
// Project Number: 3
//
// AUTHOR: Matthew Alagala, malagala, malagala@asu.edu
//*********************************************************************************************

/**
 * The Student class stores the gradebook information for one Student.
 *
 * Note that Student implements the java.lang.Comparable<Student> interface because we are going
 * to be sorting the roster of students by last name so we need to be able to compare the last
 * names of two students A and B to determine if A < B, or if A = B, or if A > B. See the
 * compareTo() method.
 */

package proj3;

import java.util.ArrayList;


public class Student implements Comparable<Student> {

    // Declare the instance variables.
    private String mFirstName;
    private String mLastName;
    private ArrayList<Integer> mExamList;
    private ArrayList<Integer> mHomeworkList;

    /**
     * Student()
     *
     * PSEUDOCODE:
     * Save pFirstName and pLastName.
     * Create mexam1List
     * Create mHomeworkList
     */
    public Student(String pFirstName, String pLastName) {
        mFirstName = pFirstName;
        mLastName = pLastName;
        // System.out.println(mLastName);
        mExamList = new ArrayList<>();
        mHomeworkList = new ArrayList<>();
    }

    /**
     * addexam1()
     *
     * PSEUDOCODE:
     * Call add(pScore) on getexam1List() to add a new exam1 score to the list of exam1 scores.
     */
    public void addExam(int pScore) {
        getExamList().add(pScore);
    }

    /**
     * addHomework()
     *
     * PSEUDOCODE:
     * Call add(pScore) on getHomeworkList() to add a new homework score to the list of homework scores.
     */
    public void addHomework(int pScore) {
        getHomeworkList().add(pScore);
    }

    /**
     * compareTo()
     *
     * PSEUDOCODE:
     * Return: -1 if the last name of this Student is < the last name of pStudent
     * Return: 0 if the last name of this Student is = the last name of pStudent
     * Return: 1 if the last name of this Student is > the last name of pStudent
     * Hint: the last names are Strings.
     */
    @Override
    public int compareTo(Student pStudent) {
        int result = this.getLastName().compareTo(pStudent.getLastName());

            if (result > 0) {
                result = 1;
                // System.out.println(result);
            }
            else if (result < 0) {
                result = -1;
            }
        return result;
    }

    /**
     * getexam1()
     *
     * Accessor method to retreive an exam1 score from the list of exam1s.
     */
    public int getExam(int pNum) {
        // System.out.println(pNum);
        return getExamList().get(pNum);
    }

    /**
     * getexam1List()
     *
     * Accessor method for mexam1List.
     */
    protected ArrayList<Integer> getExamList() {
        return mExamList;
    }

    /**
     * getFirstName()
     *
     * Accessor method for mFirstName.
     */
    public String getFirstName() {
        return mFirstName;
    }

    /**
     * getHomework()
     *
     * Accessor method to retrieve a homework score from the list of homeworks.
     */
    public int getHomework(int pNum) {
        return getHomeworkList().get(pNum);
    }

    /**
     * getHomeworkList()
     *
     * Accessor method for mHomeworkList.
     */
    protected ArrayList<Integer> getHomeworkList() {
        return mHomeworkList;
    }

    /**
     * getLastname()
     *
     * Accessor method for mLastName.
     */
    public String getLastName() {
        return mLastName;
    }

    /**
     * setexam1()
     *
     * Mutator method to store an exam1 score into the list of exam1 scores.
     */
    public void setExam(int pNum, int pScore) {
        getExamList().set(pNum, pScore);
    }

    /**
     * setexam1List()
     *
     * Mutator method for mexam1List.
     */
    protected void setExamList(ArrayList<Integer> pExamList) {
        mExamList = pExamList;
    }

    /**
     * setFirstName()
     *
     * Mutator method for mFirstName.
     */
    public void setFirstName(String pFirstName) {
        mFirstName = pFirstName;
    }

    /**
     * setHomework()
     *
     * Mutator method to store a homework score into the list of homework
     * scores.
     */
    public void setHomework(int pNum, int pScore) {
        getHomeworkList().set(pNum, pScore);
    }

    /**
     * setHomeworkList()
     *
     * Mutator method for mHomeworkList.
     */
    protected void setHomeworkList(ArrayList<Integer> pHomeworkList) {
        mHomeworkList = pHomeworkList;
    }

    /**
     * setLastname()
     *
     * Mutator method for mLastName.
     */
    public void setLastName(String pLastName) {
        mLastName = pLastName;
    }

    /**
     * toString()
     *
     * Returns a String representation of this Student. The format of the
     * returned string shall be such that the Student information can be printed
     * to the output file, i.e:
     *
     * lastname firstname hw1 hw2 hw3 hw4 exam11 exam12
     */
    @Override
    public String toString() {
        String result = getLastName() + " " + getFirstName() + " ";
        for (Integer grade : getHomeworkList()) {
            result = result + grade.toString() + " ";
        }
        for (Integer grade : getExamList()) {
            result = result + grade.toString() + " ";
        }
        // System.out.println(result);
        result = result.substring(0, result.length() - 1);
        return result;
    }
}

