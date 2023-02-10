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
public class Project {
    private String ProjectID;
    private String ProjectTitle;
    private String PCost;
    private String ACost;
    private String PSD;
    private String ASD;
    private String PES;
    private String AED;
   public void Add(String ProjectID, String ProjectTitle, String PCost ,String ACost,
		   String PSD,String ASD, String PED, String AED )
{ 
    try {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Project.txt", true))) {
            bw.write(ProjectID + ","+ProjectTitle + ","+ PCost + "," + ACost + "," +
            		PSD + ","+ ASD + ","+PED + ","+ AED + ","); 
            
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
    File oldfile = new File("ProjectTmp.txt");
    File newfile = new File("Project.txt");
    
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
    JOptionPane.showMessageDialog(null,"Project delete successfull");
    }
    
    }
}
