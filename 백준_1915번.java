import java.util.*;
import java.io.*;
public class 백준_1915번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int[][] dp=new int[1000][1000];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		int ans=0;//가장 큰 정사각형의 한변의 길이
		for(int i=0;i<n;i++)
		{
			s=br.readLine().split("");
			for(int j=0;j<m;j++)
			{
				dp[i][j]=Integer.parseInt(s[j]);
				ans=Math.max(dp[i][j], ans);
			}
		}
		
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<m;j++)
			{
				if(dp[i][j]==1)
				{
					int temp=Math.min(dp[i-1][j],dp[i-1][j-1]);
					dp[i][j]=Math.min(temp, dp[i][j-1])+1;
					ans=Math.max(dp[i][j], ans);
				}
				
			}
		}
		System.out.println(ans*ans);

	}

}
