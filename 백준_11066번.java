import java.util.*;
import java.io.*;
public class 백준_11066번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T>0)
		{
			int K=Integer.parseInt(br.readLine());
			String[] s=br.readLine().split(" ");
			int[] arr=new int[K+1];
			int[] sum=new int[K+1];
			for(int i=1;i<=K;i++)
			{
				arr[i]=Integer.parseInt(s[i-1]);
				sum[i]=sum[i-1]+arr[i];
			}
			int[][] dp=new int[K+1][K+1];
			for(int i=1;i<=K;i++)
			{
				for(int from=1;from+i<=K;from++)
				{
					int to=from+i;
					dp[from][to]=Integer.MAX_VALUE;
					for(int divide=from;divide<to;divide++)
					{
						dp[from][to]=Math.min(dp[from][to], dp[from][divide]+dp[divide+1][to]+sum[to]-sum[from-1]);
					}
				}
			}
			System.out.println(dp[1][K]);//1장부터 K번째 장까지의 합
			T--;
		}
	}
}
