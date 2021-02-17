import java.util.Scanner;
public class น้มุ_14852น๘ {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		long[][] dp=new long[N+1][2];
		if(N==1)
		{
			System.out.println(2);
		}
		else if(N==2)
		{
			System.out.println(7);
		}
		else if(N==3)
		{
			System.out.println(22);
		}
		else
		{
			dp[1][0]=2;
	        dp[2][0]=7;
	        dp[3][0]=22;
	        dp[3][1]=2;
			for(int i=4;i<=N;i++)
			{
				dp[i][1]=dp[i-1][1]+(2*dp[i-3][0]);
				dp[i][0]=((dp[i-1][0]*2)+(dp[i-2][0]*3)+dp[i][1])%1000000007;
				
			}
			System.out.println(dp[N][0]%1000000007);
		}
        
	}
}
