import java.util.*;
import java.io.*;
public class 백준_7579번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int[] mem=new int[N];
		int[] cost=new int[N];
		s=br.readLine().split(" ");
		String[] t=br.readLine().split(" ");
		int sum=0;
		for(int i=0;i<N;i++)
		{
			mem[i]=Integer.parseInt(s[i]);
			cost[i]=Integer.parseInt(t[i]);
			sum+=cost[i];
		}
		int[][] dp=new int[N][sum+1];
		for(int i=0;i<N;i++)//초기값 설정
		{	
			if(cost[i]==0)
			{
				dp[i][0]=mem[i];
			}
		}
		for(int i=0;i<=sum;i++)
		{
			if(cost[0]<=i)
			{
				dp[0][i]=mem[0];
			}
		}
		for(int i=1;i<N;i++)
		{
			for(int j=1;j<=sum;j++)
			{
				if(cost[i]<=j)
				{
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-cost[i]]+mem[i]);
				}
				else
				{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		int result=Integer.MAX_VALUE;
		for(int i=0;i<N;i++)
		{
			
			for(int j=0;j<=sum;j++)
			{
				if(dp[i][j]>=M)
				{
					result=Math.min(result, j);
					break;
				}
			}
		}
		System.out.println(result);
	}
}
