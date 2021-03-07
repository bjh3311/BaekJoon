import java.util.*;
import java.io.*;
public class 백준_6118번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		ArrayList<Integer>[] graph=new ArrayList[N+1];
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
		boolean[] visited=new boolean[N+1];
		int[] result=new int[N+1];
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(1);
		visited[1]=true;
		result[1]=0;
		while(!q.isEmpty())
		{
			int temp=q.poll();
			for(int i=0;i<graph[temp].size();i++)
			{
				int a=graph[temp].get(i);
				if(!visited[a])
				{
					visited[a]=true;
					result[a]=result[temp]+1;
					q.add(a);
				}
			}
		}
		int max=0;
		int count=0;
		for(int i=1;i<=N;i++)
		{
			max=Math.max(max, result[i]);
		}//헛간까지의 거리 구하기
		for(int i=1;i<=N;i++)
		{
			if(max==result[i])
			{
				System.out.print(i+" ");
				break;
			}
		}//헛간번호 출력
		System.out.print(max+" ");
		for(int i=1;i<=N;i++)
		{
			if(max==result[i])
			{
				count++;
			}
		}
		System.out.print(count);//거리가 같은 헛간 갯수 출력
	}

}
