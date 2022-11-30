import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int y;
	int x;
	int count;//여태까지 걸린 시간
	int size;//상어의 사이즈
	int eat;//먹은 물고기 숫자
	Node(int y,int x,int count,int size,int eat)
	{
		this.y=y;
		this.x=x;
		this.count=count;
		this.size=size;
		this.eat=eat;
	}
	public int compareTo(Node o)
	{
		if(count==o.count)
		{
			if(y==o.y)
			{
				return x-o.x;
			}
			return y-o.y;
		}
		else
		{
			return count-o.count;
		}
	}
}
public class 백준_16236번 {

	public static int[][] map;
	public static int N;
	public static int[] dy= {-1,0,1,0};
	public static int[] dx= {0,-1,0,1};//우선순위를 가장 위, 그 다음은 가장 왼쪽
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		String[] s;
		Queue<Node> q=new LinkedList<Node>();
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
				if(map[i][j]==9)//초기 상어 위치
				{
					q.add(new Node(i,j,0,2,0));
					map[i][j]=0;
				}
			}
		}
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			if(check(temp.size)==0)//먹을 수 있는 물고기가 있는지 확인
			{
				System.out.println(temp.count);
				break;
			}
			PriorityQueue<Node> find=new PriorityQueue<Node>();
			boolean[][] visited=new boolean[N][N];
			find.add(temp);
			while(!find.isEmpty())
			{
				Node now=find.poll();
				if(visited[now.y][now.x])//방문한적 있다면
				{
					continue;
				}
				visited[now.y][now.x]=true;
				if(now.size>map[now.y][now.x]&&map[now.y][now.x]!=0)//더 작은 사이즈의 물고기가 있는 칸에 도착했다면, 또한 빈칸이 아니어야 한다
				{
					if(now.size==now.eat+1)//만약 여기서 먹으면 자기 사이즈만큼 물고기를 먹었다면
					{
						q.add(new Node(now.y,now.x,now.count,now.size+1,0));
					}
					else
					{
						q.add(new Node(now.y,now.x,now.count,now.size,now.eat+1));
					}
					map[now.y][now.x]=0;
					break;
				}
				for(int i=0;i<4;i++)
				{
					int ny=now.y+dy[i];
					int nx=now.x+dx[i];
					if(ny<0||ny>=N||nx<0||nx>=N)//맵에서 벗어났다면
					{
						continue;
					}
					if(map[ny][nx]<=now.size)//사이즈가 같거나 작은경우에만, 또는 빈칸인경우에만 이동 할 수 있다.
					{
						find.add(new Node(ny,nx,now.count+1,now.size,now.eat));
					}
				}
			}
			if(q.isEmpty())//길이 막혀있다면
			{
				System.out.println(temp.count);
			}
		}
	}
	public static int check(int size)//먹을 수 있는 물고기가 있는지 map을 확인
	{
		int count=0;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(map[i][j]!=0&&size>map[i][j])//빈칸이 아니고 아기상어의 크기보다 작은 물고기가 있는 칸
				{
					count++;
				}
			}
		}
		return count;
	}

}
