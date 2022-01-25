import java.util.*;
import java.io.*;
public class DAY7_LCA2 {

	public static boolean[] visited;
	public static ArrayList<Integer>[] arr;
	public static int[] DEPTH;
	public static int LogN=17;//2의 몇제곱까지 계산할지를 결정. 문제에서는 10만이니 17승로 설정하자
	public static int[][] parent;//부모를 표현한다
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String[] s;
		arr=new ArrayList[N+1];
		parent=new int[LogN+1][N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<N-1;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			arr[a].add(b);
			arr[b].add(a);
		}
		visited=new boolean[N+1];
		DEPTH=new int[N+1];
		BFS(1,0);//루트노드 1의 깊이는 0. 각 노드별로 깊이를 구해준다
		for(int i=1;i<=LogN;i++)//2의 n승 부모를 구해준다
		{
			for(int j=1;j<=N;j++)
			{
				parent[i][j]=parent[i-1][parent[i-1][j]];
			}
		}
		int M=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			if(DEPTH[a]>DEPTH[b])
			{
				sb.append(getLCA(a,b)+"\n");//a의 깊이가 b보다 깊다고 생각하고 구현한다
			}
			else//만약 b의 깊이가 a보다 깊다면
			{
				sb.append(getLCA(b,a)+"\n");//a의 깊이가 b보다 깊다고 생각하고 구현한다
			}
			
		}
		System.out.print(sb.toString());
		
		
	}
	public static void BFS(int start,int depth)//각각의 깊이를 구해준다
	{
		DEPTH[start]=depth;
		visited[start]=true;
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(1);//1번점 넣는다
		while(!q.isEmpty())
		{
			int now=q.poll();
			for(int next:arr[now])
			{
				if(!visited[next])//방문된적없다면
				{
					visited[next]=true;
					DEPTH[next]=DEPTH[now]+1;
					parent[0][next]=now;//부모도 구해준다
					q.add(next);
				}
			}
		}
	}
	public static int log(int value)
	{
		int k=0;
		while(Math.pow(2, k)<=value)
		{
			k++;
		}
		return k-1;
	}
	public static int getLCA(int a,int b)
	{
		//a노드의 깊이를 b노드의 깊이까지 올려서 두 노드의 깊이를 맞춰준다
		while(DEPTH[a]!=DEPTH[b])//높이를 맞춘다
		{
			int temp=DEPTH[a]-DEPTH[b];
			a=parent[log(temp)][a];
		}
		if(a==b)
		{
			return a;
		}
		//공통조상이 아닐 떄 까지 부모를 따라 올라간다
		//최종적으로는 LCA 바로 밑깐까지만 올라간다
		for(int i=LogN;i>=0;i--)
		{
			if(parent[i][a]!=parent[i][b])
			{
				a=parent[i][a];
				b=parent[i][b];
			}
		}
		return parent[0][a];
	}
}
