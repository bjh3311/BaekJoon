import java.util.*;
import java.io.*;
public class 백준_3665번 {
	public static boolean ispossible;
	public static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());//테스트케이스 개수 입력
		while(T>0)
		{
			ispossible=false;
			int n=Integer.parseInt(br.readLine());//팀의 개수
			int[] indegree=new int[n+1];
			arr=new ArrayList[n+1];
			for(int i=1;i<=n;i++)
			{
				arr[i]=new ArrayList<Integer>();
			}
			String[] s=br.readLine().split(" ");//작년 팀 등수 입력
			for(int i=0;i<n;i++)
			{
				int index=Integer.parseInt(s[i]);
				for(int j=i+1;j<n;j++)
				{
					arr[index].add(Integer.parseInt(s[j]));
				}
			}
			int m=Integer.parseInt(br.readLine());//바뀐 쌍의 개수 입력
			for(int i=0;i<m;i++)
			{
				s=br.readLine().split(" ");
				int a=Integer.parseInt(s[0]);
				int b=Integer.parseInt(s[1]);
				if(arr[a].contains(Integer.valueOf(b)))
				{
					arr[a].remove(Integer.valueOf(b));
					arr[b].add(a);
				}
				else if(arr[b].contains(Integer.valueOf(a)))
				{
					arr[b].remove(Integer.valueOf(a));
					arr[a].add(b);
				}
			}//간선을 변경한다
			for(int i=1;i<=n;i++)
			{
				for(int j=0;j<arr[i].size();j++)
				{
					int next=arr[i].get(j);
					indegree[next]++;
				}
			}//indegree를 증가시켜준다.
			StringBuilder sb=new StringBuilder();
			Queue<Integer> q=new LinkedList<Integer>();
			int count=0;
			for(int i=1;i<=n;i++)
			{
				if(indegree[i]==0)
				{
					count++;
					q.add(i);
				}
			}
			if(count>1)
			{
				System.out.println("?");
				continue;
			}
			ispossible=false;
			for(int i=1;i<=n;i++)
			{
				if(q.isEmpty())
				{
					System.out.println("IMPOSSIBLE");
					ispossible=true;
					break;
				}
				int from=q.poll();
				sb.append(from+" ");
				for(int to:arr[from])
				{
					indegree[to]--;
					if(indegree[to]==0)
					{
						q.add(to);
					}
				}
			}
			if(ispossible)
			{
				T--;
				continue;
			}
			System.out.println(sb.toString());
			T--;
		}
	}
}