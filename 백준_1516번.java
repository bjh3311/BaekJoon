import java.util.*;
import java.io.*;
public class 백준_1516번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] degree=new int[N+1];
		int[] result=new int[N+1];
		int[] time=new int[N+1];
		ArrayList<Integer>[] arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Integer>();
		}
		String[] s;
		for(int i=1;i<=N;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			time[i]=a;
			int j=1;
			while(Integer.parseInt(s[j])!=-1)
			{
				degree[i]++;
				arr[Integer.parseInt(s[j])].add(i);
				j++;
			}
			
		}
		Queue<Integer> q=new LinkedList<Integer>();
		for(int i=1;i<=N;i++)
		{
			if(degree[i]==0)
			{
				q.add(i);
			}
		}
		while(!q.isEmpty())
		{
			int v=q.poll();
			for(int i=0;i<arr[v].size();i++)
			{
				int next=arr[v].get(i);
				degree[next]--;
				result[next]=Math.max(result[next], result[v]+time[v]);
				if(degree[next]==0)
				{
					q.add(next);
				}
				
			}
		}
		for(int i=1;i<=N;i++)//결과 출력
		{
			System.out.println(result[i]+time[i]);
		}
	}
}
