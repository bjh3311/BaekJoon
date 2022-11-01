import java.util.*;
import java.io.*;
class Node
{
	int y;
	int x;
	public Node(int y,int x)
	{
		this.y=y;
		this.x=x;
	}
}
public class 백준_2636번 {

	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dy= {-1,0,1,0};
	public static int[] dx= {0,1,0,-1};
	public static ArrayList<Node> cheese;
	public static int N;
	public static int M;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		M=Integer.parseInt(s[1]);
		map=new int[N][M];
		cheese=new ArrayList<Node>();
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<M;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
				if(map[i][j]==1)//치즈라면
				{
					cheese.add(new Node(i,j));
				}
			}
		}
		int count=0;
		int temp=cheese.size();
		map[0][0]=2;
		while(true)
		{
			visited=new boolean[N][M];//한번 DFS를 돌 때마다 방문체크 배열을 초기화해준다.
			BFS();
			cheese_melting();
			count++;
			if(cheese.size()==0)//다 녹아서 사이즈가 0이 됐다면
			{
				System.out.println(count);
				System.out.println(temp);
				break;
			}
			temp=cheese.size();
		}
	}
	public static void BFS()//외부공기 설정
	{
		Queue<Node> q=new LinkedList<Node>();
		q.add(new Node(0,0));
		visited[0][0]=true;
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			int y=temp.y;
			int x=temp.x;
			for(int i=0;i<4;i++)
			{
				int ny=dy[i]+y;
				int nx=dx[i]+x;
				if(ny<0||ny>=N||nx<0||nx>=M)//범위를 벗어나면
				{
					continue;
				}
				if(map[ny][nx]==1||visited[ny][nx])//가려는 곳이 치즈 또는 방문한적이 있으면 종료
				{
					continue;
				}
				visited[ny][nx]=true;
				map[ny][nx]=2;//외부공기로 설정해준다
				q.add(new Node(ny,nx));
			}
		}
	}
	public static void cheese_melting()
	{
		for(int i=0;i<cheese.size();i++)
		{
			int y=cheese.get(i).y;
			int x=cheese.get(i).x;
			int count=0;
			for(int j=0;j<4;j++)
			{
				int ny=y+dy[j];
				int nx=x+dx[j];
				if(map[ny][nx]==2)//인접해 있는 타일이 외부공기라면
				{
					count++;
				}
			}
			if(count>=1)//외부공기를 1칸만 만나도 없애줘야한다
			{
				cheese.remove(i);
				i--;
				map[y][x]=0;//치즈가 녹아서 빈공간으로 만들어준다
			}
		}
	}

}
