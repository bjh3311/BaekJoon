import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int y;
	int x;
	int weight;
	public Node(int y,int x,int weight)
	{
		this.y=y;
		this.x=x;
		this.weight=weight;
	}
	@Override
	public int compareTo(Node o)
	{
		return weight-o.weight;
	}//우선순위 큐에 넣을때 가중치가 가장 작은게 큰 우선순위를 갖도록 구현
}
public class 백준_1261번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int M=Integer.parseInt(s[0]);
		int N=Integer.parseInt(s[1]);
		int[][] map=new int[N][M];//벽이 있는지없는지를 나타내는 map배열
		boolean[][] visited=new boolean[N][M];//방문했는지 확인하는 배열
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split("");
			for(int j=0;j<M;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		int[] dx= {0,1,0,-1};
		int[] dy= {1,0,-1,0};//4방향을 모두 확인하기 위한 배열
		int[][] result=new int[N][M];//출발점에서 해당지점까지 벽을 부셔야하는 갯수값,일반 다익스트라에서의 dis랑 같다
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				result[i][j]=Integer.MAX_VALUE;
			}
		}//다익스트라에서 하듯이 최대값으로 모두 초기화
		result[0][0]=0;//시작점인 0,0만 0으로 초기화
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		q.add(new Node(0,0,0));//0,0에서 시작
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			int y=temp.y;
			int x=temp.x;
			int weight=temp.weight;
			if(!visited[y][x])
			{
				for(int i=0;i<4;i++)
				{
					int ny=y+dy[i];
					int nx=x+dx[i];
					if(ny>=0&&ny<N&&nx>=0&&nx<M)//가고자 하는 방향이 map의 범위를 벗어나는지 확인
					{
						if(!visited[ny][nx]&&map[ny][nx]==1)//방문된적없고 벽이 있다면
						{
							if(result[ny][nx]>result[y][x]+1)//result에 1더해야한다.
							{
								result[ny][nx]=result[y][x]+1;
								q.add(new Node(ny,nx,result[ny][nx]));
							}
						}
						else if(!visited[ny][nx]&&map[ny][nx]==0)//방문된적없고 벽이 없다면
						{
							if(result[ny][nx]>result[y][x])//result 그대로 간다. 더할 필요없다.
							{
								result[ny][nx]=result[y][x];
								q.add(new Node(ny,nx,result[ny][nx]));
							}
						}
					}
				}
			}
			visited[y][x]=true;//해당 정점과 연결된걸 모두 확인했기에 방문처리해준다.
		}
		System.out.println(result[N-1][M-1]);
	}
}
