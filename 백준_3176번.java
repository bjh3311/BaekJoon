import java.util.*;
import java.io.*;

class Node
{
	int V;
	int W;
	public Node(int V,int W)
	{
		this.V=V;
		this.W=W;
	}
}
public class 백준_3176번 {

	public static int[][] parent;//2의 몇승 부모를 저장할 예정
	public static int[][] Max;//2의 몇승 부모까지의 가장 긴 도로
	public static int[][] Min;//2의 몇승 부모까지의 가장 짧은 도로
	public static int[] Depth;//깊이 저장
	public static boolean[] visited;
	public static ArrayList<Node>[] tree;
	public static int LogN=17;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Depth=new int[N+1];
		visited=new boolean[N+1];
		parent=new int[18][N+1];
		Max=new int[18][N+1];
		Min=new int[18][N+1];
		String[] s;
		tree=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			tree[i]=new ArrayList<Node>();
		}
		for(int i=0;i<N-1;i++)
		{
			s=br.readLine().split(" ");
			int A=Integer.parseInt(s[0]);
			int B=Integer.parseInt(s[1]);
			int W=Integer.parseInt(s[2]);	
			tree[A].add(new Node(B,W));
			tree[B].add(new Node(A,W));
		}
		BFS();//트리 형성
		for(int i=1;i<=LogN;i++)//각 노드상대로 2의 몇승부모는 누구인지, 2의 몇승부모까지의 가장 긴 도로 가장 짧은 도로 구하기
		{
			for(int j=1;j<=N;j++)
			{
				parent[i][j]=parent[i-1][parent[i-1][j]];
				Max[i][j]=Math.max(Max[i-1][j], Max[i-1][parent[i-1][j]]);
				Min[i][j]=Math.min(Min[i-1][j], Min[i-1][parent[i-1][j]]);
			}
		}
		int K=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<K;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			if(Depth[a]>Depth[b])
			{
				LCA(b,a);//첫 번째 인수가 깊이가 더 낮게(더 작게) 구현
			}
			else
			{
				LCA(a,b);
			}
			
		}
	}
	public static void BFS()//깊이 및 부모 저장, 1번을 루트 노드로 잡을 것이다
	{
		Depth[1]=0;//높이는 0부터
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(1);
		while(!q.isEmpty())
		{
			int now=q.poll();
			if(visited[now])//방문된적이 있다면
			{
				continue;
			}
			visited[now]=true;//방문 처리
			for(Node nextNode:tree[now])
			{
				int next=nextNode.V;
				if(visited[next])//부모로 다시 역행하는걸 막아준다
				{
					continue;
				}
				Depth[next]=Depth[now]+1;
				parent[0][next]=now;
				Min[0][next]=nextNode.W;
				Max[0][next]=nextNode.W;
				q.add(next);
			}
		}
	}
	public static int log(int N)//LCA함수에서 몇칸 올라갸야 되는지 계산
	{
		int temp=0;
		while(Math.pow(2, temp)<=N)
		{
			temp++;
		}
		return temp-1;
	}
	public static void LCA(int a,int b)//b의 깊이가 더 깊게 구현
	{
		int max_result=Integer.MIN_VALUE;
		int min_result=Integer.MAX_VALUE;
		while(Depth[a]!=Depth[b])//둘의 깊이가 다르다면 맞춰준다, 이것도 2의 N승으로 올라가주자
		{
			int temp=Depth[b]-Depth[a];
			max_result=Math.max(max_result, Max[log(temp)][b]);
			min_result=Math.min(min_result, Min[log(temp)][b]);
			b=parent[log(temp)][b];
		}
		if(a==b)//높이를 맞춰줬는데 만약 똑같은 수라면, 그냥 이대로 결과 출력하고 끝낸다.
		{
			System.out.println(min_result+" "+max_result);
			return ;
		}
		for(int i=17;i>=0;i--)
		{
			if(parent[i][a]!=parent[i][b])
			{
				max_result=Three_Max(Max[i][a], Max[i][b],max_result);
				min_result=Three_Min(Min[i][a],Min[i][b],min_result);
				a=parent[i][a];
				b=parent[i][b];
			}
		}
		max_result=Three_Max(Max[0][a], Max[0][b],max_result);
		min_result=Three_Min(Min[0][a],Min[0][b],min_result);//모든 절차가 끝나면 
		System.out.println(min_result+" "+max_result);
	}
	public static int Three_Max(int a,int b,int c)//세 숫자중 가장 큰 숫자 반환
	{
		if(a>=b&&a>=c)
		{
			return a;
		}
		else if(b>=a&&b>=c)
		{
			return b;
		}
		else
		{
			return c;
		}
	}
	public static int Three_Min(int a,int b,int c)//세 숫자중 가장 작은 숫자 반환
	{
		if(a<=b&&a<=c)
		{
			return a;
		}
		else if(b<=a&&b<=c)
		{
			return b;
		}
		else 
		{
			return c;
		}
	}
}
