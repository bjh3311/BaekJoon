import java.util.Scanner;
public class น้มุ_12852น๘ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		int N=scan.nextInt();
		int[][] dp=new int[N+1][2];
		dp[0][0]=0;
		dp[1][0]=0;
		for(int i=2;i<=N;i++)
		{
			dp[i][0]=dp[i-1][0]+1;
			dp[i][1]=i-1;
			if(i%2==0)
			{
				dp[i][0]=Math.min(dp[i/2][0]+1, dp[i][0]);
				if(dp[i][0]==dp[i/2][0]+1)
				{
					dp[i][1]=i/2;
				}
			}
			if(i%3==0)
			{
				dp[i][0]=Math.min(dp[i/3][0]+1, dp[i][0]);
				if(dp[i][0]==dp[i/3][0]+1)
				{
					dp[i][1]=i/3;
				}
			}
		}
		System.out.println(dp[N][0]);
		sb.append(N+" ");
		while(true)
		{
			if(N==1)
			{
				break;
			}
			sb.append(dp[N][1]+" ");
			N=dp[N][1];
		}
		System.out.print(sb.toString());

	}

}
