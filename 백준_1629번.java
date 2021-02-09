import java.util.Scanner;

public class น้มุ_1629น๘ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		long A=scan.nextLong();
		long B=scan.nextLong();
		long C=scan.nextLong();
		System.out.println(power(A,B,C));
	}
	public static long power(long A,long B,long C)
	{
		if(B==1)
		{
			return A%C;
		}
		long temp=power(A,B/2,C);
		if (B%2==0)
		{
			return (temp*temp)%C;
		}
		else
		{
			return ((temp*temp)%C)*(A%C)%C;
		}
	}

}
