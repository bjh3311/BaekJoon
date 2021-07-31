import java.util.*;
import java.io.*;
class Node implements Comparable<Node>//���д�Ʈ���� ���� �� �ʿ��� Node
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
public class ����_17472�� {

	public static int N;
	public static int M;
	public static int island_cnt;
	public static boolean[][] visited;
	public static int[] dx= {-1,1,0,0};
	public static int[] dy= {0,0,-1,1};
	public static int[][] temp_map;
	public static int[][] map;//���� ���ڷ� ���еǾ��ִ�.
	public static ArrayList<Node>[] arr;
	public static void BFS(int y,int x)//���� ���ڷ� ����������
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
				if(ny>=0&&ny<N&&nx>=0&&nx<M)//�� �ȿ� �־�� �Ѵ�.
				{
					if(!visited[ny][nx]&&temp_map[ny][nx]==1)//�湮���� ���� ���̶��
					{
						visited[ny][nx]=true;//�湮 ó���� ���ش�
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
		for(int i=1;;i++)//������
		{
			if(x+i>=M)
			{
				break;
			}
			if(map[y][x+i]==island_num)
			{
				break;
			}
			if(map[y][x+i]!=island_num&&map[y][x+i]!=0)//����ȣ�� �ٸ� 0�̾ƴ� �ٸ� ���� ������
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
		for(int i=1;;i++)//�ަU
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
		for(int i=1;;i++)//�Ʒ���
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
		for(int i=1;;i++)//����
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
		temp_map=new int[N][M];//�׳� 1�� 0���θ� �Ǿ��ִ� temp_map
		map=new int[N][M];//���� ���ڷ� ������ ���� ��¥ map
		for(int i=0;i<N;i++)//�ӽ÷� �Է¹ޱ�
		{
			s=br.readLine().split(" ");
			for(int j=0;j<M;j++)
			{
				temp_map[i][j]=Integer.parseInt(s[j]);
			}
		}
		visited=new boolean[N][M];
		island_cnt=0;//���� ����
		for(int i=0;i<N;i++)//���� ���ڷ� �������ִ� for��
		{
			for(int j=0;j<M;j++)
			{
				if(!visited[i][j]&&temp_map[i][j]==1)//�湮�������� ���̶��
				{
					island_cnt++;
					BFS(i,j);	
				}
			}
		}
		arr=new ArrayList[island_cnt+1];
		boolean[] island_visited=new boolean[island_cnt+1];//���� �湮�ߴ���
		for(int i=1;i<=island_cnt;i++)
		{
			arr[i]=new ArrayList<Node>();
		}
		for(int i=0;i<N;i++)//������ ���� �մ� �ٸ�(����)�� �� ���� �߰��� �ش�.
		{
			for(int j=0;j<M;j++)
			{
				if(map[i][j]!=0)//�ٸ��� ���̴� 2�̻��̾�� �ϹǷ� k�� 2���� ����
				{
					Bridge(i,j,map[i][j]);//�ٸ��� �����ϴ� �Լ�
				}
			}
		}
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		q.add(new Node(1,0));//1�� ������ ����
		int result=0;
		while(!q.isEmpty())//������ ���� �������� ������ �������� �ּ� ���д� Ʈ���� ���ϴ� ���� �˰��� �����Ѵ�.
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
				System.out.println("-1");//�湮�������� ���� �ִٸ� -1�� ����ϰ� �ý��� ����
				System.exit(0);
			}
		}
		System.out.println(result);
	}
}
