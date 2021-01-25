package 백준2004번;
import java.util.Scanner;
public class 백준2004번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		long n=scan.nextLong();
		long m=scan.nextLong();
		long n_two_count=how_many_two(n);
		long n_five_count=how_many_five(n);
		long n_m_two_count=how_many_two(n-m);
		long n_m_five_count=how_many_five(n-m);
		long m_two_count=how_many_two(m);
		long m_five_count=how_many_five(m);
		long a=n_two_count-n_m_two_count-m_two_count;
		long b=n_five_count-n_m_five_count-m_five_count;	
		System.out.println(Math.min(a,b));	
	}
	public static long how_many_two(long N)
	{
		long count=0;
		long i=2;
		while(true)
		{
			count+=N/i;
			i=i*2;
			if(i>N)
			{
				break;
			}
	        
		}
		return count;
		
	}
	public static long how_many_five(long N)
	{
		long count=0;
		long i=5;
		while(true)
		{
			count+=N/i;
			i=i*5;
			if(i>N)
			{
				break;
			}
		}
		return count;
	}

}
