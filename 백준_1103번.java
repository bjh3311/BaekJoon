import java.io.*;
import java.util.*;
public class ����_1103�� {

	public static int N;
	public static int M;
	public static int[][] map;
	public static int[][] dp;
	public static int max;
	public static boolean[][] visited;
	public static int[] dx= {-1,0,1,0};
	public static int[] dy= {0,1,0,-1};
	public static void DFS(int y,int x,int count)
	{
		dp[y][x]=count;
		max=Math.max(max, dp[y][x]);
		visited[y][x]=true;
		for(int i=0;i<4;i++)
		{
			int ny=y+map[y][x]*dy[i];
			int nx=x+map[y][x]*dx[i];
			if(ny>=0&&ny<N&&nx>=0&&nx<M)
			{		
				if(visited[ny][nx])//��ΰ� ������ ����Ŭ�� �������� �����ϸ� -1����ϰ� ���α׷�����
				{
					System.out.println("-1");
					System.exit(0);
				}
				if(count<dp[ny][nx])//��������
				{
					
				}
				else if(map[ny][nx]==0)
				{
					
				}
				else
				{
					DFS(ny,nx,count+1);
				}
			}
		}
		visited[y][x]=false;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		M=Integer.parseInt(s[1]);
		map=new int[N][M];
		dp=new int[N][M];//����� 
		visited=new boolean[N][M];//�湮�ߴ��� Ȯ��
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split("");
			for(int j=0;j<M;j++)
			{
				if(s[j].equals("H"))
				{
					map[i][j]=0;
				}
				else
				{
					map[i][j]=Integer.parseInt(s[j]);
				}
			}
		}
		DFS(0,0,0);
		System.out.println(max);
	}
}
