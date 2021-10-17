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
public class 백준_9370번 {

	public static int[] dist;
	public static ArrayList<Node>[] arr;
	public static int n;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T>0)
		{
			String[] st=br.readLine().split(" ");
			PriorityQueue<Integer> sb=new PriorityQueue<Integer>();;
			n=Integer.parseInt(st[0]);
			int m=Integer.parseInt(st[1]);
			int t=Integer.parseInt(st[2]);
			int[] cid=new int[t];
			st=br.readLine().split(" ");
			int s=Integer.parseInt(st[0]);//시작점
			int g=Integer.parseInt(st[1]);//건너간 교차로
			int h=Integer.parseInt(st[2]);//건너간 교차로
			
			arr=new ArrayList[n+1];
			for(int i=1;i<=n;i++)
			{
				arr[i]=new ArrayList<Node>();
			}
			for(int i=0;i<m;i++)
			{
				st=br.readLine().split(" ");
				int a=Integer.parseInt(st[0]);
				int b=Integer.parseInt(st[1]);
				int d=Integer.parseInt(st[2]);
				arr[a].add(new Node(b,d));
				arr[b].add(new Node(a,d));
			}//도로 추가
			for(int i=0;i<t;i++)
			{
				st=br.readLine().split(" ");
				cid[i]=Integer.parseInt(st[0]);
			}//후보지 입력
			int g_h=dijkstra(g,h);
			int s_g=dijkstra(s,g);
			int s_h=dijkstra(s,h);
			for(int i=0;i<t;i++)
			{
				int min=Math.min(s_h+g_h+dijkstra(g,cid[i]),s_g+g_h+dijkstra(h,cid[i]));
				if(min==dijkstra(s,cid[i]))
				{
					sb.add(cid[i]);
				}
			}
			while(!sb.isEmpty())
			{
				System.out.print(sb.poll()+" ");
			}
			System.out.println();
			T--;
		}
	}
	public static int dijkstra(int start,int end)
	{
		dist=new int[n+1];
		visited=new boolean[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start]=0;
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		q.add(new Node(start,0));
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			if(visited[temp.v])
			{
				continue;
			}
			visited[temp.v]=true;
			for(Node node:arr[temp.v])
			{
				if(!visited[node.v])
				{
					if(dist[node.v]>dist[temp.v]+node.w)
					{
						dist[node.v]=dist[temp.v]+node.w;
						q.add(new Node(node.v,dist[temp.v]+node.w));
					}
				}
			}
		}
		return dist[end];
	}
}
