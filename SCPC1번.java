import java.util.*;
import java.io.*;
public class SCPC1번 {

	public static int Answer;
	public static boolean[] visited;
	public static ArrayList<Integer>[] map;
	public static int N;
	public static void DFS(int start)
	{
		visited[start]=true;
		for(int next: map[start])
		{
			if(!visited[next])
			{
				DFS(next);
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int test_case=0;test_case<T;test_case++)
		{
			Answer=0;
			N=Integer.parseInt(br.readLine());
			String[] s=br.readLine().split(" ");
			map=new ArrayList[N+1];
			visited=new boolean[N+1];
			for(int i=1;i<=N;i++)
			{
				map[i]=new ArrayList<Integer>();
			}
			for(int i=1;i<=N;i++)
			{
				int a=Integer.parseInt(s[i-1]);
				if(i+a<=N)
				{
					map[i].add(i+a);
					map[i+a].add(i);
				}//양방향 간선
			}
			for(int i=1;i<=N;i++)
			{
				if(!visited[i])
				{
					DFS(i);
					Answer++;
				}
			}
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}
