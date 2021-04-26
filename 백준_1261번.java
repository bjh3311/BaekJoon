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
	}//�켱���� ť�� ������ ����ġ�� ���� ������ ū �켱������ ������ ����
}
public class ����_1261�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int M=Integer.parseInt(s[0]);
		int N=Integer.parseInt(s[1]);
		int[][] map=new int[N][M];//���� �ִ����������� ��Ÿ���� map�迭
		boolean[][] visited=new boolean[N][M];//�湮�ߴ��� Ȯ���ϴ� �迭
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split("");
			for(int j=0;j<M;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		int[] dx= {0,1,0,-1};
		int[] dy= {1,0,-1,0};//4������ ��� Ȯ���ϱ� ���� �迭
		int[][] result=new int[N][M];//��������� �ش��������� ���� �μž��ϴ� ������,�Ϲ� ���ͽ�Ʈ�󿡼��� dis�� ����
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				result[i][j]=Integer.MAX_VALUE;
			}
		}//���ͽ�Ʈ�󿡼� �ϵ��� �ִ밪���� ��� �ʱ�ȭ
		result[0][0]=0;//�������� 0,0�� 0���� �ʱ�ȭ
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		q.add(new Node(0,0,0));//0,0���� ����
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
					if(ny>=0&&ny<N&&nx>=0&&nx<M)//������ �ϴ� ������ map�� ������ ������� Ȯ��
					{
						if(!visited[ny][nx]&&map[ny][nx]==1)//�湮�������� ���� �ִٸ�
						{
							if(result[ny][nx]>result[y][x]+1)//result�� 1���ؾ��Ѵ�.
							{
								result[ny][nx]=result[y][x]+1;
								q.add(new Node(ny,nx,result[ny][nx]));
							}
						}
						else if(!visited[ny][nx]&&map[ny][nx]==0)//�湮�������� ���� ���ٸ�
						{
							if(result[ny][nx]>result[y][x])//result �״�� ����. ���� �ʿ����.
							{
								result[ny][nx]=result[y][x];
								q.add(new Node(ny,nx,result[ny][nx]));
							}
						}
					}
				}
			}
			visited[y][x]=true;//�ش� ������ ����Ȱ� ��� Ȯ���߱⿡ �湮ó�����ش�.
		}
		System.out.println(result[N-1][M-1]);
	}
}
