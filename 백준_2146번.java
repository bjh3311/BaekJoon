import java.util.*;
import java.io.*;
class Node
{
	int x;
	int y;
	int count;
	public Node(int x,int y,int count)
	{
		this.x=x;
		this.y=y;
		this.count=count;
	}
}
public class 백준_2146번 {
	public static void make_group(int num,int x,int y)//10,20,30....으로 그룹으로 만들음
	{
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(y);
		q.add(x);
		visited[y][x]=true;
		group[y][x]=num;
		while(!q.isEmpty())
		{
			int ny=q.poll();
			int nx=q.poll();
			for(int i=0;i<4;i++)
			{
				int next_y=ny+dy[i];
				int next_x=nx+dx[i];
				if(next_y>=0&&next_y<N&&next_x>=0&&next_x<N&&map[next_y][next_x]!=0)
				{
					if(!visited[next_y][next_x])
					{
						q.add(next_y);
						q.add(next_x);
						visited[next_y][next_x]=true;
						group[next_y][next_x]=num;
					}
				}
			}
		}
	}
	public static void BFS(int num,int x,int y)
	{
		Queue<Node> q=new LinkedList<Node>();
		q.add(new Node(x,y,0));
		visited[y][x]=true;
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			for(int i=0;i<4;i++)
			{
				int ny=temp.y+dy[i];
				int nx=temp.x+dx[i];
				if(ny>=0&&ny<N&&nx>=0&&nx<N)//map안에 있다면
				{
					if(group[ny][nx]==0&&!visited[ny][nx])
					{
						q.add(new Node(nx,ny,temp.count+1));
						visited[ny][nx]=true;
					}
					if(group[ny][nx]!=0&&group[ny][nx]!=num)
					{
						result=Math.min(result, temp.count);
					}
				}
			}
		}
	}
	public static int result=Integer.MAX_VALUE;
	public static int N;
	public static int[] dx= {1,-1,0,0};
	public static int[] dy= {0,0,1,-1};
	public static boolean[][] visited;
	public static int[][] map;
	public static int[][] group;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		group=new int[N][N];
		visited=new boolean[N][N];
		String[] s;
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		int num=10;
		for(int i=0;i<N;i++)//그룹만들기
		{
			for(int j=0;j<N;j++)
			{
				if(map[i][j]==1&&!visited[i][j])
				{
					make_group(num,j,i);
					num=num+10;
				}
			}
		}
		for(int i=0;i<N;i++)//방문체크 배열 초기화
		{
			for(int j=0;j<N;j++)
			{
				visited[i][j]=false;
			}
			
		}
		for(int i=0;i<N;i++)//최소값 찾기
		{
			for(int j=0;j<N;j++)
			{
				if(group[i][j]!=0&&!visited[i][j])
				{
					visited=new boolean[N][N];//초기화
					BFS(group[i][j],j,i);
				}
			}
		}
		System.out.println(result);

	}

}
