import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int x;
	int y;
	int dir;//
	int cost;
	public Node(int x,int y,int dir,int cost)
	{
		this.x=x;
		this.y=y;
		this.dir=dir;
		this.cost=cost;
	}
	public int compareTo(Node o)
	{
		return cost-o.cost;
	}
}
public class ����_6087�� {

	public static int[] dx= {1,0,-1,0};
	public static int[] dy= {0,-1,0,1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int W=Integer.parseInt(s[0]);
		int H=Integer.parseInt(s[1]);
		PriorityQueue<Node> pq=new PriorityQueue<Node>();
		char[][] map=new char[H][W];
		int[][] visited=new int[H][W];// visited[3][1]=4�̸� �ſ��� 4���Ἥ (1,3) ��ġ�� �Դٴ°Ŵ�
		for(int i=0;i<H;i++)
		{
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		String input;
		boolean start=false;
		for(int i=0;i<H;i++)
		{
			input=br.readLine();
			for(int j=0;j<W;j++)
			{
				map[i][j]=input.charAt(j);
				if(map[i][j]=='C'&&!start)
				{
					pq.add(new Node(j,i,0,0));
					pq.add(new Node(j,i,1,0));
					pq.add(new Node(j,i,2,0));
					pq.add(new Node(j,i,3,0));
					visited[i][j]=Integer.MIN_VALUE;
					start=true;
				}
			}
		}
		while(!pq.isEmpty())//cost�� �������� �켱������ ���´�
		{
			Node temp=pq.poll();
			int y=temp.y;
			int x=temp.x;
			if(map[y][x]=='C'&&visited[y][x]!=Integer.MIN_VALUE)//�ʿ� �����ߴٸ� 
			{
				System.out.println(temp.cost);
				break;
			}
			for(int i=0;i<4;i++)
			{
				int ny=y+dy[i];
				int nx=x+dx[i];
				if(ny>=0&&ny<H&&nx>=0&&nx<W&&map[ny][nx]!='*')//���� ������ �� �ȿ� �ְ� ���� �ƴϾ�� �Ѵ�
				{
					if(temp.dir==i)//���� �����̶� ���ư����� ������ ���ٸ�
					{
						if(temp.cost<=visited[ny][nx])
						{
							pq.add(new Node(nx,ny,i,temp.cost));
							visited[ny][nx]=temp.cost;
						}	
					}
					else//������ �ٸ��ٸ�
					{
						if(temp.cost+1<=visited[ny][nx])
						{
							pq.add(new Node(nx,ny,i,temp.cost+1));
							visited[ny][nx]=temp.cost+1;
						}
					}		
				}
			}
		}
	}
}
