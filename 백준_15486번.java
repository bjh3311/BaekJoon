import java.util.*;
import java.io.*;
class Node
{
	int t;
	int p;
	Node(int t,int p)
	{
		this.t=t;
		this.p=p;
	}
}
public class 백준_15486번 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String[] s;
		ArrayList<Node> arr=new ArrayList<Node>();
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			int t=Integer.parseInt(s[0]);
			int p=Integer.parseInt(s[1]);
			arr.add(new Node(t,p));
		}
		int[] dp=new int[N+1];
		int max=-1;
		for(int i=0;i<arr.size();i++)
		{
			Node temp=arr.get(i);
			max=Math.max(dp[i],max);
			dp[i]=Math.max(dp[i], max);
			if(temp.t+i<N+1)
			{
				dp[temp.t+i]=Math.max(dp[temp.t+i], max+temp.p);
			}
		}
		dp[N]=Math.max(dp[N], max);
		System.out.println(dp[N]);
	}
}
