import java.util.*;
import java.io.*;
public class 프로그래머스_야간알바 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int temp=Integer.parseInt(br.readLine());
		int[] money=new int[temp];
		String[] s=br.readLine().split(" ");
		for(int i=0;i<temp;i++)
		{
			money[i]=Integer.parseInt(s[i]);
		}
		System.out.println(solution(n,money));

	}
	public static int solution(int n,int[] money)
	{
		int answer=0;
		long[] dp=new long[n+1];
		dp[n]=1;
		for(int i=0;i<money.length;i++)
		{
			for(int j=n;j>=0;j--)
			{
				if(j-money[i]>=0)
				{
					dp[j-money[i]]=(dp[j-money[i]]+dp[j])%1000000007;
				}
				
			}
		}
		answer=(int)dp[0]%1000000007;
		return answer;
	}

}
