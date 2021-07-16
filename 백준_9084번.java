import java.util.*;
import java.io.*;
public class ����_9084�� {

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
			dp[0]=1;//0���� ����°��� �ƹ��͵� �������� �ʴ� 1���� ����̴�.
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
