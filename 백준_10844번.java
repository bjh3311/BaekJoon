package ����_10844��;
import java.util.Scanner;
public class ����_10844�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		long[][] dp=new long[N][10];//���� ��ȹ���� ���� �迭 ����		
		for(int i=1;i<=9;i++)
		{
			dp[0][i]=1;
		}
		dp[0][0]=0;
		for(int i=1;i<N;i++)
		{
			for(int j=0;j<=9;j++)
			{
				if(j==0)
				{
					dp[i][j]=dp[i-1][j+1]%1000000000;
				}
				else if(j==9)
				{
					dp[i][j]=dp[i-1][j-1]%1000000000;
				}
				else
				{
					dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
				}
				
			}
		}
		long sum=0;
		for(int i=0;i<=9;i++)
		{
			sum+=dp[N-1][i];
		}
		System.out.println(sum%1000000000);
	}

}
