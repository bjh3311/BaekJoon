import java.util.*;
import java.io.*;
public class 백준_2573번 {
	public static int N;
	public static int M;
	public static int[][] map;
	public static int[] dx= {-1,0,1,0};
	public static int[] dy= {0,1,0,-1};
	public static boolean[][] visited;
	public static int count()//현재 빙하가 몇개인지 세는 함수
	{
		int result=0;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(!visited[i][j]&&map[i][j]!=0)
				{
					DFS(i,j);
					result++;
				}
			}
		}
		return result;
	}
	public static void DFS(int y,int x)
	{
		visited[y][x]=true;
		for(int i=0;i<4;i++)
		{
			int ny=y+dy[i];
			int nx=x+dx[i];
			if(ny>=0&&ny<N&&nx>=0&&nx<M)//맵안에 있다면
			{
				if(!visited[ny][nx]&&map[ny][nx]!=0)
				{
					DFS(ny,nx);
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
		Queue<Integer> q=new LinkedList<Integer>();
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<M;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
				if(map[i][j]!=0)//빙산의 위치는 미리 저장
				{
					q.add(i);
					q.add(j);
				}
			}
		}
		int[] dx= {-1,0,1,0};
		int[] dy= {0,1,0,-1};
		int result=0;
		while(true)
		{
			visited=new boolean[N][M];
			int count=count();
			if(count==0)
			{
				System.out.println(0);
				System.exit(0);
			}
			if(count!=1)
			{
				break;
			}
			boolean[][] temp_visited=new boolean[N][M];
			int size=q.size();
			for(int k=0;k<size/2;k++)
			{
				int sea=0;
				int y=q.poll();
				int x=q.poll();
				temp_visited[y][x]=true;
				for(int i=0;i<4;i++)
				{
					int ny=y+dy[i];
					int nx=x+dx[i];
					if(map[ny][nx]==0&&!temp_visited[ny][nx])
					{
						sea++;
					}
				}
				if(map[y][x]-sea<=0)
				{
					map[y][x]=0;
				}
				else
				{
					map[y][x]=map[y][x]-sea;
					q.add(y);
					q.add(x);
				}
			}
			result++;
		}
		System.out.println(result);
	}
}
