import java.util.Arrays;
import java.util.Scanner;
public class 백준_11055번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[] arr=new int[N];
		int[] dp=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=scan.nextInt();
		}
		dp[0]=arr[0];//dp에는 수열의 합을 넣을것이다.
		for(int i=0;i<N;i++)
		{
			if(dp[i]==0)
			{
				dp[i]=arr[i];
			}
			for(int j=0;j<i;j++)
			{
				if(arr[i]>arr[j])
				{
					dp[i]=Math.max(dp[i], dp[j]+arr[i]);
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[N-1]);

	}

}
