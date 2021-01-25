package 백준_2748번;
import java.util.Scanner;
public class 백준_2748번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		arr[0]=0;
		arr[1]=1;
		long res=Fib(N);
		System.out.println(res);
		
		
		
	}
	public static long[] arr=new long[91];
	public static long Fib(int n)
	{
		if(n<=1)
		{
			arr[n]=n;
		}
		else
		{
			if(arr[n]==0)
			{
				arr[n]=Fib(n-1)+Fib(n-2);
			}
		}
		return arr[n];
	}

}
