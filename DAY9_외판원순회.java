import java.util.*;
import java.io.*;
public class DAY9_���ǿ���ȸ {

	public static int[][] W;
	public static int[][] dp;//�� �ε����� �湮����̴�
	public static int N;
	public static int visitAll;
	public static int result;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		W=new int[N+1][N+1];
		String[] s;
		for(int i=1;i<=N;i++)//����ġ �Է�
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
		DFS(1,1);//�������� 1
		System.out.println(result);
	}
	public static void DFS(int n,int visited)
	{
		if(visited==visitAll)//�� �湮�ߴµ� ���������� ������ �������̴�
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
			int next=(1<<(i-1));//���� �湮�� ������ 2���ϰ�� 2, 3���ϰ�� 4, 4���� ��� 8...
			int nextVisited=visited|next;
			if(visited==nextVisited)//�̹� �湮�ߴ�
			{
				continue;
			}
			if(W[n][i]==0)//��ΰ������� continue
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
