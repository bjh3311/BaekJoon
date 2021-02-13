import java.util.Scanner;
public class 백준_9663번 {
	public static int count=0;
	public static int[] arr;
	public static int N;
	public static int check(int depth)
	{
		for(int i=0;i<depth;i++)
		{
			if(arr[depth]==arr[i])
			{
				return 0;
			}//같은 열이면 return 0
			else if(Math.abs(depth-i)==Math.abs(arr[depth]-arr[i]))
			{
				return 0;
			}//같은 대각선이면 return 0
		}
		return 1;
	}
	public static void queen(int depth)
	{
		if(depth==N)
		{
			count++;
			return;
		}
		for(int i=0;i<N;i++)
		{
			arr[depth]=i;
			if(check(depth)==1)
			{
				queen(depth+1);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
	    arr=new int[N];
	    queen(0);
	    System.out.println(count);
	}

}
