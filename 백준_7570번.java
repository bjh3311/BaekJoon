import java.util.*;
import java.io.*;
public class 백준_7570번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] dp=new int[N+1];
		Arrays.fill(dp, 1);
		String[] s=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			int k=Integer.parseInt(s[i]);
			dp[k]=dp[k-1]+1;
		}
		Arrays.sort(dp);
		System.out.println(N-dp[N-1]);//정답출력

	}

}
