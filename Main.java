
//********************************************************************************************************
// CLASS: classname (classname.java)
//
// DESCRIPTION
// A description of the contents of this file.
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, semester and year
// Project Number: project-number
//
// AUTHOR: your-name, your-asuriteid, your-email-addr
//********************************************************************************************************
import java.util.*;

import java.io.*;
 

// Main.java
public class Main {

    ArrayList<Integer> listRunsUpCount = new ArrayList<>();
    ArrayList<Integer> listRunsDnCount = new ArrayList<>();
    ArrayList<Integer> listRunsCount = new ArrayList<>(); // mergeList
    ArrayList<Integer> list = new ArrayList<>();
    int runsUp = 0;
    int runsDn = 0;
    public static void main(String[] pArgs) throws FileNotFoundException { 
        
        Main mainObject = new Main(); // Or you can just write: new Main().run();
        mainObject.run();


        /**
* A brief description of what the method does.
*/

        // try {
        //     // Try to open input file for reading
        //     } catch (FileNotFoundException pExcept) {
        //     // Print friendly error message
        //     System.exit(-100);
        //     }    
    }

    private void run() throws FileNotFoundException {       
        
        readInputFile("p01-in.txt");        
        listRunsUpCount = findRuns(list, runsUp);
        listRunsDnCount = findRuns(list, runsDn);
        listRunsCount = mergeLists(listRunsUpCount, listRunsDnCount);
        writeOutputFile("p01-runts.txt", listRunsCount);
 
        
    }

    private ArrayList <Integer> findRuns (ArrayList <Integer> pList, int pDir) {
        listRunsCount = arrayListCreate(pList.size(), 0);
        int i = 0;
        int k = 0;
        while (i<pList.size()) {
            if (pDir == 1 && pList.get(i) <= pList.get(i+1)) {
                k++;
            } else if (pDir == 1 && pList.get(i) <= pList.get(i+1)) {
                k--;
            } else {
                if (k!=0) {
                    listRunsCount.get(k);
                    k=0;
                }
            }
            i++;
        }
        if (k!=0) {
            listRunsCount.get(k);
        }
        return listRunsCount;
    }

    private ArrayList <Integer> mergeLists (ArrayList <Integer> pListRunsUpCount, ArrayList <Integer> pListRunsDnCount) {
        
        listRunsCount = arrayListCreate(pListRunsUpCount.size(),0);
        for (int i=0; i<pListRunsUpCount.size()-1;) {
            listRunsCount.add((pListRunsUpCount.get(i) + pListRunsDnCount.get(i)));
                           
            }
            return listRunsCount;
        }

    
    private ArrayList <Integer> arrayListCreate (int pSize, int pInitValue) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<pSize;) {
            list.add(pInitValue);
        }
        return list;        
    
    }

    private void writeOutputFile(String writeFile, ArrayList <Integer> pListRuns) throws FileNotFoundException {

        File outputFile = new File("p01-out.txt");
        PrintWriter out = new PrintWriter(outputFile);
        out.println("runs_total: " + pListRuns);
        for (int k=1; k<pListRuns.size()-1; k++) {
            out.println("runs_k: " + pListRuns.get(k));
        }        
        out.close();

    } 

    private ArrayList <Integer>readInputFile(String pFilename) throws FileNotFoundException {
        
        File inputFile = new File(pFilename);
        Scanner fileReader = new Scanner(inputFile);
        while (fileReader.hasNext()) {
            int data = fileReader.nextInt();
            System.out.println(data);
            list.add(data);
            
        }
      
         // Legal because of Java autoboxing.

        fileReader.close();

        return list;
    }

}

