import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int v;
	long w;
	Node(int v,long w)
	{
		this.v=v;
		this.w=w;
	}
	public int compareTo(Node o)
	{
		return Long.compare(w, o.w);
	}
}
public class 백준_17396번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int[] view=new int[N];
		s=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			view[i]=Integer.parseInt(s[i]);
		}
		ArrayList<Node>[] arr=new ArrayList[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=new ArrayList<Node>();
		}
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int t=Integer.parseInt(s[2]);
			arr[a].add(new Node(b,t));
			arr[b].add(new Node(a,t));
		}
		long[] dis=new long[N];
		PriorityQueue<Node> pq=new PriorityQueue<Node>();
		pq.add(new Node(0,0));
		Arrays.fill(dis,Long.MAX_VALUE);
		dis[0]=0;
		boolean[] visited=new boolean[N];
		while(!pq.isEmpty())
		{
			Node temp=pq.poll();
			if(temp.v==N-1)
			{
				System.out.println(temp.w);
				return;
			}
			if(visited[temp.v])
			{
				continue;
			}
			visited[temp.v]=true;
			for(Node next : arr[temp.v])
			{
				if(dis[next.v]>next.w+dis[temp.v]&&view[next.v]==0)
				{
					dis[next.v]=next.w+dis[temp.v];
					pq.add(new Node(next.v,dis[next.v]));
				}
				if(dis[next.v]>next.w+dis[temp.v]&&view[next.v]==1&&next.v==N-1)
				{
					dis[next.v]=next.w+dis[temp.v];
					pq.add(new Node(next.v,dis[next.v]));
				}
			}
		}
		System.out.println("-1");
	}
}