import java.util.*;
import java.io.*;
public class น้มุ_1789น๘ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		long S=scan.nextLong();
		long left=1;
		long right=S;
		long count=0;
		long n=1;
		while(true)
		{
			if(S>=(n*(n+1)/2))
			{
				n++;
				count++;
			}
			else
			{
				break;
			}
		}
		System.out.println(count);
	}

}
