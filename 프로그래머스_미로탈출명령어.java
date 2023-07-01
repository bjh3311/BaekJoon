import java.util.*;
class Node
{
	int x;
	int y;
	String value;
	Node(int x,int y,String value)
	{
		this.x=x;
		this.y=y;
		this.value=value;
	}
}
public class 프로그래머스_미로탈출명령어 {
	
	public static void main(String[] args)
	{
		System.out.println(solution(3,4,2,3,3,1,5));
	}
	public static int[] dy= {0,-1,1,0};
	public static int[] dx= {1,0,0,-1};
	public static char convertDir(int d)
	{
		if(d==0) 
		{
			return 'd';
		}
		if(d==1)
		{
			return 'l';
		}
		if(d==2)
		{
			return 'r';
		}
		if(d==3)
		{
			return 'u';
		}
		return 0;
	}
	public static String solution(int n,int m,int x,int y,int r,int c,int k)
	{
		Queue<Node> q=new LinkedList<Node>();
		q.add(new Node(x,y,""));
		String answer="impossible";
		boolean[][][] visited=new boolean[n+1][m+1][k+1];
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			if(temp.value.length()>k)
			{
				continue;
			}
			if(temp.value.length()==k&&temp.y==c&&temp.x==r)
			{
				return temp.value;
			}
			if(visited[temp.x][temp.y][temp.value.length()])
			{
				continue;
			}
			visited[temp.x][temp.y][temp.value.length()]=true;
			for(int i=0;i<4;i++)
			{
				int nx=temp.x+dx[i];
				int ny=temp.y+dy[i];
				if(nx<1||ny<1||nx>n||ny>m)//맵 범위를 벗어나면
				{
					continue;
				}
				q.add(new Node(nx,ny,temp.value+convertDir(i)));
			}
		}
		return answer;
	}
}