import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int x;
	int weight;
	public Node(int x,int weight)
	{
		this.x=x;
		this.weight=weight;
	}
	@Override
	public int compareTo(Node o1)
	{
		return weight-o1.weight;
	}
}
public class 백준_14938번 {
	public static int max;
	public static int n;
	public static int m;
	public static int r;
	public static ArrayList<Node>[] map;
	public static int[] item;
	public static void Dijkstra(int start)
	{
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		boolean[] visited=new boolean[n+1];
		int[] dis=new int[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[start]=0;
		visited[start]=true;
		q.add(new Node(start,0));
		int count=0;
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			int v=temp.x;
			int w=temp.weight;
			for(int i=0;i<map[v].size();i++)
			{
				int nx=map[v].get(i).x;
				if(!visited[nx]&&dis[nx]>map[v].get(i).weight+w)
				{
					visited[nx]=true;
					dis[nx]=map[v].get(i).weight+w;
					q.add(new Node(nx,dis[nx]));
				}
			}
		}
		for(int i=1;i<=n;i++)
		{
			if(dis[i]<=m)
			{
				count+=item[i];
			}
		}
		max=Math.max(max, count);
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		n=Integer.parseInt(s[0]);
		m=Integer.parseInt(s[1]);//수색 범위
		r=Integer.parseInt(s[2]);
		item=new int[n+1];
		max=0;
		s=br.readLine().split(" ");
		for(int i=1;i<=n;i++)
		{
			item[i]=Integer.parseInt(s[i-1]);
		}//item개수 입력받기
		map=new ArrayList[n+1];
		for(int i=1;i<=n;i++)
		{
			map[i]=new ArrayList<Node>();
		}
		for(int i=0;i<r;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);
			map[a].add(new Node(b,c));
			map[b].add(new Node(a,c));
		}
		for(int i=1;i<=n;i++)
		{
			Dijkstra(i);
		}
		System.out.println(max);
	}

}
