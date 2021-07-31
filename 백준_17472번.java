import java.util.*;
import java.io.*;
class Node implements Comparable<Node>//스패닝트리를 만들 때 필요한 Node
{
	int v;
	int w;
	public Node(int v,int w)
	{
		this.v=v;
		this.w=w;
	}
	public int compareTo(Node o)
	{
		return w-o.w;
	}
}
public class 백준_17472번 {

	public static int N;
	public static int M;
	public static int island_cnt;
	public static boolean[][] visited;
	public static int[] dx= {-1,1,0,0};
	public static int[] dy= {0,0,-1,1};
	public static int[][] temp_map;
	public static int[][] map;//섬이 숫자로 구분되어있다.
	public static ArrayList<Node>[] arr;
	public static void BFS(int y,int x)//섬을 숫자로 구분해주자
	{
		visited[y][x]=true;
		map[y][x]=island_cnt;
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(y);
		q.add(x);
		while(!q.isEmpty())
		{
			int cy=q.poll();
			int cx=q.poll();
			for(int i=0;i<4;i++)
			{
				int ny=dy[i]+cy;
				int nx=dx[i]+cx;
				if(ny>=0&&ny<N&&nx>=0&&nx<M)//맵 안에 있어야 한다.
				{
					if(!visited[ny][nx]&&temp_map[ny][nx]==1)//방문된적 없는 땅이라면
					{
						visited[ny][nx]=true;//방문 처리를 해준다
						map[ny][nx]=island_cnt;
						q.add(ny);
						q.add(nx);
					}
				}
			}
		}
	}
	public static void Bridge(int y,int x,int island_num)
	{
		for(int i=1;;i++)//오른쪽
		{
			if(x+i>=M)
			{
				break;
			}
			if(map[y][x+i]==island_num)
			{
				break;
			}
			if(map[y][x+i]!=island_num&&map[y][x+i]!=0)//섬번호가 다른 0이아닌 다른 섬을 만나면
			{
				if(i>2)
				{
					arr[island_num].add(new Node(map[y][x+i],i-1));
					break;
				}
				else if(i<=2)
				{
					break;
				}
			}
		
		}
		for(int i=1;;i++)//왼쪾
		{
			if(x-i<0)
			{
				break;
			}
			if(map[y][x-i]==island_num)
			{
				break;
			}
			if(map[y][x-i]!=island_num&&map[y][x-i]!=0)
			{
				if(i>2)
				{
					arr[island_num].add(new Node(map[y][x-i],i-1));
					break;
				}
				else if(i<=2)
				{
					break;
				}
			}
			
		}
		for(int i=1;;i++)//아래쪽
		{
			if(y+i>=N)
			{
				break;
			}
			if(map[y+i][x]==island_num)
			{
				break;
			}
			if(map[y+i][x]!=island_num&&map[y+i][x]!=0)
			{
				if(i>2)
				{
					arr[island_num].add(new Node(map[y+i][x],i-1));
					break;
				}
				else if(i<=2)
				{
					break;
				}
			}
			
		}
		for(int i=1;;i++)//위쪽
		{
			if(y-i<0)
			{
				break;
			}
			if(map[y-i][x]==island_num)
			{
				break;
			}
			if(map[y-i][x]!=island_num&&map[y-i][x]!=0)
			{
				if(i>2)
				{
					arr[island_num].add(new Node(map[y-i][x],i-1));
					break;
				}
				else
				{
					break;
				}
			}
			
		}
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		M=Integer.parseInt(s[1]);
		temp_map=new int[N][M];//그냥 1과 0으로만 되어있는 temp_map
		map=new int[N][M];//섬을 숫자로 구분해 놓은 진짜 map
		for(int i=0;i<N;i++)//임시로 입력받기
		{
			s=br.readLine().split(" ");
			for(int j=0;j<M;j++)
			{
				temp_map[i][j]=Integer.parseInt(s[j]);
			}
		}
		visited=new boolean[N][M];
		island_cnt=0;//섬의 갯수
		for(int i=0;i<N;i++)//섬을 숫자로 구분해주는 for문
		{
			for(int j=0;j<M;j++)
			{
				if(!visited[i][j]&&temp_map[i][j]==1)//방문된적없는 땅이라면
				{
					island_cnt++;
					BFS(i,j);	
				}
			}
		}
		arr=new ArrayList[island_cnt+1];
		boolean[] island_visited=new boolean[island_cnt+1];//섬을 방문했는지
		for(int i=1;i<=island_cnt;i++)
		{
			arr[i]=new ArrayList<Node>();
		}
		for(int i=0;i<N;i++)//섬에서 섬을 잇는 다리(간선)을 각 섬에 추가해 준다.
		{
			for(int j=0;j<M;j++)
			{
				if(map[i][j]!=0)//다리의 길이는 2이상이어야 하므로 k는 2부터 시작
				{
					Bridge(i,j,map[i][j]);//다리를 연결하는 함수
				}
			}
		}
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		q.add(new Node(1,0));//1번 섬부터 시작
		int result=0;
		while(!q.isEmpty())//위에서 구한 간선들의 정보를 바탕으로 최소 스패닝 트리를 구하는 프림 알고리즘 수행한다.
		{
			Node temp=q.poll();
			if(island_visited[temp.v])
			{
				continue;
			}
			island_visited[temp.v]=true;
			result=result+temp.w;
			for(Node next: arr[temp.v])
			{
				if(!island_visited[next.v])
				{
					q.add(next);
				}
			}
		}
		for(int i=1;i<=island_cnt;i++)
		{
			if(!island_visited[i])
			{
				System.out.println("-1");//방문된적없는 섬이 있다면 -1을 출력하고 시스템 종료
				System.exit(0);
			}
		}
		System.out.println(result);
	}
}
