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
	public class ����_2206�� {

		public static int[][] map;
		public static boolean[][][] visited;
		public static void main(String[] args) throws IOException{
			// TODO Auto-generated method stub
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String[] s=br.readLine().split(" ");
			int N=Integer.parseInt(s[0]);
			int M=Integer.parseInt(s[1]);
			map=new int[N][M];
			visited=new boolean[N][M][2];
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
			visited[0][0][0]=true;//�������� �湮�ߴ�.k==0���� �Ⱥν�����
			visited[0][0][1]=true;//k==1���� �ν�����
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
						if(temp_crash==0)//���� �Ⱥμ� ���
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
						else//�μ� ���
						{
							if(map[y][x]==0&&!visited[y][x][1])
							{
								visited[y][x][1]=true;
								q.add(new Node(y,x,temp_count+1,temp_crash));
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
