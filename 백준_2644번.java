import java.util.*;
import java.io.*;
public class 백준_2644번 {
	public static boolean[] visited;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());//정점의 개수
		ArrayList<Integer>[] chonsu=new ArrayList[n+1];
		for(int i=0;i<=n;i++)
		{
			chonsu[i]=new ArrayList<Integer>();
		}//ArrayList로 그래프 표현
		String[]  s=br.readLine().split(" ");
		int start=Integer.parseInt(s[0]);
		int end=Integer.parseInt(s[1]);
		int m=Integer.parseInt(br.readLine());//간선의 개수
		visited=new boolean[n+1];
		for(int i=0;i<m;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			chonsu[a].add(b);
			chonsu[b].add(a);//무방향 그래프이다
		}
		Queue<Integer> q=new LinkedList<Integer>();//BFS실행을 위한 큐 선언
		q.add(start);
		visited[start]=true;
		int[] result=new int[n+1];
		result[start]=0;
		while(!q.isEmpty())
		{
			int temp=q.poll();
			for(int i=0;i<chonsu[temp].size();i++)
			{
				int a=chonsu[temp].get(i);
				if(!visited[a])
				{
					result[a]=result[temp]+1;
					visited[a]=true;
					q.add(a);
				}
			}
		}
		if(result[end]==0)
		{
			System.out.println("-1");
		}
		else
		{
			System.out.println(result[end]);
		}

	}

}
