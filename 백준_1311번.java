import java.util.*;
import java.io.*;

public class ����_1311�� {

	public static int[][] arr;
	public static int[][] dp;
	public static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];//�� ��
		dp=new int[N][1<<N];
		String[] s;
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<N;j++)
			{
				arr[i][j]=Integer.parseInt(s[j]);
			}
		}
		System.out.println(DFS(0,0));
	}
	public static int DFS(int n,int visited)
	{
		if(n==N)//��� ��� ���������� ��
		{
			return 0;
		}
		if(dp[n][visited]!=0)//�̹� �����ߴٸ� 
		{
			return dp[n][visited];
		}
		int result=Integer.MAX_VALUE;
		for(int i=0;i<N;i++)
		{
			int next=1<<i;
			int temp=next | visited;
			if(temp!=visited)
			{
				result=Math.min(result,arr[n][i]+DFS(n+1,temp));
			}
		}
		dp[n][visited]=result;
		return dp[n][visited];
	}
}
