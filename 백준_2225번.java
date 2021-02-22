import java.util.Scanner;
public class 백준_2225번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int K=scan.nextInt();
		long[][] dp=new long[K+1][N+1];//앞은 정수의 개수 뒤는 합
		for(int i=0;i<=N;i++)
		{
			dp[1][i]=1;
		}
		for(int i=2;i<=K;i++)
		{
			for(int j=0;j<=N;j++)
			{
				for(int k=j;k>=0;k--)
				{
					dp[i][j]+=dp[i-1][k]%1000000000;
				}
			}
		}
		System.out.println(dp[K][N]%1000000000);

	}

}
