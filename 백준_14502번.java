import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class ����_14502�� {
	public static int N;
	public static int M;
	public static int[][] maze;//�������� ����
	public static int[][] result;//�������� ���纻
	public static boolean[][] visited;//��ĭ�̸� true
	public static int max;
	public static void permutation(int count)//�� 3�� ����� ����Ǽ�
	{
		if(count==3)//���� 3�� �� ���� BFS�ǽ�
		{
			BFS();
			return;
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(visited[i][j])
				{
					visited[i][j]=false;
					maze[i][j]=1;
					permutation(count+1);
					maze[i][j]=0;
					visited[i][j]=true;
				}
			}
		}
	}
	public static void BFS()
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				result[i][j]=maze[i][j];
			}
		}//result�� ������ ������ ����
		Queue<Integer> qx=new LinkedList<Integer>();
		Queue<Integer> qy=new LinkedList<Integer>();
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(result[i][j]==2)//���̷����� �ִٸ�
				{
					qx.add(i);
					qy.add(j);
					while(!qx.isEmpty()&&!qy.isEmpty())
					{
						int temp_x=qx.poll();
						int temp_y=qy.poll();						
						if(temp_x+1>=0&&temp_x+1<N)
						{
							if(result[temp_x+1][temp_y]==0)//�湮���� ���� 1�̾����
							{
								qx.add(temp_x+1);
								qy.add(temp_y);
								result[temp_x+1][temp_y]=2;
							}
						}//�Ʒ� Ȯ��
						if(temp_x-1>=0&&temp_x-1<N)
						{
							if(result[temp_x-1][temp_y]==0)//�湮���� ���� 1�̾����
							{
								qx.add(temp_x-1);
								qy.add(temp_y);
								result[temp_x-1][temp_y]=2;
							}
						}//�� Ȯ��
						if(temp_y+1<M&&temp_y+1>=0)
						{
							if(result[temp_x][temp_y+1]==0)//�湮���� ���� 1�̾����
							{
								qx.add(temp_x);
								qy.add(temp_y+1);
								result[temp_x][temp_y+1]=2;
							}
						}//������ Ȯ��
						if(temp_y-1>=0&&temp_y-1<M)
						{
							if(maze[temp_x][temp_y-1]==0)//�湮���� ���� 1�̾����
							{
								qx.add(temp_x);
								qy.add(temp_y-1);
								result[temp_x][temp_y-1]=2;
							}
						}//���� Ȯ��
					}	
				}
			}
		}
		int count=0;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(result[i][j]==0)
				{
					count++;
				}
			}
		}
		max=Math.max(count, max);
		
	}
	public static void main(String[] agrs)
	{
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		M=scan.nextInt();
		scan.nextLine();//���๮�� ����
		maze=new int[N][M];
		visited=new boolean[N][M];
		result=new int[N][M];
	    String[] s;
		for(int i=0;i<N;i++)
		{
			s=scan.nextLine().split(" ");
			for(int j=0;j<M;j++)
			{
				maze[i][j]=Integer.parseInt(s[j]);
				if(maze[i][j]==0)
				{
					visited[i][j]=true;
				}
			}
		}
		permutation(0);
		System.out.println(max);
	}
}