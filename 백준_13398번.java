import java.util.*;
import java.io.*;
public class 백준_13398번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String[] s=br.readLine().split(" ");
		int[] arr=new int[n];
		int[][] dp=new int[n][2];//j=0 제거 된 경우, j=1제거 되지 않은경우
		for(int i=0;i<n;i++)
		{
			arr[i]=Integer.parseInt(s[i]);
		}
		dp[0][0]=arr[0];
		dp[0][1]=arr[0];
		for(int i=1;i<n;i++)
		{
			dp[i][0]=Math.max(arr[i], dp[i-1][0]+arr[i]);
			dp[i][1]=Math.max(dp[i-1][1]+arr[i], dp[i-1][0]);
		}
		int ans=arr[0];
		for(int i=0;i<n;i++)
		{
		   int temp=Math.max(dp[i][0], dp[i][1]);
		   ans=Math.max(temp, ans);
		}
		System.out.println(ans);

	}

}
