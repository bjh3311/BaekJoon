import java.util.*;
import java.io.*;
public class น้มุ_1958น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s1=br.readLine().split("");
		String[] s2=br.readLine().split("");
		String[] s3=br.readLine().split("");
		int n1=s1.length;
		int n2=s2.length;
		int n3=s3.length;
		int[][][] dp=new int[n1+1][n2+1][n3+1];
		for(int i=1;i<=n1;i++)
		{
			for(int j=1;j<=n2;j++)
			{
				for(int k=1;k<=n3;k++)
				{
					if(s2[j-1].equals(s1[i-1]))
					{
						if(s3[k-1].equals(s2[j-1]))
						{
							dp[i][j][k]=dp[i-1][j-1][k-1]+1;
						}
						else
						{
							dp[i][j][k]=Math.max(dp[i][j][k], dp[i-1][j][k]);
							dp[i][j][k]=Math.max(dp[i][j][k], dp[i][j-1][k]);
							dp[i][j][k]=Math.max(dp[i][j][k], dp[i][j][k-1]);
						}
					}
					else
					{
						dp[i][j][k]=Math.max(dp[i][j][k], dp[i-1][j][k]);
						dp[i][j][k]=Math.max(dp[i][j][k], dp[i][j-1][k]);
						dp[i][j][k]=Math.max(dp[i][j][k], dp[i][j][k-1]);
					}
				}
			}
		}
		System.out.println(dp[n1][n2][n3]);
	}
}
