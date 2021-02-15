import java.util.Scanner;
public class น้มุ_11057น๘ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[][] dp=new int[N][10];
		for(int i=0;i<=9;i++)
		{
			dp[0][i]=1;
		}
		int sum=0;
		for(int i=1;i<N;i++)
		{
			dp[i][0]=dp[i-1][0];
			for(int j=1;j<=9;j++)
			{
				for(int k=0;k<=j;k++)
				{
					dp[i][j]+=dp[i-1][k];
				}
				dp[i][j]=dp[i][j]%10007;
				
			}
		}
		for(int i=0;i<=9;i++)
		{
			sum+=dp[N-1][i];
		}
		System.out.println(sum%10007);

	}

}
