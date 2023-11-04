import java.util.*;
import java.io.*;

class Node
{
	int v;
	int w;
	Node(int v, int w)
	{
		this.v=v;
		this.w=w;
	}
}

public class 백준_1761번 {

	public static ArrayList<Node>[] arr;
	public static int N;
	public static int[] Depth; // 깊이
	public static int[][] parent;// parent[0][3] 은 3번 노드의 2의0승 부모, 
	//parent[5][3]은 3번 노드의 2의 5승부모, 즉 32번째 부모
	public static int[][] length;// length[5][3] 은 3번 노드부터 2의0승 부모까지의 길이
	public static int LogN = 17;// 2의 몇제곱까지 계산할지를 결정
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		String[] s;
		arr = new ArrayList[N+1];
		parent = new int[LogN+1][N+1];
		Depth = new int[N+1];
		length = new int[LogN+1][N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i] = new ArrayList<Node>();
		}
		for(int i=0;i<N-1;i++)
		{
			s=br.readLine().split(" ");
			int u=Integer.parseInt(s[0]);
			int v=Integer.parseInt(s[1]);
			int w=Integer.parseInt(s[2]);
			arr[u].add(new Node(v,w));
			arr[v].add(new Node(u,w));
		}
		BFS();//트리 생성
		for(int i=1;i<=LogN;i++)//2의n승 부모와 , 그 부모까지의 거리
		{
			for(int j=1;j<=N;j++)
			{
				parent[i][j]=parent[i-1][parent[i-1][j]];
				length[i][j]=length[i-1][j]+length[i-1][parent[i-1][j]];
			}
		}
		int M=Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int u = Integer.parseInt(s[0]);
			int v = Integer.parseInt(s[1]);
			if(Depth[u]<Depth[v])//오른쪽인자가 더 깊이가 깊게
			{
				System.out.println(dist(u,v));
			}
			else
			{
				System.out.println(dist(v,u));
			}
		}

	}
	public static void BFS()//트리 만들기, 루트 노드는 1번으로
	{
		Queue<Integer> q=new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		q.add(1);
		Depth[1]=0;
		while(!q.isEmpty())
		{
			int temp = q.poll();//현재 노드번호
			if(visited[temp])
			{
				continue;
			}
			visited[temp]=true;
			for(Node next : arr[temp])
			{
				if(visited[next.v])//부모로 역행 막아준다
				{
					continue;
				}
				Depth[next.v]=Depth[temp]+1;;
				parent[0][next.v]=temp;
				length[0][next.v]=next.w;
				q.add(next.v);
			}
		}
	}
	public static int log(int value)
	{
		int k=0;
		while((1<<k<=value))
		{
			k++;
		}
		return k-1;
	}
	
	public static int dist(int u,int v)//u와 v의 경로의 비용
	{
		int result = 0;
		while(Depth[u]!=Depth[v])
		{
			int temp= Depth[v]-Depth[u];
			result = result + length[log(temp)][v];
			v=parent[log(temp)][v];
		}
		if(u==v)
		{
			return result;
		}
		for(int i = LogN; i>=0; i--)
		{
			if(parent[i][u]!=parent[i][v])
			{
				result = result + length[i][u];
				u = parent[i][u];
				result = result + length[i][v];
				v = parent[i][v];
			}
		}
		return result + length[0][u] +length[0][v];
	}
}
