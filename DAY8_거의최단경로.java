import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int v;
	int w;
	public Node(int v,int w)
	{
		this.v=v;
		this.w=w;
	}
	public int compareTo(Node o)
	{
		return w-o.w;
	}
}
public class DAY8_거의최단경로 {

	public static boolean[][] check;
	public static ArrayList<Integer>[] parent;
	public static void backTrack(int S,int node)
	{
		if(node==S)
		{
			return;
		}
		for(int next:parent[node])
		{
			if(!check[next][node])
			{
				check[next][node]=true;
				backTrack(S,next);
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s;
		while(true)
		{
			
			s=br.readLine().split(" ");
			int N=Integer.parseInt(s[0]);
			int M=Integer.parseInt(s[1]);
			if(N==0&&M==0)
			{
				break;
			}
			ArrayList<Node>[] arr=new ArrayList[N];
			for(int i=0;i<N;i++)
			{
				arr[i]=new ArrayList<Node>();
			}
			int[] dist=new int[N];
			parent=new ArrayList[N];
			for(int i=0;i<N;i++)
			{
				parent[i]=new ArrayList<Integer>();
			}
			check=new boolean[N][N];
			Arrays.fill(dist, Integer.MAX_VALUE);
			s=br.readLine().split(" ");
			int S=Integer.parseInt(s[0]);//시작점
			int D=Integer.parseInt(s[1]);//도착점
			for(int i=0;i<M;i++)
			{
				s=br.readLine().split(" ");
				int U=Integer.parseInt(s[0]);
				int V=Integer.parseInt(s[1]);
				int P=Integer.parseInt(s[2]);
				arr[U].add(new Node(V,P));
			}
			PriorityQueue<Node> q=new PriorityQueue<Node>();
			q.add(new Node(S,0));
			dist[S]=0;
			while(!q.isEmpty())
			{
				Node temp=q.poll();
				for(Node next:arr[temp.v])
				{
					if(dist[next.v]>dist[temp.v]+next.w)//방문된적없고 거리가 짧다면
					{
						dist[next.v]=dist[temp.v]+next.w;
						q.add(new Node(next.v,dist[next.v]));
						parent[next.v].clear();
						parent[next.v].add(temp.v);
					}
					else if(dist[next.v]==dist[temp.v]+next.w)
					{
						parent[next.v].add(temp.v);
					}
				}
			}
			Arrays.fill(dist, Integer.MAX_VALUE);
			q.add(new Node(S,0));
			dist[S]=0;
			backTrack(S,D);
			while(!q.isEmpty())
			{
				Node temp=q.poll();
				for(Node next:arr[temp.v])
				{
					if(!check[temp.v][next.v]&&dist[next.v]>dist[temp.v]+next.w)//방문된적없고 거리가 짧다면
					{
						dist[next.v]=dist[temp.v]+next.w;
						q.add(new Node(next.v,dist[next.v]));
					}
				}
			}
			if(dist[D]==Integer.MAX_VALUE)
			{
				System.out.println("-1");
			}
			else
			{
				System.out.println(dist[D]);
			}
		}
	}
}
