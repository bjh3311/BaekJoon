import java.util.*;
import java.io.*;
public class ����_2589�� {
	public static int L;
	public static int W;
	public static int[][] map;//���� L�� 0���� ��ȯ �ٴ� W�� 1�� ��ȯ
	
	public static int res;
	public static void BFS(int y,int x)
	{
		int[][] route=new int[L][W];
		boolean[][] visited=new boolean[L][W];
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(y);
		q.add(x);
		visited[y][x]=true;
		int[] dx= {0,1,0,-1};
		int[] dy= {1,0,-1,0};
		while(!q.isEmpty())
		{
			int temp_y=q.poll();
			int temp_x=q.poll();
			for(int i=0;i<4;i++)
			{
				int ny=temp_y+dy[i];
				int nx=temp_x+dx[i];
				if(0<=ny&&ny<L&&0<=nx&&nx<W)//�ʾȿ� �ִٸ�
				{
					if(!visited[ny][nx]&&map[ny][nx]==0)//�湮���� ���� �������
					{
						q.add(ny);
						q.add(nx);
						visited[ny][nx]=true;
						route[ny][nx]=route[temp_y][temp_x]+1;
					}
				}
			}
		}
		for(int i=0;i<L;i++)
		{
			for(int j=0;j<W;j++)
			{
				res=Math.max(res, route[i][j]);
			}
		}//�ִ밪 ����
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		L=Integer.parseInt(s[0]);
		W=Integer.parseInt(s[1]);
		map=new int[L][W];
		res=0;
		for(int i=0;i<L;i++)
		{
			s=br.readLine().split("");
			for(int j=0;j<W;j++)
			{
				if(s[j].equals("W"))//�ٴٴ� 1�� ��ȯ
				{
					map[i][j]=1;
				}
				else//������ 0���� ��ȯ
				{
					map[i][j]=0;
				}
			}
		}
		for(int i=0;i<L;i++)
		{
			for(int j=0;j<W;j++)
			{
				if(map[i][j]==0)//������ BFS�ǽ�
				{
					BFS(i,j);
				}
			}
		}
		System.out.println(res);

	}

}
