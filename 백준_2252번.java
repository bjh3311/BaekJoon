import java.util.*;
import java.io.*;
public class 백준_2252번 {//위상정렬 문제

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		ArrayList<Integer>[] arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Integer>();
		}
		Queue<Integer> q=new LinkedList<Integer>();
		int[] degree=new int[N+1];//In 차수를 세기 위한 배열 선언
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			arr[a].add(b);
			degree[b]++;
		}
		for(int i=1;i<=N;i++)
		{
			if(degree[i]==0)//In 차수가 0이면 큐에 넣는다
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
				degree[next]--;
				if(degree[next]==0)
				{
					q.add(next);
				}
			}
		}
	}

}
