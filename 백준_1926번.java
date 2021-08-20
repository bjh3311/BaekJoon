import java.util.*;
import java.io.*;
public class น้มุ_1926น๘ {
	public static int[] dx= {-1,1,0,0};
	public static int[] dy= {0,0,-1,1};
	public static int n;
	public static int m;
	public static int ans=0;
	public static void BFS(int y,int x)
	{
		visited[y][x]=true;
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(y);
		q.add(x);
		int area=1;
		while(!q.isEmpty())
		{
			int cy=q.poll();
			int cx=q.poll();
			for(int i=0;i<4;i++)
			{
				int ny=cy+dy[i];
				int nx=cx+dx[i];
				if(ny>=0&&ny<n&&nx>=0&&nx<m)
				{
					if(!visited[ny][nx]&&map[ny][nx]==1)
					{
						area++;
						visited[ny][nx]=true;
						q.add(ny);
						q.add(nx);
					}
				}
			}
		}
		ans=Math.max(ans, area);
	}
	public static int[][] map;
	public static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		n=Integer.parseInt(s[0]);
		m=Integer.parseInt(s[1]);
		visited=new boolean[n][m];
		map=new int[n][m];
		int count=0;
		for(int i=0;i<n;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<m;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(!visited[i][j]&&map[i][j]==1)
				{
					BFS(i,j);
					count++;
				}
			}
		}
		System.out.println(count+"\n"+ans);
	}
}