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
public class ����_2638�� {

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
				if(map[i][j]==1)//ġ���� ġ�� ArrayList�� �־�����
				{
					cheese.add(new Node(i,j));
				}
			}
		}
		int result=0;
		while(true)
		{
			result++;
			visited=new boolean[N][M];//�ѹ� �������� �湮ó���� �ʱ�ȭ���ش�.
			BFS();//�ܺΰ��� ����
			cheese_melting();
			if(cheese.size()==0)//��� ġ� ��Ҵٸ�
			{
				System.out.println(result);
				break;
			}
		}
	}
	public static void BFS()//�ܺ� ���� ã��, 0.0�� ������ �ܺΰ����̹Ƿ� 0,0���� ��� �����Ѵ�.
	{
		Queue<Node> q=new LinkedList<Node>();
		visited[0][0]=true;
		q.add(new Node(0,0));
		map[0][0]=2;//ó�� 0,0��ǥ�� �ܺΰ���
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			for(int i=0;i<4;i++)
			{
				int ny=temp.y+dy[i];
				int nx=temp.x+dx[i];
				if(ny<0||ny>=N)//ny�� map������ �����
				{
					continue;
				}
				if(nx<0||nx>=M)//nx�� map������ �����
				{
					continue;
				}
				if(visited[ny][nx])//�湮 �� ���� �ִٸ� �Ѿ��
				{
					continue;
				}
				if(map[ny][nx]!=1)//ġ� �ƴ϶��
				{
					map[ny][nx]=2;//�ܺΰ���� ������ش�
					q.add(new Node(ny,nx));
				}
				visited[ny][nx]=true;//�湮ó��
				
			}
		}
	}
	public static void cheese_melting()//ġ���Ʈ���� �� ġ� �´��� 2���� �ܺΰ������� �˾ƺ���
	{
		for(int i=0;i<cheese.size();i++)
		{
			int count=0;
			Node temp=cheese.get(i);
			for(int j=0;j<4;j++)
			{
				if(map[temp.y+dy[j]][temp.x+dx[j]]==2)//���� ��带 �������� 4���� Ȯ���ߴµ� �ܺΰ�����
				{
					count++;
				}
			}
			if(count>=2)//�´��� �ܺΰ��Ⱑ 2�� �̻��̶��
			{
				cheese.remove(i);
				i--;//�ε����� ��ĭ�� �������� ������
				map[temp.y][temp.x]=0;
			}
		}
	}
}
