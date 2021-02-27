import java.util.*;
import java.io.*;
public class 백준_2458번 {
	public static int[][] arr;//인접행렬
	public static boolean[] visited;
	public static int N;//학생 수(정점의 수)
	public static int M;//간선 개수
	public static int ans;
	public static int count=0;//방문한 정점의 개수
	public static void dfs(int start)
	{
		visited[start]=true;
		for(int j=1;j<=N;j++)
		{
			if(arr[start][j]==1&&!visited[j])//방문된적없고 간선이 존재한다면
			{
				visited[j]=true;
				count++;
				dfs(j);
			}
		}
		
	}
	public static void dfs_reverse(int start)
	{
		visited[start]=true;
		for(int j=1;j<=N;j++)
		{
			if(arr[j][start]==1&&!visited[j])//방문된적없고 간선이 존재한다면
			{
				visited[j]=true;
				count++;
				dfs_reverse(j);
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		M=Integer.parseInt(s[1]);
		arr=new int[N+1][N+1];
		visited=new boolean[N+1];
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			arr[Integer.parseInt(s[0])][Integer.parseInt(s[1])]=1;
		}
		for(int i=1;i<=N;i++)
		{
			dfs(i);
			for(int j=1;j<=N;j++)
			{
				visited[j]=false;
			}
			dfs_reverse(i);
			for(int j=1;j<=N;j++)
			{
				visited[j]=false;
			}
			if(count==N-1)
			{
				ans++;
			}//모든 정점을 돌았다면
			count=0;
		}
		System.out.println(ans);

	}

}
