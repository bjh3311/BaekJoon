import java.util.*;
import java.io.*;

class Node implements Comparable<Node>
{
	int vertex;
	int weight;
	Node(int vertex,int weight)
	{
		this.vertex=vertex;
		this.weight=weight;
	}
	@Override
	public int compareTo(Node o)
	{
		return weight-o.weight;
	}//우선순위 큐에 넣을때 간선이 짧은게 가장 큰 우선순위를 갖도록 구현
}
public class 백준_1504번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		ArrayList<Node>[] arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Node>();
		}
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);
			arr[a].add(new Node(b,c));
			arr[b].add(new Node(a,c));//양방향 그래프이기 때문에
		}
		s=br.readLine().split(" ");
		int des1=Integer.parseInt(s[0]);//지나야 되는 두 정점중 첫번째
		int des2=Integer.parseInt(s[1]);//지나야 되는 두 정점중 두번째
		boolean[] visited=new boolean[N+1];
		int[] dis=new int[N+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[1]=0;
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		q.add(new Node(1,0));//시작점 1에서부터 시작
		while(!q.isEmpty())//시작점에서 다익스트라를 실시한다.
		{
			Node temp=q.poll();
			int v=temp.vertex;
			if(!visited[v])
			{
				for(int i=0;i<arr[v].size();i++)
				{
					Node next=arr[v].get(i);
					if(!visited[next.vertex]&&dis[next.vertex]>dis[v]+next.weight)
					{
						dis[next.vertex]=dis[v]+next.weight;
						q.add(new Node(next.vertex,dis[next.vertex]));
					}
				}
			}
			visited[v]=true;
		}
		int route1_1=dis[des1];//지나야되는 두 정점중 시작점에서부터 첫번째 정점까지의 거리
		int route2_1=dis[des2];//지나야되는 두 정점중 시작점에서부터 두번째 정점까지의 거리
		Arrays.fill(visited, false);
		Arrays.fill(dis, Integer.MAX_VALUE);
		q.clear();
		q.add(new Node(des1,0));//지나야되는 두 정점중 첫번째부터 시작
		dis[des1]=0;
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			int v=temp.vertex;
			if(!visited[v])
			{
				for(int i=0;i<arr[v].size();i++)
				{
					Node next=arr[v].get(i);
					if(!visited[next.vertex]&&dis[next.vertex]>dis[v]+next.weight)
					{
						dis[next.vertex]=dis[v]+next.weight;
						q.add(new Node(next.vertex,dis[next.vertex]));
					}
				}
			}
			visited[v]=true;
		}
		int between=dis[des2];//지나야 되는 두 정점사이의 거리
		int route2_2=dis[N];//des1에서 최종 목적지 N까지의 거리
		Arrays.fill(visited, false);
		Arrays.fill(dis, Integer.MAX_VALUE);
		q.clear();
		q.add(new Node(des2,0));
		dis[des2]=0;
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			int v=temp.vertex;
			if(!visited[v])
			{
				for(int i=0;i<arr[v].size();i++)
				{
					Node next=arr[v].get(i);
					if(!visited[next.vertex]&&dis[next.vertex]>dis[v]+next.weight)
					{
						dis[next.vertex]=dis[v]+next.weight;
						q.add(new Node(next.vertex,dis[next.vertex]));
					}
				}
			}
			visited[v]=true;
		}
		int route1_2=dis[N];//des2에서 최종 목적지 N까지의 거리
		long route1=(long)(route1_1+route1_2+between);
		long route2=(long)(route2_1+route2_2+between);
		//long으로 바꾼것은 Integer.MAX_VALUE가 들어가 있으면 Int형을 넘어서 그렇다.
		if(route1>=1000000&&route2>=1000000)
		{
			System.out.println("-1");
		}//왜 하필100만으로 설정햇는가? 정점 간 거리는 1000이 최대고 정점은 최대 800개. 정점 간 최단거리는 무조건 80만 이하다
		else
		{
			System.out.println(Math.min(route1, route2));
		}
	}
}
