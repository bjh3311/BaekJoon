import java.util.*;
import java.io.*;
public class 백준_1005번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T>0)
		{
			String[] s=br.readLine().split(" ");
			int N=Integer.parseInt(s[0]);
			int K=Integer.parseInt(s[1]);
			int[] time=new int[N+1];//건물 짓는 시간
			int[] degree=new int[N+1];
			ArrayList<Integer>[] arr=new ArrayList[N+1];
			for(int i=1;i<=N;i++)
			{
				arr[i]=new ArrayList<Integer>();
			}
			s=br.readLine().split(" ");//건물 짓는 시간 입력
			for(int i=1;i<=N;i++)
			{
				time[i]=Integer.parseInt(s[i-1]);
			}
			for(int i=0;i<K;i++)
			{
				s=br.readLine().split(" ");
				int a=Integer.parseInt(s[0]);
				int b=Integer.parseInt(s[1]);
				arr[a].add(b);
				degree[b]++;
			}
			int des=Integer.parseInt(br.readLine());
			int[] result=new int[N+1];
			Queue<Integer> q=new LinkedList<Integer>();
			for(int i=1;i<=N;i++)
			{
				if(degree[i]==0)
				{
					q.add(i);
					result[i]=time[i];
				}
			}
			while(!q.isEmpty())
			{
				int temp=q.poll();
				for(int i=0;i<arr[temp].size();i++)
				{
					int next=arr[temp].get(i);
					degree[next]--;
					if(degree[next]==0)
					{
						q.add(next);
					}
					result[next]=Math.max(result[next], time[next]+result[temp]);
					
				}
			}
			System.out.println(result[des]);
			T--;
		}
	}
}
