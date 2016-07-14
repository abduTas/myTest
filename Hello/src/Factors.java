import java.io.*;
import java.util.Random;


public class Factors {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
int num ,i=2,index=0;
int factor [] = new int[5],counter=0;
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.print("Enter a Number : ");
num=Integer.parseInt(br.readLine());
System.out.println("twenty random numbers between o and n/2 are");
Random ran	= new Random();
for(int n=0;n<(num/2);n++){
	int ranNum= ran.nextInt(num/2);
			System.out.print("\t"+ranNum);
}
double mulFac=1;
if(!(num<10 ||num>100)){
	System.out.println("\n"+"prime factors are");
 while(num>1){
	 if(num%i==0){
		 System.out.print("\t"+i);
		 num=num/i;
		 factor[index++]=i;
		 counter++;		 
	 }else
		 i++;
 }
 for(int j=0;j<counter;j++){
	if(mulFac%factor[j]!=0)
	 mulFac= mulFac*factor[j];
 }
 System.out.println("\n" +"multiplication of unique factors is" +mulFac );
}
	

}

}
