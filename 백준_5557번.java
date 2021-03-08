import java.util.Scanner;
public class 백준_5557번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[] arr=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=scan.nextInt();
		}
		long[][] dp=new long[N-1][21];//0부터 20인 수까지
		dp[0][arr[0]]=1;//시작점에서 경우의 수 하나
		for(int i=1;i<N-1;i++)
		{
			for(int j=0;j<=20;j++)
			{
				if(j+arr[i]<=20)
				{
					dp[i][j+arr[i]]+=dp[i-1][j];
				}
				if(j-arr[i]>=0)
				{
					dp[i][j-arr[i]]+=dp[i-1][j];
				}			
			}
		}
		System.out.println(dp[N-2][arr[N-1]]);

	}

}
