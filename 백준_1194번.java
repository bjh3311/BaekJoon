import java.util.*;
import java.io.*;
class Node
{
	int y;
	int x;
	int count;
	int bit;
	Node(int y,int x,int count,int bit)
	{
		this.y=y;
		this.x=x;
		this.count=count;
		this.bit=bit;
	}
}

public class 백준_1194번 {

	public static int[] dy= {-1,1,0,0};
	public static int[] dx= {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		char[][] map=new char[N][M];
		boolean[][][] visited=new boolean[N][M][64];
		Queue<Node> q=new LinkedList<Node>();
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split("");
			for(int j=0;j<M;j++)
			{
				map[i][j]=s[j].charAt(0);
				if(map[i][j]=='0')
				{
					q.add(new Node(i,j,0,0));
				}
			}
		}
		int result=-1;
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			if(map[temp.y][temp.x]=='1')
			{
				result=temp.count;
				break;
			}
			if(visited[temp.y][temp.x][temp.bit])
			{
				continue;
			}
			visited[temp.y][temp.x][temp.bit]=true;
			for(int i=0;i<4;i++)
			{
				int ny=temp.y+dy[i];
				int nx=temp.x+dx[i];
				if(ny<0||ny>=N||nx<0||nx>=M)//다음 칸이 맵 안에 있어야 한다
				{
					continue;
				}
				if(map[ny][nx]=='#')//벽이면 이동 할 수 없다
				{
					continue;
				}
				if(map[ny][nx]=='.'||map[ny][nx]=='0'||map[ny][nx]=='1')//빈 칸이면 이동 할 수 있다
				{
					q.add(new Node(ny,nx,temp.count+1,temp.bit));
				}
				if(map[ny][nx] - 'a'>=0&&map[ny][nx]-'a'<=5)//열쇠를 만났다면
				{
					int nbit= temp.bit | (1<<map[ny][nx]-'a');
					q.add(new Node(ny,nx,temp.count+1,nbit));
				}
				if(map[ny][nx] - 'A'>=0&& map[ny][nx] - 'A'<=5)
				{
					int nbit= 1 << map[ny][nx]-'A';
					if(nbit==(nbit & temp.bit))
					{
						q.add(new Node(ny,nx,temp.count+1,temp.bit));
					}
				}
			}
		}
		System.out.println(result);
		
	}

}
