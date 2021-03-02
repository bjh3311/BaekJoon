import java.util.*;
import java.io.*;
public class น้มุ_2606น๘ {
	public static int[][] net;
	public static int N;
	public static int M;
	public static int count=0;
	public static boolean[] visited;
	public static void BFS(int start)
	{
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(start);
		visited[start]=true;
		while(!q.isEmpty())
		{
			int temp=q.poll();
			for(int i=1;i<=N;i++)
			{
				if((net[temp][i]==1||net[i][temp]==1)&&!visited[i])
				{
					q.add(i);
					visited[i]=true;
					count++;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
	    M=Integer.parseInt(br.readLine());
	    visited=new boolean[N+1];
		net=new int[N+1][N+1];
		for(int i=0;i<M;i++)
		{
			String[] s=br.readLine().split(" ");
			net[Integer.parseInt(s[0])][Integer.parseInt(s[1])]=1;
		}
		BFS(1);
		System.out.println(count);
	}

}
