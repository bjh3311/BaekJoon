import java.util.*;
import java.io.*;
public class 알고리즘CoinChange_17101214배진환 
{

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(", ");
		int[] k=new int[s.length];
		for(int i=0;i<s.length;i++)
		{
			k[i]=Integer.parseInt(s[i]);
		}
		int n=Integer.parseInt(br.readLine());
		int[] dp=new int[n+1];
		Arrays.fill(dp, 1000000);
		dp[0]=0;
		for(int i=1;i<=n;i++)
		{
			for(int j=0;j<s.length;j++)
			{
				if(k[j]<=i)
				{
					dp[i]=Math.min(dp[i], dp[i-k[j]]+1);
				}
			}
		}
		System.out.println(dp[n]);

	}

}
