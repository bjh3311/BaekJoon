import java.util.*;
import java.io.*;

class Point
{
	int y;
	int x;
	int type;//0이면 물 1이면 고슴도치
	public Point(int y,int x,int type)
	{
		this.y=y;
		this.x=x;
		this.type=type;
	}
}
public class DAY1_탈출 {

	public static String[][] map;
	public static int[][] water_map;
	public static int[] dx= {-1,1,0,0};
	public static int[] dy= {0,0,1,-1};
	public static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int R=Integer.parseInt(s[0]);
		int C=Integer.parseInt(s[1]);
		water_map=new int[R][C];
		map=new String[R][C];
		visited=new boolean[R][C];
		Queue<Point> q=new LinkedList<Point>();
		visited=new boolean[R][C];
		Point st=null;
		for(int i=0;i<R;i++)//맵 입력
		{
			s=br.readLine().split("");
			for(int j=0;j<C;j++)
			{
				map[i][j]=s[j];
				if(map[i][j].equals("*"))
				{
					q.add(new Point(i,j,0));
				}
				if(map[i][j].equals("S"))
				{
					st=new Point(i,j,1);
				}
			}
		}
		int[][] dp=new int[R][C];
		q.add(st);//시작점은 가장 나중에
		while(!q.isEmpty())
		{
			Point p=q.poll();
			if(p.type==1&&map[p.y][p.x].equals("D"))
			{
				System.out.println(dp[p.y][p.x]);
				System.exit(0);
			}
			for(int i=0;i<4;i++)
			{
				int ny=p.y+dy[i];
				int nx=p.x+dx[i];
				if(ny>=0&&ny<R&&nx>=0&&nx<C)//맵 안에 있는지 체크
				{
					if(p.type==1)//고슴도치 일경우
					{
						if(dp[ny][nx]==0&&!map[ny][nx].equals("*")&&!map[ny][nx].equals("X"))
						{
							dp[ny][nx]=dp[p.y][p.x]+1;
							q.add(new Point(ny,nx,1));
						}
					}
					else if(p.type==0)
					{
						if(map[ny][nx].equals(".")||map[ny][nx].equals("S"))
						{
							map[ny][nx]="*";
							q.add(new Point(ny,nx,0));
						}
					}
				}
			}	
		}
		System.out.println("KAKTUS");
	}
}
