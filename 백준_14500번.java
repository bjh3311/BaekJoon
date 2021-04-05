import java.util.*;
import java.io.*;
public class 백준_14500번 {

	public static int[] dx= {0,1,0,-1};
	public static int[] dy= {1,0,-1,0};
	public static int[][] map;
	public static int max;
	public static int N;
	public static int M;
	public static boolean[][] visited;
	public static void DFS(int y,int x,int count,int temp)
	{
		
		if(count==4)
		{
			max=Math.max(max, temp);
			return;
		}
		for(int i=0;i<4;i++)
		{
			int ny=y+dy[i];
			int nx=x+dx[i];
			if(0<=nx&&nx<M&&0<=ny&&ny<N)
			{
				if(!visited[ny][nx])
				{	
					visited[y][x]=true;
					DFS(ny,nx,count+1,temp+map[ny][nx]);
					visited[y][x]=false;
				}		
			}
		}
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		M=Integer.parseInt(s[1]);
		map=new int[N][M];
		visited=new boolean[N][M];
		max=0;
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<M;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				visited[i][j]=true;
				DFS(i,j,1,map[i][j]);
				visited[i][j]=false;
			}
		}//마지막 케이스를 제외하고는 DFS로 구할 수 있다.
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(j+2<M&&i+1<N)
				{
					max=Math.max(max, map[i][j]+map[i+1][j+1]+map[i][j+1]+map[i][j+2]);
				}
				if(j+2<M&&i-1>=0)
				{
					max=Math.max(max, map[i][j]+map[i-1][j+1]+map[i][j+1]+map[i][j+2]);
				}
				if(i+2<N&&j+1<M)
				{
					max=Math.max(max, map[i][j]+map[i+1][j+1]+map[i+1][j]+map[i+2][j]);
				}
				if(i+2<N&&j-1>=0)
				{
					max=Math.max(max, map[i][j]+map[i+1][j-1]+map[i+1][j]+map[i+2][j]);
				}
			}
		}
		System.out.println(max);
	}
}
