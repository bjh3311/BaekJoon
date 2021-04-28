import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int vertex;
	int weight;
	public Node(int vertex,int weight)
	{
		this.vertex=vertex;
		this.weight=weight;
	}
	public int compareTo(Node o)
	{
		return weight-o.weight;
	}//우선순위큐에 넣을 때 간선의 가중치가 작은것이 큰 우선순위를 갖도록 구현
}
public class 백준_10282번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T>0)
		{
			String[] s=br.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int d=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);//시작점
			ArrayList<Node>[] arr=new ArrayList[n+1];
			boolean[] visited=new boolean[n+1];
			int[] dis=new int[n+1];
			Arrays.fill(dis, Integer.MAX_VALUE);
			for(int i=1;i<=n;i++)
			{
				arr[i]=new ArrayList<Node>();
			}
			for(int i=0;i<d;i++)
			{
				s=br.readLine().split(" ");
				int v1=Integer.parseInt(s[0]);
				int v2=Integer.parseInt(s[1]);
				int w=Integer.parseInt(s[2]);
				arr[v2].add(new Node(v1,w));
			}
			PriorityQueue<Node> q=new PriorityQueue<Node>();
			dis[c]=0;
			q.add(new Node(c,0));
			while(!q.isEmpty())
			{
				Node temp=q.poll();
				int v=temp.vertex;
				if(!visited[v])
				{
					for(int i=0;i<arr[v].size();i++)
					{
						int next=arr[v].get(i).vertex;
						if(!visited[next]&&dis[next]>dis[v]+arr[v].get(i).weight)
						{
							dis[next]=dis[v]+arr[v].get(i).weight;
							q.add(new Node(next,dis[next]));
						}
					}
				}
				visited[temp.vertex]=true;
			}//일반적인 다익스트라
			int count=0;//감염된 갯수 세는 용
			int max=0;//c에서 시작해서 도달 할 수 있는 정점중 가장 큰값
			for(int i=1;i<=n;i++)
			{
				if(dis[i]!=Integer.MAX_VALUE)//Integer.MAX_VALUE가 아니라는것은 감염되었다는 뜻이다
				{
					count++;
					max=Math.max(max, dis[i]);
				}
			}
			System.out.println(count+" "+max);
			T--;
		}

	}
}
