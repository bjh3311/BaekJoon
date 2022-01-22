import java.util.*;
import java.io.*;
public class DAY5_사전 {

	public static int[][] dp=new int[201][201];
	public static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int K=Integer.parseInt(s[2]);
		if(K>combination(N+M,M))
		{
			System.out.println("-1");
		}
		else
		{
			query(N,M,K);
			System.out.println(sb.toString());
		}
		
	}
	public static void query(int n,int m,int k)
	{
		if(n==0&&m==0)//a와 z를 다 썻으면 끝이다
		{
			return ;
		}
		else if(n==0)//a가 없다면 그냥 z를 추가해준다
		{
			sb.append("z");
			query(n,m-1,k);
		}
		else if(m==0)
		{
			sb.append("a");
			query(n-1,m,k);
		}
		else
		{
			int leftCount=combination(n+m-1,m);
			if(leftCount>=k)
			{
				sb.append("a");
				query(n-1,m,k);
			}
			else
			{
				sb.append("z");
				query(n,m-1,k-leftCount);
			}
		}
	}
	 public static int combination(int n, int r) 
	 {
		    if (n == r || r == 0) {
		      return 1;
		    } else if (dp[n][r] != 0) {
		      return dp[n][r];
		    } else {
		      return dp[n][r] = Math.min((int) 1e9, combination(n - 1, r - 1) + combination(n - 1, r));
		    }
	 }

}
