import java.io.*;
import java.util.*;
public class น้มุ_9465น๘ {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<T;i++)
		{
			int N=Integer.parseInt(br.readLine());
			int[][] arr=new int[2][N+1];
			int[][] dp=new int[2][N+1];
			String[] s;
			for(int j=0;j<2;j++)
			{
				s=br.readLine().split(" ");
				for(int k=0;k<N;k++)
				{
					arr[j][k+1]=Integer.parseInt(s[k]);
				}
			}
			dp[0][1]=arr[0][1];
			dp[1][1]=arr[1][1];
			for(int j=2;j<=N;j++)
			{
				dp[1][j]=Math.max(dp[0][j-1], dp[0][j-2])+arr[1][j];
				dp[0][j]=Math.max(dp[1][j-1], dp[1][j-2])+arr[0][j];
			}
		    sb.append(Math.max(dp[0][N], dp[1][N])+"\n");
		}
		System.out.print(sb.toString());
	}
}
