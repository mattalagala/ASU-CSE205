//*********************************************************************************************
// CLASS: Sorter (Sorter.java)
//
// CSE205 Object Oriented Programming and Data Structures, Summmer B 2020
// Project Number: 3
//
// AUTHOR: Matthew Alagala, malagala, malagala@asu.edu
//*********************************************************************************************

/**
* The Sorter Class implements the quick sort algorithm. 
*/


package proj3;

import java.util.ArrayList;

public class Sorter {

/**
* Creates rrayList of Student class and creats two lists. 
*/
    private static int partition(ArrayList<Student> pList, int pFromIdx, int pToIdx) {
        Student pivot = pList.get(pFromIdx);


        // System.out.println(pivot);

        int leftIndex = pFromIdx - 1;
        int rightIndex = pToIdx + 1;

        while (leftIndex < rightIndex) {
            leftIndex++;
            while (pList.get(leftIndex).compareTo(pivot) == -1) {
                leftIndex++;
            }
            rightIndex--;
            while (pList.get(rightIndex).compareTo(pivot) == 1) {
                rightIndex--;
            }
            if (leftIndex < rightIndex) {
                swap(pList, leftIndex, rightIndex);
            }
        }
        return rightIndex;
    }


    private static void quickSort(ArrayList<Student> pList, int pFromIdx, int pToIdx) {
        if (pFromIdx < pToIdx) {
        
            int partitionIndex = partition(pList, pFromIdx, pToIdx);
        
            quickSort(pList, pFromIdx, partitionIndex);
            quickSort(pList, partitionIndex + 1, pToIdx);
        }

                // System.out.println(pivot);
    }

/**
* quickSorts 
**/
    private static void swap(ArrayList<Student> pList, int pIdx1, int pIdx2) {
        
        Student temp = pList.get(pIdx1);
        
        
        pList.set(pIdx1, pList.get(pIdx2));
        // System.out.println(temp);
        pList.set(pIdx2, temp);

    }

    public static void sort(ArrayList<Student> pList) {

        quickSort(pList, 0, pList.size() - 1);

    }

}

