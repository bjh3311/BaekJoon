import java.util.*;
import java.io.*;
public class น้มุ_2056น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] indegree=new int[N+1];
		int[] time=new int[N+1];
		String[] s;
		ArrayList<Integer>[] arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Integer>();
		}
		int[] result=new int[N+1];
		for(int i=1;i<=N;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			time[i]=a;
			int b=Integer.parseInt(s[1]);
			indegree[i]=b;
			for(int j=1;j<=b;j++)
			{
				int c=Integer.parseInt(s[j+1]);
				arr[c].add(i);
			}
		} 
		Queue<Integer> q=new LinkedList<Integer>();
		boolean[] visited=new boolean[N+1];
		for(int i=1;i<=N;i++)
		{
			result[i]=time[i];
		}
		for(int i=1;i<=N;i++)
		{
			if(indegree[i]==0)
			{
				q.add(i);
			}
		}
		int answer=0;
		while(!q.isEmpty())
		{
			int now=q.poll();
			for(int i=0;i<arr[now].size();i++)
			{
				int next=arr[now].get(i);
				indegree[next]--;
				result[next]=Math.max(result[next], result[now]+time[next]);
				if(!visited[next]&&indegree[next]==0)
				{
					q.add(next);
				}
			}
			
		}
		for(int i=1;i<=N;i++)
		{
			answer=Math.max(answer, result[i]);
		}
		System.out.println(answer);	
	}
}
