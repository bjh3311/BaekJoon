import java.util.*;
import java.io.*;
public class 백준_10942번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String[] s=br.readLine().split(" ");
		int[] arr=new int[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=Integer.parseInt(s[i-1]);
		}
		int[][] dp=new int[N+1][N+1];
		for(int i=1;i<=N;i++)
		{
			dp[i][i]=1;
		}//길이가 1이면 무조건 true이다.
		for(int i=1;i<N;i++)
		{
			if(arr[i]==arr[i+1])
			{
				dp[i][i+1]=1;
			}
		}//길이가 2일때 두 수가 같으면 true이다.
		for(int i=3;i<=N;i++)//i는 길이
		{
			for(int j=1;j<=N-i+1;j++)
			{
				int k=j+i-1;
				if(arr[j]==arr[k])
				{
					if(dp[j+1][k-1]==1)
					{
						dp[j][k]=1;
					}
				}
			}
		}
		int M=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int S=Integer.parseInt(s[0]);
			int E=Integer.parseInt(s[1]);
			sb.append(dp[S][E]+"\n");
		}
		System.out.println(sb.toString());
	}
}
