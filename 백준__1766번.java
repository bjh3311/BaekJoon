import java.util.*;
import java.io.*;
public class 백준__1766번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int[] indegree=new int[N+1];
		ArrayList<Integer>[] arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Integer>();
		}
		PriorityQueue<Integer> q=new PriorityQueue<Integer>();
		//숫자가 작은게 가장 먼저 나옴
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			arr[a].add(b);
			indegree[b]++;
		}
		for(int i=1;i<=N;i++)
		{
			if(indegree[i]==0)
			{
				q.add(i);
			}
		}
		while(!q.isEmpty())
		{
			int now=q.poll();
			System.out.print(now+" ");
			for(int i=0;i<arr[now].size();i++)
			{
				int next=arr[now].get(i);
				indegree[next]--;
				if(indegree[next]==0)
				{
					q.add(next);
				}
			}
		}

	}

}
