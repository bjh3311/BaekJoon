import java.util.*;
import java.io.*;
class Node implements Comparable <Node>
{
	int v;
	int w;
	public Node(int v,int w)
	{
		this.v=v;
		this.w=w;
	}
	public int compareTo(Node o1)
	{
		return w-o1.w;
	}
	
}
public class 백준_5719번 {
	public static void backtrack(int S,int node)
	{
		if(node==S)
		{
			return;
		}
		for(int n:parent[node])
		{
			if(!check[n][node])
			{
				check[n][node]=true;
				backtrack(S,n);
			}
		}
	}
	public static boolean[][] check;
	public static LinkedList<Integer>[] parent;
	public static int S;
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
			check=new boolean[N][N];
			ArrayList<Node>[] arr=new ArrayList[N];
			parent=new LinkedList[N];
			for(int i=0;i<N;i++)
			{
				parent[i]=new LinkedList<Integer>();
			}
			for(int i=0;i<N;i++)
			{
				arr[i]=new ArrayList<Node>();
			}
			s=br.readLine().split(" ");
			S=Integer.parseInt(s[0]);//시작점
			int D=Integer.parseInt(s[1]);//도착점
			for(int i=0;i<M;i++)
			{
				s=br.readLine().split(" ");
				int start=Integer.parseInt(s[0]);
				int end=Integer.parseInt(s[1]);
				int weight=Integer.parseInt(s[2]);
				arr[start].add(new Node(end,weight));
			}
			int[] dis=new int[N];
			Arrays.fill(dis, Integer.MAX_VALUE);
			PriorityQueue<Node> q=new PriorityQueue<Node>();
			dis[S]=0;
			q.add(new Node(S,0));
			boolean[] visited=new boolean[N];
			while(!q.isEmpty())//첫번째 다익스트라 실행
			{
				Node temp=q.poll();
				int v=temp.v;
				if(visited[v])
				{
					continue;
				}
				visited[v]=true;
				for(int i=0;i<arr[v].size();i++)
				{
					int next=arr[v].get(i).v;
					if(!visited[next]&&dis[next]>dis[v]+arr[v].get(i).w)
					{
						parent[next].clear();
						parent[next].add(v);
						dis[next]=dis[v]+arr[v].get(i).w;
						q.add(new Node(next,dis[next]));
					}
					else if(!visited[next]&&dis[next]==dis[v]+arr[v].get(i).w)
					{
						parent[next].add(v);
					}
				}
			}
			backtrack(S,D);
			Arrays.fill(visited, false);
			Arrays.fill(dis, Integer.MAX_VALUE);
			dis[S]=0;
			q.add(new Node(S,0));
			while(!q.isEmpty())//두번째 다익스트라 실행
			{
				Node temp=q.poll();
				int v=temp.v;
				if(visited[v])
				{
					continue;
				}
				visited[v]=true;
				for(int i=0;i<arr[v].size();i++)
				{
					int next=arr[v].get(i).v;
					if(!check[v][next]&&!visited[next]&&dis[next]>dis[v]+arr[v].get(i).w)
					{//조건 하나더 추가
						dis[next]=dis[v]+arr[v].get(i).w;
						q.add(new Node(next,dis[next]));
					}
				}
			}
			if(dis[D]==Integer.MAX_VALUE)
			{
				System.out.println("-1");
			}
			else
			{
				System.out.println(dis[D]);
			}
		}
	}
}
