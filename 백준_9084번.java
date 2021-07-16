import java.util.*;
import java.io.*;
public class 백준_9084번 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		while(T>0)
		{
			int N=Integer.parseInt(br.readLine());
			T--;
			String[]s =br.readLine().split(" ");
			int[] coin=new int[N+1];
			for(int i=1;i<=N;i++)
			{
				coin[i]=Integer.parseInt(s[i-1]);
			}
			int M=Integer.parseInt(br.readLine());
			int[] dp=new int[M+1];
			dp[0]=1;//0원을 만드는경우는 아무것도 조합하지 않는 1가지 경우이다.
			for(int i=1;i<=N;i++)
			{
				for(int j=coin[i];j<=M;j++)
				{
					dp[j]=dp[j]+dp[j-coin[i]];
				}
			}
			sb.append(dp[M]+"\n");
		}
		System.out.println(sb.toString());
	}
}
