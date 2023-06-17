import java.util.*;
import java.io.*;

class Node
{
	int y;
	int x;
	int count;
	Node(int y,int x,int count)
	{
		this.y=y;
		this.x=x;
		this.count=count;
	}
}
class kru implements Comparable<kru>
{
	int u;
	int v;
	int w;
	kru(int u,int v,int w)
	{
		this.u=u;
		this.v=v;
		this.w=w;
	}
	public int compareTo(kru o)
	{
		return w-o.w;
	}
}
public class 백준_1944번 {

	public static int[] dy= {1,-1,0,0};
	public static int[] dx= {0,0,-1,1};
	public static char[][] map;
	public static int N;
	public static int M;
	public static ArrayList<Node> arr;
	public static PriorityQueue<kru> pq;
	public static int[] parent;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		M=Integer.parseInt(s[1]);
		map=new char[N][N];
		arr=new ArrayList<Node>();
		parent=new int[M+1];
		pq=new PriorityQueue<kru>();
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split("");
			for(int j=0;j<N;j++)
			{
				map[i][j]=s[j].charAt(0);
				if(map[i][j]=='S'||map[i][j]=='K')
				{
					arr.add(new Node(i,j,0));
				}
			}
		}
		for(int i=0;i<=M;i++)
		{
			BFS(i);
		}//각 노드간의 간선을 만들어준다
		for(int i=0;i<=M;i++)//부모 초기화
		{
			parent[i]=i;
		}
		int result=0;
		while(!pq.isEmpty())
		{
			kru temp=pq.poll();
			int u=Find(temp.u);
			int v=Find(temp.v);
			if(u==v)//부모가 같다면
			{
				continue;
			}
			Union(u,v);
			result=result+temp.w;
		}
		for(int i=0;i<=M;i++)
		{
			if(parent[i]!=0)
			{
				System.out.println("-1");
				return;
			}
		}
		System.out.println(result);
	}
	public static int Find(int n)
	{
		if(parent[n]==n)
		{
			return n;
		}
		return parent[n]=Find(parent[n]);
	}
	public static void Union(int a,int b)
	{
		a=Find(a);
		b=Find(b);
		if(a<b)
		{
			parent[b]=a;
		}
		else
		{
			parent[a]=b;
		}
	}
	public static void BFS(int num)
	{
		boolean[][] visited=new boolean[N][N];
		Queue<Node> q=new LinkedList<Node>();
		q.add(new Node(arr.get(num).y,arr.get(num).x,0));
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			int y=temp.y;
			int x=temp.x;
			if(visited[y][x])
			{
				continue;
			}
			visited[y][x]=true;
			for(int i=0;i<4;i++)
			{
				int ny=y+dy[i]; 
				int nx=x+dx[i];
				if(ny<0||ny>=N||nx<0||nx>=N)//맵 밖을 벗어났다면
				{
					continue;
				}
				if(map[ny][nx]=='1'||visited[ny][nx])//벽이거나 방문된적이 있다면
				{
					continue;
				}
				if(map[ny][nx]=='S'||map[ny][nx]=='K')//노드를 만난다면
				{
					for(int j=0;j<=M;j++)
					{
						if(arr.get(j).y==ny&&arr.get(j).x==nx)
						{
							pq.offer(new kru(num,j,temp.count+1));
						}
					}
				}
				q.offer(new Node(ny,nx,temp.count+1));
			}
		}
	}
}