import java.util.*;
import java.io.*;
public class น้มุ_5582น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s1=br.readLine().split("");
		int L1=s1.length;
		String[] s2=br.readLine().split("");
		int L2=s2.length;
		int[][] dp=new int[L2+1][L1+1];
		int result=0;
		for(int i=1;i<=L2;i++)
		{
			for(int j=1;j<=L1;j++)
			{
				if(s2[i-1].equals(s1[j-1]))
				{
					dp[i][j]=dp[i-1][j-1]+1;
					result=Math.max(result, dp[i][j]);
				}
			}
		}

		System.out.println(result);
	}
}
