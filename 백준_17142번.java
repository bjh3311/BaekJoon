import java.util.*;
import java.io.*;
class loc
{
	int y;
	int x;
	public loc(int y,int x)
	{
		this.y=y;
		this.x=x;
	}
}
public class ����_17142�� {
	public static int result=Integer.MAX_VALUE;//�����
	public static int[][] map;
	public static ArrayList<loc> arr;
	public static int M;
	public static int N;
	public static int[] dy= {-1,1,0,0};
	public static int[] dx= {0,0,1,-1};
	public static void virus(int count,int start)
	{
		if(count==M)//���̷�����ġ ������ �� �Ǿ��ٸ�
		{
			BFS();
			return;
		}
		for(int i=start;i<arr.size();i++)
		{
			loc temp=arr.get(i);
			map[temp.y][temp.x]=0;
			virus(count+1,i+1);
			map[temp.y][temp.x]=-50;
		}
	}
	public static void BFS()
	{
		int temp_result=0;
		Queue<Integer> q=new LinkedList<Integer>();
		int[][] temp_map=new int[N][N];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				temp_map[i][j]=map[i][j];//���̷����� ��ġ�� ����Ǿ��ִ� ���� map�� ���ΰ� temp_map�� ����
				if(temp_map[i][j]==0)
				{
					q.add(i);
					q.add(j);
				}
			}
		}
		while(!q.isEmpty())
		{
			int y=q.poll();
			int x=q.poll();
			for(int i=0;i<4;i++)
			{
				int ny=y+dy[i];
				int nx=x+dx[i];
				if(ny>=0&&ny<N&&nx>=0&&nx<N)//���� �����ȿ� �ִٸ�
				{
					if(temp_map[ny][nx]==-10||temp_map[ny][nx]==-50)//���� ĭ�� ��ĭ�̶��
					{
						q.add(ny);
						q.add(nx);
						temp_map[ny][nx]=temp_map[y][x]+1;
					}
				}
			}
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(temp_map[i][j]==-10)//-10,�� ��ĭ�� �ִٸ� �� ��쿡�� ���̷����� �� ������ ���Ѵ�.
				{
					temp_result=50000;
					break;
				}
				else if(temp_map[i][j]>=0&&map[i][j]!=-50)
				{
					temp_result=Math.max(temp_result, temp_map[i][j]);
				}
			}
		}
		result=Math.min(result, temp_result);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		M=Integer.parseInt(s[1]);
		map=new int[N][N];
		arr=new ArrayList<loc>();
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
				if(map[i][j]==2)//���̷����� ��ġ�� arr�� �����Ű�� map������ -10���� �ٲ��ش�.
				{
					arr.add(new loc(i,j));
					map[i][j]=-50;
				}
				else if(map[i][j]==1)//���� -100����
				{
					map[i][j]=-100;
				}
				else if(map[i][j]==0)//��ĭ�� -10����
				{
					map[i][j]=-10;
				}
			}
		}//������ ������ arr���� ���̷����� ��ġ�� ����, map���� -10��,-50,-100�� �����ִ�.
		virus(0,0);
		if(result==50000)
		{
			System.out.println("-1");
		}
		else
		{
			System.out.println(result);
		}
		

	}

}
