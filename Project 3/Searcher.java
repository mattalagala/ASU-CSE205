//*********************************************************************************************
// CLASS: Searcher (Searcher.java)
//
// CSE205 Object Oriented Programming and Data Structures, Summmer B 2020
// Project Number: 3
//
// AUTHOR: Matthew Alagala, malagala, malagala@asu.edu
//*********************************************************************************************

/**
* The Searcher Class executes a recursive binary search algorithm to search through the gradebook.dat information. 
*/


package proj3;

import java.util.ArrayList;

public class Searcher
{

    public static int search(ArrayList<Student> pList, String pKey) {
        return binSearch(pList, pKey, 0, pList.size() - 1);
    }

    /**
    * Recursively find last name. 
    */

    private static int binSearch(ArrayList<Student> pList, String pKey, int pLow, int pHigh) {

        if (pLow > pHigh) {
            return -1;
        }
        int middle = (pLow + pHigh) / 2;

        int result = pList.get(middle).getLastName().compareTo(pKey);

    /**
    * Recursively search through keys. 
    */

        if (result < 0) {
        
            return binSearch(pList, pKey, middle + 1, pHigh);
        }

        else if (result > 0) {
  
            return binSearch(pList, pKey, pLow, middle - 1);
        }
        else {

            return middle;
        }
    }

}

