import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int v;
	int weight;
	int price;
	public Node(int v,int price,int weight)
	{
		this.v=v;
		this.price=price;
		this.weight=weight;
	}
	public int compareTo(Node o)
	{
		return weight-o.weight;
	}
}
public class 백준_10217번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		while(T>0)
		{
			T--;
			String[] s=br.readLine().split(" ");
			int N=Integer.parseInt(s[0]);
			int M=Integer.parseInt(s[1]);
			int K=Integer.parseInt(s[2]);
			ArrayList<Node>[] arr=new ArrayList[N+1];
			for(int i=1;i<=N;i++)
			{
				arr[i]=new ArrayList<Node>();
			}
			for(int i=0;i<K;i++)
			{
				s=br.readLine().split(" ");
				int u=Integer.parseInt(s[0]);
				int v=Integer.parseInt(s[1]);
				int c=Integer.parseInt(s[2]);
				int d=Integer.parseInt(s[3]);
				arr[u].add(new Node(v,c,d));
			}
			PriorityQueue<Node> q=new PriorityQueue<Node>();
			q.add(new Node(1,0,0));//시작도시는 1번
			int[][] dp=new int[N+1][M+1];//dp[i][j]는 i점까지 j원으로의 뜻
			for(int i=1;i<=N;i++)
			{
				for(int j=0;j<=M;j++)
				{
					dp[i][j]=Integer.MAX_VALUE;
				}
			}
			dp[1][0]=0;
			while(!q.isEmpty())
			{
				Node temp=q.poll();
				int cur=temp.v;
				for(Node next: arr[cur])
				{
					if(temp.price+next.price<=M)//비용이 허락하는 한도내에서
					{
						if(dp[next.v][temp.price+next.price]>temp.weight+next.weight)
						{
							dp[next.v][temp.price+next.price]=temp.weight+next.weight;
							q.add(new Node(next.v,temp.price+next.price,temp.weight+next.weight));
						}
					}
				}
			}
			int min=Integer.MAX_VALUE;
			for(int i=0;i<=M;i++)
			{
				min=Math.min(dp[N][i], min);
			}
			if(min==Integer.MAX_VALUE)
			{
				sb.append("Poor KCM\n");
			}
			else
			{
				sb.append(min+"\n");
			}
		}
		System.out.print(sb.toString());
	}

}
