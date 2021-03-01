import java.util.Scanner;
public class 백준_18244번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		long[][][] dp=new long[100][10][5];
		long sum=0;
		int mid=2;
		for(int i=0;i<=9;i++)
		{
			dp[0][i][mid]=1;
		}//초기값 설정
		for(int i=1;i<9;i++)
		{
			dp[1][i][mid+1]=dp[0][i-1][mid];
			dp[1][i][mid-1]=dp[0][i+1][mid];
		}//bottom-up 방식
		dp[1][0][mid-1]=dp[0][1][mid];
		dp[1][9][mid+1]=dp[0][8][mid];
		for(int i=2;i<N;i++)
		{
			for(int j=0;j<=9;j++)
			{
				if(j==0)
				{
					dp[i][0][mid-1]=dp[i-1][1][mid+1]%1000000007;
					dp[i][0][mid-2]=dp[i-1][1][mid-1]%1000000007;
				}
				else if(j==9)
				{
					dp[i][9][mid+1]=dp[i-1][8][mid-1]%1000000007;
					dp[i][9][mid+2]=dp[i-1][8][mid+1]%1000000007;
				}
				else
				{
					dp[i][j][mid+1]=(dp[i-1][j-1][mid-1]+dp[i-1][j-1][mid-2])%1000000007;
					dp[i][j][mid+2]=dp[i-1][j-1][mid+1]%1000000007;
					dp[i][j][mid-1]=(dp[i-1][j+1][mid+1]+dp[i-1][j+1][mid+2])%1000000007;
					dp[i][j][mid-2]=dp[i-1][j+1][mid-1]%1000000007;
				}
			}				
		}//bottom-up방식
		for(int i=0;i<=9;i++)
		{
			for(int j=0;j<5;j++)
			{
				sum+=dp[N-1][i][j];
			}
		}
			System.out.println(sum%1000000007);
		}
	
}