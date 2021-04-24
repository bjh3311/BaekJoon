import java.util.*;
import java.io.*;
class Node implements Comparable<Node>{
	int V;
	int weight;
	public Node(int V,int weight)
	{
		this.V=V;
		this.weight=weight;
	}	
	@Override
	public int compareTo(Node o)
	{
		return weight-o.weight;
	}//우선순위 큐에 넣을 때 간선이 
}
public class 백준_1916번 {

	public static boolean[] visited;
	public static ArrayList<Node>[] map;
	public static int[] dis;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		visited=new boolean[N+1];
		dis=new int[N+1];
		map=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			map[i]=new ArrayList<Node>();
		}
		String[] s;
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);
			map[a].add(new Node(b,c));
		}
		s=br.readLine().split(" ");
		int start=Integer.parseInt(s[0]);
		int end=Integer.parseInt(s[1]);
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[start]=0;
		PriorityQueue<Node> q=new PriorityQueue<>();
		q.offer(new Node(start,0));
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			if(!visited[temp.V])
			{
				visited[temp.V]=true;
				for(int i=0;i<map[temp.V].size();i++)
				{
					Node next=map[temp.V].get(i);
					if(!visited[next.V]&&dis[next.V]>next.weight+dis[temp.V])
					{
						dis[next.V]=next.weight+dis[temp.V];
						q.add(new Node(next.V,dis[next.V]));
					}
				}
			}
		}
		System.out.println(dis[end]);
	}
}
