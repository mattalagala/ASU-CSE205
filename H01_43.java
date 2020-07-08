// CLASS: H01_43
// AUTHOR: Matthew Alagala, malagala, malagala@asu.edu

 // Import any required classes so your code will build
import java.util.*;
import java.io.*;


public class H01_43 {
    //Instance Variables 
    Scanner getUserInput;
    File inputFile;
    

    public static void main(String[] pArgs) throws FileNotFoundException{
        //Calling constructor method        
        H01_43 mainObject = new H01_43();
        mainObject.run();
    }

    //Constructor
    private void run() throws FileNotFoundException{
        Scanner newFile = readInputFile();
        writeOutputFile(newFile);
    }
    // Gets users input file name and reads file, return Scanner type
    private Scanner readInputFile() throws FileNotFoundException, MissingFormatArgumentException{
        
        //Gets filename
        getUserInput = new Scanner(System.in);
        System.out.print("Please enter the name of the the Java input file: ");
        String userInput = getUserInput.nextLine();

        //Reads File
        inputFile = new File(userInput);
        Scanner fileReader = new Scanner(inputFile);        
        getUserInput.close(); 

        //Returns Scanner
        return fileReader;        
    }
    
    // File writer method
    private void writeOutputFile(Scanner newFile) throws FileNotFoundException, MissingFormatArgumentException {

        //Creates output filename based on input file
        String data = " ";
        File outputFile = new File(inputFile+".txt");
        PrintWriter out = new PrintWriter(outputFile);

        // Loops and writes file
        int i=1;
        while (newFile.hasNext()) {
            data = newFile.nextLine();
            System.out.println(data);
            out.printf("[%03d]%s\n",00+i, data);
            i++;
            out.flush();
        }       
        out.close();
    }
}   