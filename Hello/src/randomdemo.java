import java.util.Random;


public class randomdemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int	num=20;
		Random ran	= new Random();
		for(int n=0;n<=(num/2);n++){
			int ranNum= ran.nextInt(20);
					System.out.println(+ranNum);
		}
	}

}
