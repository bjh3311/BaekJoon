import java.util.*;
import java.io.*;
class Node{
	int y;
	int x;
	int count;
	int crash;
	Node(int y,int x,int count,int crash)
	{
		this.x=x;
		this.y=y;
		this.count=count;
		this.crash=crash;
	}
}
	public class ����_14442�� {

		public static int[][] map;
		public static boolean[][][] visited;
		public static void main(String[] args) throws IOException{
			// TODO Auto-generated method stub
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String[] s=br.readLine().split(" ");
			int N=Integer.parseInt(s[0]);
			int M=Integer.parseInt(s[1]);
			int K=Integer.parseInt(s[2]);
			map=new int[N][M];
			visited=new boolean[N][M][K+1];
			for(int i=0;i<N;i++)
			{
				s=br.readLine().split("");
				for(int j=0;j<M;j++)
				{
					map[i][j]=Integer.parseInt(s[j]);
				}
			}//�� �Է�
			Queue<Node> q=new LinkedList<Node>();//�� �μ������� ť
			q.add(new Node(0,0,1,0));//�������� �ν����� Ȯ��
			for(int i=0;i<=K;i++)
			{
				visited[0][0][i]=true;
			}
			int[] nx= {0,1,0,-1};
			int[] ny= {1,0,-1,0};
			int ans=Integer.MAX_VALUE;
			while(!q.isEmpty())
			{
				Node temp=q.poll();
				int temp_y=temp.y;//x��ǥ
				int temp_x=temp.x;//y��ǥ
				int temp_count=temp.count;
				int temp_crash=temp.crash;
				if(temp_x==M-1&&temp_y==N-1)
				{
					ans=temp.count;
					break;
				}//������ ������ break
				for(int i=0;i<4;i++)
				{
					int y=temp_y+ny[i];
					int x=temp_x+nx[i];
					if(0<=y&&y<N&&0<=x&&x<M)//�ʾȿ� �������
					{
						if(temp_crash<K)//���� �μ�Ƚ���� K���� �۴ٸ�
						{
							if(map[y][x]==1)//���� �ִٸ�
							{
								if(!visited[y][x][temp_crash+1])
								{
									visited[y][x][temp_crash+1]=true;
									q.add(new Node(y,x,temp_count+1,temp_crash+1));
								}
								
							}
							else//���� ���ٸ�
							{
								if(!visited[y][x][temp_crash])
								{
									visited[y][x][temp_crash]=true;
									q.add(new Node(y,x,temp_count+1,temp_crash));
								}
								
							}
						}
						else//���� �ִ�� �ν��ٸ�
						{
							if(map[y][x]==0)
							{
								if(!visited[y][x][temp_crash])
								{
									visited[y][x][temp_crash]=true;
									q.add(new Node(y,x,temp_count+1,temp_crash));
								}
							}
						}
					}					
				}
			}//���� �Ⱥμ� ���̽� �˻�
			if(ans==Integer.MAX_VALUE)//�������� ��������
			{
				System.out.println("-1");
			}
			else
			{
				System.out.println(ans);//���� ���
			}	
		}
	}