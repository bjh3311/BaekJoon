import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int y;
	int x;
	int w;
	public Node(int y,int x,int w)
	{
		this.y=y;
		this.x=x;
		this.w=w;
	}
	public int compareTo(Node o)//가중치가 작을수록 큰 우선순위를 갖는다
	{
		return w-o.w;
	}
}
public class 백준_2665번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] map=new int[N][N];
		String[] s;
		int[] dx= {-1,0,1,0};
		int[] dy= {0,1,0,-1};
		int[][] result=new int[N][N];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				result[i][j]=Integer.MAX_VALUE;
			}
		}
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split("");
			for(int j=0;j<N;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		q.add(new Node(0,0,0));
		result[0][0]=0;
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			int y=temp.y;
			int x=temp.x;
			int w=temp.w;
			for(int i=0;i<4;i++)
			{
				int ny=y+dy[i];
				int nx=x+dx[i];
				if(ny>=0&&ny<N&&nx>=0&&nx<N)//맵안에 있다면
				{
					if(map[ny][nx]==0&&result[ny][nx]>result[y][x]+1)//검은방이라면
					{
						result[ny][nx]=result[y][x]+1;
						q.add(new Node(ny,nx,result[ny][nx]));
					}
					else if(map[ny][nx]==1&&result[ny][nx]>result[y][x])//흰색방이면
					{
						result[ny][nx]=result[y][x];
						q.add(new Node(ny,nx,result[ny][nx]));
					}
				}
			}
		}
		System.out.println(result[N-1][N-1]);
	}
}
