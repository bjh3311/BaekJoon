import java.util.*;
import java.io.*;
public class น้มุ_9466น๘{

	public static int[] arr;
	public static int n;
	public static boolean[] visited;
	public static boolean[] real_visited;
	public static Queue<Integer> q=new LinkedList<Integer>();
	public static int start;
	public static int result;
	public static void dfs(int init)
	{
		if(visited[init])
		{
			return;
		}
		visited[init]=true;
		int next=arr[init];
		if(!visited[next])
		{
			dfs(next);
		}
		else
		{
			if(!real_visited[next])
			{
				result++;
				for(int i=next;i!=init;i=arr[i])
				{
					result++;
				}
			}
		}
		real_visited[init]=true;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++)
		{
			n=Integer.parseInt(br.readLine());
			result=0;
		    arr=new int[n+1];
		    visited=new boolean[n+1];
		    real_visited=new boolean[n+1];
		    String[] s=br.readLine().split(" ");
		    for(int j=1;j<n+1;j++)
		    {
		    	arr[j]=Integer.parseInt(s[j-1]);
		    }
		    for(int j=1;j<n+1;j++)
		    {
		    	if(!real_visited[j])
		    	{
		    		start=j;
			    	dfs(j);
			    	q.clear();
			    	real_visited[j]=true;
		    	}    	
		    }
		    sb.append(n-result+"\n");
		}
		System.out.print(sb.toString());
	}
}
