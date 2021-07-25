import java.util.*;
import java.io.*;
public class 백준_2533번 {

	public static ArrayList<Integer>[] tree;
	public static int[][] dp;//두번째 인덱스가 0이면 얼라이답터가 아닐때, 1이면 얼라이답터일 때
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
		dp(1,-1);//루트노드 1에서 시작, 루트노드의 parent는 존재하지 않기에 -1
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
