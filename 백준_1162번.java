import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int v;
	long weight;
	int packing;
	public Node(int v,long weight)
	{
		this.v=v;
		this.weight=weight;
	}
	public Node(int v,long weight,int packing)
	{
		this.v=v;
		this.weight=weight;
		this.packing=packing;
	}
	public int compareTo(Node o)
	{
		if(weight>o.weight)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
}
public class 백준_1162번 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int K=Integer.parseInt(s[2]);
		ArrayList<Node>[] arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Node>();
		}
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int start=Integer.parseInt(s[0]);
			int end=Integer.parseInt(s[1]);
			int weight=Integer.parseInt(s[2]);
			arr[start].add(new Node(end,weight));
			arr[end].add(new Node(start,weight));//양방향이기 때문에
		}
		long[][] dp=new long[N+1][K+1];//dp[i][k] i지점까지 K개의 도로를 포장했을때 최소값
		for(int i=1;i<=N;i++)
		{
			Arrays.fill(dp[i], Long.MAX_VALUE);
		}
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		dp[1][0]=0;
		q.add(new Node(1,0,0));
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			int current=temp.v;
			long d=temp.weight;
			int cnt=temp.packing;
			if(dp[current][cnt]<d)
			{
				continue;
			}
			for(Node n:arr[temp.v])
			{
				int next=n.v;
				long nextD=d+n.weight;
				if(dp[next][cnt]>nextD)
				{
					dp[next][cnt]=nextD;
					q.add(new Node(next,nextD,cnt));
				}
				if(cnt<K&&dp[next][cnt+1]>d)
				{
					dp[next][cnt+1]=d;
					q.add(new Node(next,d,cnt+1));
				}
			}
		}
		long result=Long.MAX_VALUE;
		for(int i=0;i<=K;i++)
		{
			result=Math.min(result, dp[N][i]);
		}
		System.out.println(result);
	}
}