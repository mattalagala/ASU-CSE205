//**************************************************************************************************************
// CLASS: OnCampusStudent.java
//
// DESCRIPTION
// OnCampusStudent Class, extension method for Main Student class. 
// Project 2 Module 2
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Session B SUmmer 2020
// Project Number: 2
//
// AUTHOR Matthew Alagala, malagala, malagala@asu.edu
//**************************************************************************************************************

public class OnCampusStudent extends Student {
    
    
    // Instance variables	
    protected static final int RESIDENT = 1;
    protected static final int NON_RESIDENT = 2;
    private int mResident;
    private  double mProgramFee;
    
    public OnCampusStudent(String pId, String pFname, String pLname) { super (pId, pFname, pLname );}
       
    //Constructor to get program fee
     
    public double getProgramFee() { return mProgramFee;}
    
    //Constructor to get residency
    public int getResidency() { return mResident; }
    
    //Setter method to set the program fee
     public void setProgramFee(double pProgramFee) { mProgramFee = pProgramFee; }

    //Setter method to set residency
     public void setResidency (int pResidency) { mResident = pResidency; }

    @Override
       //Setter method to set credits
       public void setCredits(int pCredits) { mCredits = pCredits; }

    @Override
    // Method to calculate tuition
    public void calcTuition() {
        double t;
        if(getResidency() == RESIDENT) { t = TuitionConstants.ONCAMP_RES_BASE; }
        else { t = TuitionConstants.ONCAMP_NONRES_BASE; }
        
        t = t + getProgramFee();

        if(getCredits() > TuitionConstants.ONCAMP_MAX_CREDITS) {
            t = t +(getCredits()- TuitionConstants.ONCAMP_MAX_CREDITS) *  TuitionConstants.ONCAMP_ADD_CREDITS;
        }

        setTuition(t);	
    }
    
}
    