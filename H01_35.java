// CLASS: H01_35
// AUTHOR: Matthew Alagala, malagala, malagala@asu.edu


import java.util.ArrayList; // Import any required classes so your code will build


public class H01_35 { 

    public H01_35() {         
        // Default constructor
    }
    
    //Method arrayListCreate
    
    public ArrayList<Integer> arrayListCreate(int pLen, int pInitValue) {
        // 1. Declare and instantiate an ArrayList<Integer> object named list.
        ArrayList<Integer> list = new ArrayList<Integer>(pLen);
        
        for (int i=0; i<pLen; i++) {
            // 2. Write single for/while loops or a pair of for/while loops to fill list with the specified values.            
            list.add(pInitValue);

        }
    
        // 3. Return list.
        return list;
    }
}