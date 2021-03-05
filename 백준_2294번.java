import java.util.Arrays;
import java.util.Scanner;
public class 백준_2294번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int k=scan.nextInt();
		int[] arr=new int[n];
		int[] dp=new int[10001];
		for(int i=0;i<=k;i++)
		{	
				dp[i]=100001;//초기값이 0이기때문
		}
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();		
			if(arr[i]<=10000)
			{
				dp[arr[i]]=1;
			}
			
		}
		Arrays.sort(arr);
		for(int i=1;i<=k;i++)
		{
			
			for(int j=0;j<n&&i-arr[j]>=0;j++)
			{
				dp[i]=Math.min(dp[i], dp[i-arr[j]]+1);
			}
		}
		if(dp[k]==100001)
		{
			System.out.print(-1);
		}
		else
		{
			System.out.println(dp[k]);
		}
	}

}
