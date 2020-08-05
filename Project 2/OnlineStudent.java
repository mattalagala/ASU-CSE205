//**************************************************************************************************************
// CLASS: OnlineStudent.java
//
// DESCRIPTION
// OnlineStudent Class, extension class to Main Student class. 
// Project 2 Module 2
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Session B SUmmer 2020
// Project Number: 2
//
// AUTHOR Matthew Alagala, malagala, malagala@asu.edu
//**************************************************************************************************************

public class OnlineStudent extends Student {
	
    // declaration of varibles.
    private boolean mTechFee;
    public OnlineStudent(String pId, String pFname, String pLname) {
    
        super(pId, pFname, pLname);
    
    }

    // Method to get the online tech fee students
    public boolean getTechFee() {
        return mTechFee;
    }
    
    // System.out.println(getTechFee() + " WHY ARENT YOU OUTPUTTING!!!!");


    // Setter method to set Tech fee for online studnts
    public void setTechFee(boolean pTechFee) {
        mTechFee = pTechFee;	
    }
    
        @Override
    //Calculates cost based on constancts
    public void calcTuition() {
        double t  = getCredits() * TuitionConstants.ONLINE_CREDIT_RATE;
        if(getTechFee() == true) {
            t = t + TuitionConstants.ONLINE_TECH_FEE;
        }
        setTuition(t);
        return;
    }
}