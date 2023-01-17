import java.util.*;
import java.io.*;
public class 백준_15681번 {

	public static ArrayList<Integer>[] arr;
	public static int[] dp;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);//정점의 수
		int R=Integer.parseInt(s[1]);//루트 번호
		int Q=Integer.parseInt(s[2]);//쿼리 수
		arr=new ArrayList[N+1];
		dp=new int[N+1];
		visited=new boolean[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<N-1;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			arr[a].add(b);
			arr[b].add(a);
		}
		DFS(R);
		for(int i=0;i<Q;i++)
		{
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}
	}
	public static int DFS(int R)
	{
		visited[R]=true;
		int result=1;
		for(Integer next : arr[R])
		{
			if(!visited[next])
			{
				result+=DFS(next);
			}
		}
		return dp[R]=result;
	}

}
