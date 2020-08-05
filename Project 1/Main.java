//********************************************************************************************************
// CLASS: Main.java
//
// DESCRIPTION
// This program will take a user's input for a filename, read that file name, and output the contents of that file to a new file.
// The new file will be a text file using the same name as the input file except with a .txt file extension. 
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Summer Session B 2020
// Project Number: 1
//
// AUTHOR: Matthew Alagala, malagala, malagala.asu.edu
//********************************************************************************************************
import java.util.*;

import java.io.*;
 

// Main.java
public class Main {
    //Instance variables
    ArrayList<Integer> listRunsUpCount = new ArrayList<>();
    ArrayList<Integer> listRunsDnCount = new ArrayList<>();
    ArrayList<Integer> listRunsCount = new ArrayList<>(); // mergeList
    ArrayList<Integer> list = new ArrayList<>();
    private static int runsUp = 1;
    private static int runsDn = -1;
    public static void main(String[] pArgs) throws FileNotFoundException { 
        
        Main mainObject = new Main(); // Or you can just write: new Main().run();
        mainObject.run();

    }
    //Default constructor
    public Main () {        
        
    }

    private void run()  {
        // Exception Handler for run       
        try {
        readInputFile("p01-in.txt");               
        listRunsUpCount = findRuns(list, runsUp);
        listRunsDnCount = findRuns(list, runsDn);
        listRunsCount = mergeLists(listRunsUpCount, listRunsDnCount);
        writeOutputFile("p01-runs.txt", listRunsCount);
        } catch (FileNotFoundException e) {
            System.out.println("catch was executed in run()");
        }
        
    }
    //findRuns method which increments runs based on runsUp or runsDn
    private ArrayList <Integer> findRuns (ArrayList <Integer> pList, int pDir) {
        listRunsCount = arrayListCreate(pList.size(), 0);
        int i = 0;
        int k = 0;
    
        while (i<pList.size()-1) {            
            if (pDir == 1 && pList.get(i) <= pList.get(i+1)) {
                k++;
                
            } else if (pDir == -1 && pList.get(i) >= pList.get(i+1)) {
                k++;
            } else {
                if (k!=0) {
                    int value = listRunsCount.get(k);
                    listRunsCount.add(k, value+1);
                    k=0;
                }
            }
            i++;
        }
        if (k!=0) {
            k++;
            int value2 = listRunsCount.get(k);
            listRunsCount.add(k,value2+1);
            k=0;
        }
               
        return listRunsCount;
    }
    //Method which merges runsUpCount and runsDnCount lists
    private ArrayList <Integer> mergeLists (ArrayList <Integer> pListRunsUpCount, ArrayList <Integer> pListRunsDnCount) {
        
        listRunsCount = arrayListCreate(pListRunsUpCount.size(),0);
        
        for (int i=0; i<pListRunsUpCount.size()-1; i++) {
            int elRunsUp = pListRunsUpCount.get(i);
            int elRunsDn = pListRunsDnCount.get(i);
            int test = elRunsUp + elRunsDn;
            System.out.println(pListRunsDnCount + "**************THIS IS THE SUM ***************");
            listRunsCount.add(i, test);
            
            }
            
            return listRunsCount;
        }

    //Creates an Arraylist of pSize and pInitValue
    private ArrayList <Integer> arrayListCreate (int pSize, int pInitValue) {
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<pSize;i++) {
            list.add(pInitValue);
        }
        
        return list;        
    
    }
    //Writes the the final output to file
    private void writeOutputFile(String writeFile, ArrayList <Integer> pListRuns) {
        try{
        File outputFile = new File("p01-out.txt");
        PrintWriter out = new PrintWriter(outputFile);
        
        int sum=0;
        
        //Calculate total loop
        for (int k=1; k<pListRuns.size()-1; k++) {
            sum += pListRuns.get(k);                     
        }
        out.println("runs_total: " + sum);
        //Prints out the k value
        for (int k=1; k<pListRuns.size()-1; k++) {
            out.println("runs_k: " + pListRuns.get(k));
        }
        
        System.out.println(sum + "**************THIS IS THE SUM ***************");   
        out.close();
        } catch (FileNotFoundException e) {
            System.out.println("catch was executed in writeOutputFile()");
        } 

    } 
    //Initially reads the input file
    private ArrayList <Integer>readInputFile(String pFilename) throws FileNotFoundException {
        try {
        File inputFile = new File(pFilename);
        Scanner fileReader = new Scanner(inputFile);
        while (fileReader.hasNext()) {
            int data = fileReader.nextInt();
            System.out.println(data);
            list.add(data);
        }     
         fileReader.close();        
        } catch (FileNotFoundException e) {
            System.out.println("catch was executed in readInputFile()");
        }
        
        return list;
    }

}

