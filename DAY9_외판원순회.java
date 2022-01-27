import java.util.*;
import java.io.*;
public class DAY9_외판원순회 {

	public static int[][] W;
	public static int[][] dp;//뒤 인덱스는 방문기록이다
	public static int N;
	public static int visitAll;
	public static int result;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		W=new int[N+1][N+1];
		String[] s;
		for(int i=1;i<=N;i++)//가중치 입력
		{
			s=br.readLine().split(" ");
			for(int j=1;j<=N;j++)
			{
				W[i][j]=Integer.parseInt(s[j-1]);
			}
		}
		result=Integer.MAX_VALUE;
		visitAll=(1<<N)-1;
		dp=new int[N+1][visitAll+1];
		for(int i=1;i<=N;i++)
		{
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		dp[1][1]=0;
		DFS(1,1);//시작점은 1
		System.out.println(result);
	}
	public static void DFS(int n,int visited)
	{
		if(visited==visitAll)//다 방문했는데 시작점으로 못가면 나가리이다
		{
			if(W[n][1]==0)
			{
				return;
			}
			result=Math.min(result,dp[n][visited]+W[n][1]);
			return;
		}
		for(int i=1;i<=N;i++)
		{
			int next=(1<<(i-1));//다음 방문할 지점이 2번일경우 2, 3번일경우 4, 4번일 경우 8...
			int nextVisited=visited|next;
			if(visited==nextVisited)//이미 방문했다
			{
				continue;
			}
			if(W[n][i]==0)//경로가없으면 continue
			{
				continue;
			}
			if(dp[i][next+visited]>dp[n][visited]+W[n][i])
			{
				dp[i][next+visited]=dp[n][visited]+W[n][i];
				DFS(i,next+visited);
			}
		}
	}

}
