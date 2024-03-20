import java.util.*;
import java.io.*;

class Node
{
	int y;
	int x;
	int dir;
	Node(int y,int x,int dir)
	{
		this.y=y;
		this.x=x;
		this.dir=dir;
	}
}
public class 백준_14503번 {

	public static int[] dy = {-1,0,1,0};
	public static int[] dx = {0,1,0,-1};
	public static int[][] map;
	public static int N;
	public static int M;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		M=Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		int r = Integer.parseInt(s[0]);
		int c = Integer.parseInt(s[1]);
		int d = Integer.parseInt(s[2]);
		map = new int[N][M];//벽은1 , 청소됐으면 2, 빈칸은 0
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(r,c,d));
		int result = 0;
		for(int i = 0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j =0;j<M;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		while(!q.isEmpty())
		{
			Node temp = q.poll();
			int y = temp.y;
			int x = temp.x;
			int dir = temp.dir;
			if(map[y][x]==0)//현재 칸이 청소되지 않았다면....
			{
				map[y][x]=2;
				result++;
			}//청소한다
			if(check(y,x))//현재 칸의 주변 4칸중 청소되지 않은 칸이 있다면
			{
				int ny = y+dy[(dir+3)%4];
				int nx = x+dx[(dir+3)%4];//반시계 방향 90도
				if(ny<0||ny>=N||nx<0||nx>=M||map[ny][nx]==1)//반시계 방향으로 돌렷는데 벽이라면
				{
					q.add(new Node(y,x,(dir+3)%4));
				}
				else//반시계 방향으로 돌렸는데 벽이 아니라면
				{
					if(map[ny][nx]==0)//빈칸이라면
					{
						q.add(new Node(ny,nx,(dir+3)%4));
					}
					else//빈칸이 아니라면
					{
						q.add(new Node(y,x,(dir+3)%4));
					}
				}
			}
			else//주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
			{
				int ny = y-dy[dir];
				int nx = x-dx[dir];
				if(ny<0||ny>=N||nx<0||nx>=M||map[ny][nx]==1)//한 칸 후진이 벽이라면 작동 정지
				{
					break;
				}
				q.add(new Node(ny,nx,dir));
			}
		}
		System.out.println(result);
	}
	public static boolean check(int y,int x)
	{
		for(int i=0;i<4;i++)
		{
			int ny= y+dy[i];
			int nx= x+dx[i];
			if(ny<0||ny>=N||nx<0||nx>=M ||map[ny][nx]==1)//벽이라면
			{
				continue;
			}
			if(map[ny][nx]==0)//주변 4칸 중 청소되지 않은 빈 칸 발견시
			{
				return true;
			}
		}
		return false;
	}
}
