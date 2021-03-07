import java.util.*;
import java.io.*;
public class 백준_11724번 {

	public static boolean[] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		ArrayList<Integer>[] graph=new ArrayList[N+1];
		visited=new boolean[N+1];
		for(int i=1;i<=N;i++)
		{
			graph[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			graph[a].add(b);
			graph[b].add(a);
		}
		int count=0;//연결요소의 개수
		Queue<Integer> q=new LinkedList<Integer>();
		for(int i=1;i<=N;i++)
		{
			if(!visited[i])
			{
				q.add(i);
				count++;
			}
			while(!q.isEmpty())
			{
				int temp=q.poll();
				for(int j=0;j<graph[temp].size();j++)
				{
					int a=graph[temp].get(j);
					if(!visited[a])
					{
						q.add(a);
						visited[a]=true;
					}
				}
			}	
		}
		System.out.println(count);
		

	}

}
