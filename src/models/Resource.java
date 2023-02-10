package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonny
 */
public class Resource {
 private String rID;
 private String tID;
 private String rType;
 private String rTitle;
 private String iDate;

 public void Add(String resourceID,String taskId,String resourceType,String resourceTitle,String initialDate)
{ 
  try {
      try (BufferedWriter bw = new BufferedWriter(new FileWriter("Resource.txt", true))) {
          bw.write(resourceID + ","+taskId + ","+ resourceType + "," + resourceTitle + "," + initialDate + ","); 
          
          bw.flush();
          bw.newLine();

          bw.close();
      }

  } catch (IOException ex) {
      System.out.println(ex);
  }
} 
   public void deleteProduct(String ProductID) throws IOException{
  String search;
  File oldfile = new File("ResourceTmp.txt");
  File newfile = new File("Resource.txt");
  
  BufferedWriter bw;
  try (BufferedReader br = new BufferedReader(new FileReader(newfile))){
      bw = new BufferedWriter(new FileWriter(oldfile));
      while ((search = br.readLine()) != null) {
      String split[] = search.split (",");
      if (split[0].contains(ProductID)) {
      continue;
      }
      bw.write(ProductID);
      bw.flush();
      bw.newLine();
      }
}
  bw.close();
  
  if (newfile.delete()) {
  oldfile.renameTo(newfile);
  }
  else{
  JOptionPane.showMessageDialog(null,"Resource delete successfull");
  }
  
  }
    
}
