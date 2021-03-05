import java.util.*;
import java.io.*;
public class น้มุ_11659น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int[] dp=new int[N];
		s=br.readLine().split(" ");
		dp[0]=Integer.parseInt(s[0]);
		for(int i=1;i<N;i++)
		{
			
			dp[i]=dp[i-1]+Integer.parseInt(s[i]);
		}
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int start=Integer.parseInt(s[0]);
			int end=Integer.parseInt(s[1]);
			if(start==1)
			{
				sb.append(dp[end-1]+"\n");
			}
			else
			{
				sb.append(dp[end-1]-dp[start-2]+"\n");
			}			
		}
		System.out.print(sb.toString());
		

	}

}
