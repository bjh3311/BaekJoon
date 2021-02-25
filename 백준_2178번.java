import java.util.*;
public class ����_2178�� {
	public static int N;
	public static int M;
	public static int[][] maze;//�̷�
	public static int[][] result;
	public static boolean[][] visited;
	public static void BFS()
	{
		Queue<Integer> qx=new LinkedList<Integer>();
		Queue<Integer> qy=new LinkedList<Integer>();
		qx.add(0);
		qy.add(0);
		result[0][0]=1;
		visited[0][0]=true;
		while(!qx.isEmpty()&&!qy.isEmpty())
		{
			int temp_x=qx.poll();
			int temp_y=qy.poll();
			if(temp_x==N-1&&temp_y==M-1)
			{
				System.out.println(result[temp_x][temp_y]);
				System.exit(0);
			}
			if(temp_x+1>=0&&temp_x+1<N)
			{
				if(!visited[temp_x+1][temp_y]&&maze[temp_x+1][temp_y]==1)//�湮���� ���� 1�̾����
				{
					qx.add(temp_x+1);
					qy.add(temp_y);
					visited[temp_x+1][temp_y]=true;
					result[temp_x+1][temp_y]=result[temp_x][temp_y]+1;
				}
			}//�Ʒ� Ȯ��
			if(temp_x-1>=0&&temp_x-1<N)
			{
				if(!visited[temp_x-1][temp_y]&&maze[temp_x-1][temp_y]==1)//�湮���� ���� 1�̾����
				{
					qx.add(temp_x-1);
					qy.add(temp_y);
					visited[temp_x-1][temp_y]=true;
					result[temp_x-1][temp_y]=result[temp_x][temp_y]+1;
				}
			}//�� Ȯ��
			if(temp_y+1<M&&temp_y+1>=0)
			{
				if(!visited[temp_x][temp_y+1]&&maze[temp_x][temp_y+1]==1)//�湮���� ���� 1�̾����
				{
					qx.add(temp_x);
					qy.add(temp_y+1);
					visited[temp_x][temp_y+1]=true;
					result[temp_x][temp_y+1]=result[temp_x][temp_y]+1;
				}
			}//������ Ȯ��
			if(temp_y-1>=0&&temp_y-1<M)
			{
				if(!visited[temp_x][temp_y-1]&&maze[temp_x][temp_y-1]==1)//�湮���� ���� 1�̾����
				{
					qx.add(temp_x);
					qy.add(temp_y-1);
					visited[temp_x][temp_y-1]=true;
					result[temp_x][temp_y-1]=result[temp_x][temp_y]+1;
				}
			}//���� Ȯ��
		}	
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
			s=scan.nextLine().split("");
			for(int j=0;j<M;j++)
			{
				maze[i][j]=Integer.parseInt(s[j]);
			}
		}
		BFS();
	}

}
