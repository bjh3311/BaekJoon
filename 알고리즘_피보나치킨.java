import java.util.*;
import java.io.*;
public class 알고리즘_피보나치킨 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		long N=Long.parseLong(br.readLine());
		long[] dp=new long[51];
		dp[0]=0;
		dp[1]=1;
		dp[2]=1;
		long result=0;
		for(int i=3;i<=50;i++)
		{
			dp[i]=dp[i-1]+dp[i-2];
		}
		for(int i=50;i>0;i--)
		{
			if(N>=dp[i])
			{
				N=N-dp[i];
				result=result+dp[i-1];
				
			}
		}
		System.out.println(result);
	}
}
