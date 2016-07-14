import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Aiq2 {

public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        Scanner scanner = new Scanner(new File("/home/sunenasingh/Desktop/1.csv"));
        String bigstr=new String();
        //reading and spliting string
        while(scanner.hasNextLine()){
            String str=scanner.nextLine();
            String[] parts = str.split(",");
            for(int i=parts.length-1;i>0;i--){
               // storing string in reverse order
                bigstr=bigstr.concat(parts[i]);
                bigstr=bigstr.concat(",");
            }
            
            bigstr=bigstr.concat(parts[0]);
            bigstr=bigstr.concat("\n");
           
        }
        //writing into the file
        FileWriter fw = new FileWriter("/home/sunenasingh/Desktop/1.csv");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter fout = new PrintWriter(bw);
        fout.println(bigstr);
        System.out.println(bigstr);
        scanner.close();
        fout.close();
        bw.close();
        fw.close();
    }
}