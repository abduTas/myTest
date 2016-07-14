import java.io.*;
import java.util.*;

public class CSVdemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String csvLine;
		BufferedReader br = null ;
		String splitter=",";
		BufferedWriter bw;
		try{
			br= new BufferedReader(new FileReader("/home/abdullatasleem/Documents/Comma.csv"));
			bw = new BufferedWriter(new FileWriter("/home/abdullatasleem/Documents/temp.csv", true));
		while((csvLine=br.readLine())!=null){
			String line[] = csvLine.split(splitter);
			
				System.out.println( line[0] +line[1]+line[2] + line[3] );
				List<String> list = Arrays.asList(line);
				System.out.println(list);
				Collections.reverse(list);
				
				String reverse[] = (String[])list.toArray();
				for(int i=0;i<reverse.length;i++){
                    System.out.println(reverse[i]);
                    bw.write(reverse[i]);
                    bw.write(',');
                    
                    }
			
                   
                 //   String str = Arrays.toString(reverse);
               // System.out.println(str);
            
		}
		bw.close();
	}catch(Exception e){
		e.printStackTrace();
		
		
	}
}
}
