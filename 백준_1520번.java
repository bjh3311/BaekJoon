import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class 백준_1520번 {
	public static int N;
	public static int M;
	public static int[][] map;//연구소의 원본
	public static int[][] dp;//dp를 위한 배열
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
			}//오른쪽 확인	
			if(y_start-1>=0)
			{
				if(map[x_start][y_start]>map[x_start][y_start-1])
				{
					
					dp[x_start][y_start]+=DFS(x_start,y_start-1);
				}
			}//왼쪽 확인	
			if(x_start+1<M)
			{
				if(map[x_start][y_start]>map[x_start+1][y_start])
				{
				
					dp[x_start][y_start]+=DFS(x_start+1,y_start);	
				}
			}//아래쪽 확인	
			if(x_start-1>=0)
			{
				if(map[x_start][y_start]>map[x_start-1][y_start])
				{
					dp[x_start][y_start]+=DFS(x_start-1,y_start);
				}
			}//위쪽 확인	
		}	
		return dp[x_start][y_start];	
}
	public static void main(String[] agrs)
	{
		Scanner scan=new Scanner(System.in);
		M=scan.nextInt();
		N=scan.nextInt();
		scan.nextLine();//개행문자 제거
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