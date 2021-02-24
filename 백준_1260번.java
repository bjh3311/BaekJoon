import java.io.*;
import java.util.*;
public class 백준_1260번 {
	public static StringBuilder Dfs_sb=new StringBuilder();
	public static StringBuilder Bfs_sb=new StringBuilder();
	public static int N;//정점의 개수
	public static int M;//간선의 개수
	public static boolean[] visited_dfs;//dfs탐색시 정점을 방문했는지
	public static boolean[] visited_bfs;//bfs탐색시 정점을 방문했는지
	public static int[][] graph;//그래프
	public static void dfs(int count,int start)
	{
		if(count==N)
		{
			return;
		}
		visited_dfs[start]=true;
		for(int i=1;i<=N;i++)
		{
			if(graph[start][i]==1)
			{
				if(!visited_dfs[i])
				{
					Dfs_sb.append(i+" ");
					dfs(count+1,i);
				}
			}
		}
	}
	public static void bfs(int count,int start)
	{
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(start);
		visited_bfs[start]=true;
		while(!q.isEmpty())
		{
			int temp=q.poll();
			for(int i=1;i<=N;i++)
			{
				if(graph[temp][i]==1)
				{
					if(!visited_bfs[i])
					{
						q.add(i);
						visited_bfs[i]=true;
						Bfs_sb.append(i+" ");
					}
				}
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		M=Integer.parseInt(s[1]);
		int start=Integer.parseInt(s[2]);
		visited_dfs=new boolean[N+1];
		visited_bfs=new boolean[N+1];
		graph=new int[N+1][N+1];
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			graph[Integer.parseInt(s[0])][Integer.parseInt(s[1])]=1;
			graph[Integer.parseInt(s[1])][Integer.parseInt(s[0])]=1;
			/*간선에는 가중치가따로명시된게 없으므로 그냥 1로설정*/			
		}
		Dfs_sb.append(start+" ");
		Bfs_sb.append(start+" ");
		dfs(0,start);
		bfs(0,start);
		System.out.println(Dfs_sb.toString());
		System.out.println(Bfs_sb.toString());
		

	}

}
