import java.util.*;
import java.io.*;
public class ����_2533�� {

	public static ArrayList<Integer>[] tree;
	public static int[][] dp;//�ι�° �ε����� 0�̸� ����̴��Ͱ� �ƴҶ�, 1�̸� ����̴����� ��
	public static int N;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		String[] s;
		tree=new ArrayList[N+1];
		dp=new int[N+1][2];
		for(int i=1;i<=N;i++)
		{
			tree[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<N-1;i++)
		{
			s=br.readLine().split(" ");
			int u=Integer.parseInt(s[0]);
			int v=Integer.parseInt(s[1]);
			tree[u].add(v);
			tree[v].add(u);
		}
		dp(1,-1);//��Ʈ��� 1���� ����, ��Ʈ����� parent�� �������� �ʱ⿡ -1
		System.out.println(Math.min(dp[1][0], dp[1][1]));

	}
	public static void dp(int cur,int parent)
	{
		dp[cur][0]=0;
		dp[cur][1]=1;
		for(int next:tree[cur])
		{
			if(next!=parent)
			{
				dp(next,cur);
				dp[cur][0]+=dp[next][1];
				dp[cur][1]+=Math.min(dp[next][0],dp[next][1]);
			}
		}
	}

}
