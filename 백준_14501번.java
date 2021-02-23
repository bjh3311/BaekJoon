import java.util.Scanner;
public class น้มุ_14501น๘ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[][] arr=new int[N+2][2];
		int[] dp=new int[N+2];
		for(int i=1;i<=N;i++)
		{
			arr[i][0]=scan.nextInt();
			arr[i][1]=scan.nextInt();
		}
		for(int i=N;i>=1;i--)
		{
			if(i+arr[i][0]<=N+1)
			{
				dp[i]=Math.max(dp[i+arr[i][0]]+arr[i][1],dp[i+1] );
			}
			else
			{
				dp[i]=dp[i+1];
			}
		}
		System.out.println(dp[1]);

	}

}
