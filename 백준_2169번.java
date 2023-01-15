import java.util.*;
import java.io.*;

public class 백준_2169번 {

	public static int[] dx= {-1,0,1};
	public static int[] dy= {0,1,0};//왼쪽,오른쪽, 아래쪽 이동
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int[][] map=new int[N][M];
		int[][] dp=new int[N][M];
		int[][] temp=new int[2][1001];//temp[0]은 왼쪽에서 오른쪽, temp[1] 오른쪽에서 왼쪽
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<M;j++)
			{
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		dp[0][0]=map[0][0];//0,0에서 시작하니깐
		for(int i=1;i<M;i++)//첫번째줄은 정해져 있다.
		{
			dp[0][i]=dp[0][i-1]+map[0][i];
		}
		for(int i=1;i<N;i++)
		{
			dp[i][0]=dp[i-1][0]+map[i][0];//각 줄의 첫번째는 일단 위에서 내려온걸로
			temp[0][0]=dp[i][0];
			for(int j=1;j<M;j++)
			{
				temp[0][j]=Math.max(temp[0][j-1], dp[i-1][j])+map[i][j];
			}
			dp[i][M-1]=dp[i-1][M-1]+map[i][M-1];
			temp[1][M-1]=dp[i][M-1];
			for(int j=M-2;j>=0;j--)
			{
				temp[1][j]=Math.max(temp[1][j+1], dp[i-1][j])+map[i][j];
			}
			for(int j=0;j<M;j++)
			{
				dp[i][j]=Math.max(temp[0][j], temp[1][j]);
			}
		}
		System.out.println(dp[N-1][M-1]);
	}
}
