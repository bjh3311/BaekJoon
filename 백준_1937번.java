import java.util.*;
import java.io.*;
public class น้มุ_1937น๘ {

	public static int n;
	public static int[][] map;
	public static int[][] dp;
	public static int dfs(int x,int y)
	{
		if(dp[x][y]!=-1)
		{
			return dp[x][y];
		}
		dp[x][y]=1;
		if(x+1<n&&map[x][y]<map[x+1][y])
		{
			dp[x][y]=Math.max(dp[x][y],dfs(x+1,y)+1);
			
		}
		if(x-1>=0&&map[x][y]<map[x-1][y])
		{
			dp[x][y]=Math.max(dp[x][y],dfs(x-1,y)+1);
		}
		if(y+1<n&&map[x][y]<map[x][y+1])
		{
			dp[x][y]=Math.max(dp[x][y],dfs(x,y+1)+1);
		}
		if(y-1>=0&&map[x][y]<map[x][y-1])
		{
			dp[x][y]=Math.max(dp[x][y], dfs(x,y-1)+1);
		}
		return dp[x][y];
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		map=new int[n][n];
		dp=new int[n][n];
		String[] s;
		for(int i=0;i<n;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<n;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
				dp[i][j]=-1;
			}
		}
		int ans=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				ans=Math.max(ans,dfs(i,j));
			}
		}
		System.out.println(ans);

	}

}
