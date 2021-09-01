import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int v;
	int w;
	Node(int v,int w)
	{
		this.v=v;
		this.w=w;
	}
	public int compareTo(Node o)
	{
		return w-o.w;
	}
}
public class 카카오_합승택시요금 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] sb=br.readLine().split(" ");
		int n=Integer.parseInt(sb[0]);
		int s=Integer.parseInt(sb[1]);
		int a=Integer.parseInt(sb[2]);
		int b=Integer.parseInt(sb[3]);
		sb=br.readLine().split(" ");
		int e=Integer.parseInt(sb[0]);
		int[][] fares=new int[e][3];
		for(int i=0;i<e;i++)
		{
			sb=br.readLine().split(" ");
			int c=Integer.parseInt(sb[0]);
			int d=Integer.parseInt(sb[1]);
			int f=Integer.parseInt(sb[2]);
			fares[i][0]=c;
			fares[i][1]=d;
			fares[i][2]=f;
		}
		System.out.println(solution(n,s,a,b,fares));
	}
	public static ArrayList<Node>[] arr;
	public static PriorityQueue<Node> q=new PriorityQueue<Node>();
	public static int[] dist;//시작점 s에서 각 지점까지의 거리
	public static int result=Integer.MAX_VALUE;
	public static int solution(int n,int s,int a,int b,int[][] fares)
	{
		arr=new ArrayList[n+1];
		for(int i=1;i<=n;i++)
		{
			arr[i]=new ArrayList<Node>();
		}
		for(int[] each:fares)
		{
			int start=each[0];
			int end=each[1];
			int cost=each[2];
			arr[start].add(new Node(end,cost));
			arr[end].add(new Node(start,cost));
		}
		dist=new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s]=0;//시작점은 0
		q.add(new Node(s,0));
		boolean[] visited=new boolean[n+1];
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			if(visited[temp.v])//방문된적이 있다면
			{
				continue;
			}
			visited[temp.v]=true;
			for(Node next:arr[temp.v])
			{
				if(dist[next.v]>dist[temp.v]+next.w)//방문된적 없고 거리가 짧다면
				{
					dist[next.v]=dist[temp.v]+next.w;
					q.add(new Node(next.v,dist[next.v]));
				}
			}
		}
		for(int i=1;i<=n;i++)
		{
			dijkstra(n,i,a,b);
		}
		int answer=result;
		return answer;
	}
	public static void dijkstra(int n,int s,int a,int b)//시작점 n에서 다익스트라
	{
		int[] temp_dist=new int[n+1];
		boolean[] visited=new boolean[n+1];
		Arrays.fill(temp_dist, Integer.MAX_VALUE);
		temp_dist[s]=0;
		q.add(new Node(s,0));
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			if(visited[temp.v])//방문된적이 있다면
			{
				continue;
			}
			visited[temp.v]=true;
			for(Node next:arr[temp.v])
			{
				if(temp_dist[next.v]>temp_dist[temp.v]+next.w)//방문된적 없고 거리가 짧다면
				{
					temp_dist[next.v]=temp_dist[temp.v]+next.w;
					q.add(new Node(next.v,dist[next.v]));
				}
			}
		}
		result=Math.min(result, dist[s]+temp_dist[a]+temp_dist[b]);
	}
}
