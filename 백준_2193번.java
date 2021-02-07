import java.util.Scanner;
public class น้มุ_2193น๘ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		long[] dp=new long[N+1];
		if(N==1)
		{
			System.out.println("1");
		}
		else if(N==2)
		{
			System.out.println("1");
		}
		else
		{
			dp[1]=1;
			dp[2]=1;
			for(int i=3;i<=N;i++)
			{
				dp[i]=dp[i-2]+dp[i-1];
			}
			System.out.println(dp[N]);
		}
		

	}

}
