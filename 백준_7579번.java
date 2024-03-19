import java.util.*;
import java.io.*;
public class 백준_7579번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int[] arr = new int[N];
		int[] dis = new int[N];
		s = br.readLine().split(" ");
		for(int i = 0; i < N ; i++)
		{
			arr[i] = Integer.parseInt(s[i]);
		}
		s = br.readLine().split(" ");
		for(int i = 0; i < N ; i++)
		{
			dis[i]=Integer.parseInt(s[i]);
		}
		int[][] dp = new int [N][10001];//앞에는 몇개 선택했는지, 뒤에는 비용
		for (int i = 0 ; i<N ;i++)//초기값 설정
		{
			if(dis[i]==0)
			{
				dp[i][0]=arr[i];
			}
		}
		for(int i=0;i<=10000;i++)
		{
			if(dis[0]<=i)
			{
				dp[0][i]=arr[0];
			}
		}
		
		//dp 상향식
		for(int i = 1 ; i<N;i++)
		{
			for(int j=0;j<=10000;j++)
			{
				if(dis[i]<=j)
				{
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-dis[i]]+arr[i]);
				}
				else
				{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		int result = Integer.MAX_VALUE;
		for(int i=0;i<N;i++)
		{	
			for(int j=0;j<=10000;j++)
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
