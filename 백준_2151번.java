import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int y;
	int x;
	int dir;//0이면 위,1 이면 아래, 2이면 왼쪽, 3이면 오른쪽
	int count;
	Node(int y,int x,int dir,int count)
	{
		this.y=y;
		this.x=x;
		this.dir=dir;
		this.count=count;
	}
	public int compareTo(Node o)
	{
		return count-o.count;
	}
}
public class 백준_2151번 {

	public static char[][] map;
	public static int sx,sy,ex,ey;
	public static int[] dy= {1,-1,0,0};
	public static int[] dx= {0,0,-1,1};
	public static int N;
	public static void main(String[] args) throws IOException{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new char[N][N];
		int idx=0;
		for(int i=0;i<N;i++)
		{
			String s=br.readLine();
			for(int j=0;j<N;j++)
			{
				map[i][j]=s.charAt(j);
				if(map[i][j]=='#')//입구 넣어줌
				{	
					if(idx==0)
					{
						sy=i;
						sx=j;
					}
					else
					{
						ey=i;
						ex=j;
					}
					idx++;
				}
			}
		}
		BFS();
	}
	public static void BFS()
	{
		PriorityQueue<Node> pq=new PriorityQueue<Node>();
		boolean[][][] visited=new boolean[N][N][4];
		for(int i=0;i<4;i++)
		{
			pq.add(new Node(sy,sx,i,0));
		}
		while(!pq.isEmpty())
		{
			Node temp=pq.poll();
			if(temp.y==ey&&temp.x==ex)
			{
				System.out.println(temp.count);
				return;
			}
			visited[temp.y][temp.x][temp.dir]=true;//방문처리
			int ny=temp.y+dy[temp.dir];
			int nx=temp.x+dx[temp.dir];
			if(ny>=0&&ny<N&&nx>=0&&nx<N&&!visited[ny][nx][temp.dir]&&map[ny][nx]!='*')
			{
				if(map[ny][nx]=='!')//거울이라면
				{
					if(temp.dir==0||temp.dir==1)//위나 아래였다면
					{
						pq.add(new Node(ny,nx,2,temp.count+1));
						pq.add(new Node(ny,nx,3,temp.count+1));
					}
					else
					{
						pq.add(new Node(ny,nx,0,temp.count+1));
						pq.add(new Node(ny,nx,1,temp.count+1));
					}
				}
				pq.add(new Node(ny,nx,temp.dir,temp.count));
			}//맵 안에 있는지, 방문한적이 있는지, 빛이 통과 할 수 있는지
			
		}
	}
}
