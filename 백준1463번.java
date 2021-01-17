package 백준1463번;
import java.util.Scanner;

public class 백준1463번 {
	public static void main(String[]args)
	{
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[] arr=new int[N+1];
		arr[0]=0;
		arr[1]=0;
		for(int i=2;i<=N;i++)
		{
			arr[i]=arr[i-1]+1;
			if(i%2==0)
			{
				arr[i]=Min(arr[i/2]+1,arr[i]);
			}
			if(i%3==0)
			{
				arr[i]=Min(arr[i/3]+1,arr[i]);
			}
		}
		System.out.println(arr[N]);
		
	}
	private static int Min(int a,int b)
	{
		if(a<b)
		{
			return a;
		}
		else
		{
			return b;
		}
	}

}
