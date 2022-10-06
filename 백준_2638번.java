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
public class 백준_2638번 {

	public static int N;
	public static int M;
	public static boolean[][] visited;
	public static int[][] map;
	public static int[] dx= {-1,0,1,0};
	public static int[] dy= {0,1,0,-1};
	public static ArrayList<Node> cheese;
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
				if(map[i][j]==1)//치즈라면 치즈 ArrayList에 넣어주자
				{
					cheese.add(new Node(i,j));
				}
			}
		}
		int result=0;
		while(true)
		{
			result++;
			visited=new boolean[N][M];//한번 돌때마다 방문처리를 초기화해준다.
			BFS();//외부공기 설정
			cheese_melting();
			if(cheese.size()==0)//모든 치즈가 녹았다면
			{
				System.out.println(result);
				break;
			}
		}
	}
	public static void BFS()//외부 공기 찾기, 0.0은 무조건 외부공기이므로 0,0에서 계속 시작한다.
	{
		Queue<Node> q=new LinkedList<Node>();
		visited[0][0]=true;
		q.add(new Node(0,0));
		map[0][0]=2;//처음 0,0좌표는 외부공기
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			for(int i=0;i<4;i++)
			{
				int ny=temp.y+dy[i];
				int nx=temp.x+dx[i];
				if(ny<0||ny>=N)//ny가 map범위를 벗어나면
				{
					continue;
				}
				if(nx<0||nx>=M)//nx가 map범위를 벗어나면
				{
					continue;
				}
				if(visited[ny][nx])//방문 된 적이 있다면 넘어간다
				{
					continue;
				}
				if(map[ny][nx]!=1)//치즈가 아니라면
				{
					map[ny][nx]=2;//외부공기로 만들어준다
					q.add(new Node(ny,nx));
				}
				visited[ny][nx]=true;//방문처리
				
			}
		}
	}
	public static void cheese_melting()//치즈리스트에서 각 치즈가 맞닿은 2면이 외부공기인지 알아보기
	{
		for(int i=0;i<cheese.size();i++)
		{
			int count=0;
			Node temp=cheese.get(i);
			for(int j=0;j<4;j++)
			{
				if(map[temp.y+dy[j]][temp.x+dx[j]]==2)//현재 노드를 기준으로 4면을 확인했는데 외부공기라면
				{
					count++;
				}
			}
			if(count>=2)//맞닿은 외부공기가 2면 이상이라면
			{
				cheese.remove(i);
				i--;//인덱스가 한칸씩 떙겨지기 때문에
				map[temp.y][temp.x]=0;
			}
		}
	}
}
