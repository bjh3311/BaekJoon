import java.io.*;
import java.util.*;
public class ����_1260�� {
	public static StringBuilder Dfs_sb=new StringBuilder();
	public static StringBuilder Bfs_sb=new StringBuilder();
	public static int N;//������ ����
	public static int M;//������ ����
	public static boolean[] visited_dfs;//dfsŽ���� ������ �湮�ߴ���
	public static boolean[] visited_bfs;//bfsŽ���� ������ �湮�ߴ���
	public static int[][] graph;//�׷���
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
			/*�������� ����ġ�����θ�õȰ� �����Ƿ� �׳� 1�μ���*/			
		}
		Dfs_sb.append(start+" ");
		Bfs_sb.append(start+" ");
		dfs(0,start);
		bfs(0,start);
		System.out.println(Dfs_sb.toString());
		System.out.println(Bfs_sb.toString());
		

	}

}
