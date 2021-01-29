package 백준_2156번;
import java.util.Arrays;
import java.util.Scanner;
public class 백준_2156번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[] arr=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=scan.nextInt();
		}
		int[] dp=new int[N];
		if(N==1)
		{
			System.out.println(arr[0]);
		}
		else if(N==2)
		{
			System.out.println(arr[1]+arr[0]);
			
		}
		else if(N==3)
		{
			int a=arr[0]+arr[1];
			a=Math.max(a,arr[1]+arr[2]);
			a=Math.max(a, arr[0]+arr[2]);
			System.out.println(a);
		}
		else
		{
			dp[0]=arr[0];
			dp[1]=dp[0]+arr[1];
			dp[2]=arr[0]+arr[1];
			dp[2]=Math.max(dp[2],arr[1]+arr[2]);
			dp[2]=Math.max(dp[2], arr[0]+arr[2]);
			for(int i=3;i<N;i++)
			{
				dp[i]=arr[i]+arr[i-1]+dp[i-3];
				dp[i]=Math.max(dp[i],dp[i-2]+arr[i] );
				dp[i]=Math.max(dp[i], dp[i-1]);
			}
			Arrays.sort(dp);
			System.out.println(dp[N-1]);
		}
		
		
		

	}

}
