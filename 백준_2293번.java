import java.util.Arrays;
import java.util.Scanner;
public class 백준_2293번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int k=scan.nextInt();
		int[] arr=new int[n];
		long[] dp=new long[k+1];//경우의 수 저장
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();		
			
		}
		dp[0]=1;
		for(int i=0;i<n;i++)
		{
		    for(int j=arr[i];j<=k;j++)
			{
				dp[j]+=dp[j-arr[i]];
			}
		}
		System.out.println(dp[k]);
	}

}
