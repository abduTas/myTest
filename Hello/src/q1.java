import java.util.Scanner;

public class q1 
{

    public static void main(String[] args) 
{
        System.out.print("Enter Number between 10 and 100: ");
        Scanner console=new Scanner(System.in);
        int input=console.nextInt();
        if(input>=10 && input<=100)
	{
            //System.out.println("Correct");
            primefactor(input);
            myrandom(input);
        }
	else
	{
            System.out.println("Incorrect Input");
        }
        console.close();
}
	static void primefactor(int n)
	{int p=1;
	for (int i=2;i<=n;i++)
	{
	int rem=n%i;
	if(rem==0)
 	{ System.out.print(+i+" ");
	  if(p%i!=0){p=p*i;}
	  n=n/i;
	  i=1;
	}
	}System.out.println("");
	System.out.println(+p);
 	}

	  static void myrandom(int n){
	        System.out.println( n/2+" random number generated: ");
	        for(int i=1;i<=n/2;i++){
	            System.out.println(n*Math.random());
	        }

	  }
}