import java.util.*;
public class 프로그래머스_네트워크 {
	public int solution(int n,int[][] computers)
	{
		int answer=0;
		visited=new boolean[n];
		arr=new ArrayList[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i!=j&&computers[i][j]==1)
				{
					arr[i].add(j);
					arr[j].add(i);
				}
			}
		}
		for(int i=0;i<n;i++)
		{
			if(!visited[i])//방문된적이 없다면
			{
				answer++;
				DFS(i);
			}
		}
		return answer;
	}
	public static ArrayList<Integer>[] arr;
	public static boolean[] visited;
	public static void DFS(int start)
	{
		visited[start]=true;
		for(int next:arr[start])
		{
			if(!visited[next])//방문된적이 있다면
			{
				DFS(next);
			}
		}
	}

}
