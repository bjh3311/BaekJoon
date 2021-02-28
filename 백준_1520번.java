import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class ����_1520�� {
	public static int N;
	public static int M;
	public static int[][] map;//�������� ����
	public static int[][] dp;//dp�� ���� �迭
	public static int DFS(int x_start,int y_start)
	{
		if(x_start==M-1&&y_start==N-1)
		{
			return 1;
		}
		if(dp[x_start][y_start]==-1)
		{
			dp[x_start][y_start]=0;
			if(y_start+1<N)
			{
				if(map[x_start][y_start]>map[x_start][y_start+1])
				{
					dp[x_start][y_start]+=DFS(x_start,y_start+1);	
				}
			}//������ Ȯ��	
			if(y_start-1>=0)
			{
				if(map[x_start][y_start]>map[x_start][y_start-1])
				{
					
					dp[x_start][y_start]+=DFS(x_start,y_start-1);
				}
			}//���� Ȯ��	
			if(x_start+1<M)
			{
				if(map[x_start][y_start]>map[x_start+1][y_start])
				{
				
					dp[x_start][y_start]+=DFS(x_start+1,y_start);	
				}
			}//�Ʒ��� Ȯ��	
			if(x_start-1>=0)
			{
				if(map[x_start][y_start]>map[x_start-1][y_start])
				{
					dp[x_start][y_start]+=DFS(x_start-1,y_start);
				}
			}//���� Ȯ��	
		}	
		return dp[x_start][y_start];	
}
	public static void main(String[] agrs)
	{
		Scanner scan=new Scanner(System.in);
		M=scan.nextInt();
		N=scan.nextInt();
		scan.nextLine();//���๮�� ����
		map=new int[M][N];
		dp=new int[M][N];
	    String[] s;
		for(int i=0;i<M;i++)
		{
			s=scan.nextLine().split(" ");
			for(int j=0;j<N;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
				dp[i][j]=-1;
			}
		}
		System.out.println(DFS(0,0));
	}
}