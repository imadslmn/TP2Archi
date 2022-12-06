package Classes;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

import Interfaces.IJournal;

public class AffichageFile implements IJournal {
    String message;
    public AffichageFile(){}
    public void outPut_Msg (String message){
    try {
      FileWriter myFile = new FileWriter("filename.txt");
      myFile.write(message);
      myFile.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}