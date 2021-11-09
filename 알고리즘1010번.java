import java.util.*;
import java.io.*;
class Node
{
	int vi;
	int wi;
	public Node(int vi,int wi)
	{
		this.vi=vi;
		this.wi=wi;
	}
}
public class 알고리즘1010번 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int W=Integer.parseInt(s[1]);
		Node[] arr=new Node[N];
		int[][] dp=new int[N][W+1];
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			int vi=Integer.parseInt(s[0]);
			int wi=Integer.parseInt(s[1]);
			arr[i]=new Node(vi,wi);
		}
		for(int i=0;i<=W;i++)//초기값 설정
		{
			if(arr[0].wi<=i)
			{
				dp[0][i]=arr[0].vi;
			}
		}
		for(int i=1;i<N;i++)
		{
			for(int j=0;j<=W;j++)
			{
				if(arr[i].wi<=j)
				{
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-arr[i].wi]+arr[i].vi);
				}
				else
				{
					dp[i][j]=dp[i-1][j];
				}											
			}
		}
		System.out.println(dp[N-1][W]);
	}
}
