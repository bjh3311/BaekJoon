import java.util.*;
import java.io.*;

public class 백준_17471번 {

	public static int[] pop;//인구수
	public static ArrayList<Integer>[] arr;
	public static int answer=Integer.MAX_VALUE;
	public static boolean[] visited;//true면 A선거구, false면 B선거구
	public static int N;
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);		
		N=sc.nextInt();
		pop=new int[N+1];
		arr=new ArrayList[N+1];
		visited=new boolean[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Integer>();
		}
		for(int i=1;i<=N;i++)//각 구역 인구수와 인구수 총합 구하기
		{
			pop[i]=sc.nextInt();
		}
		for(int i=1;i<=N;i++)//각 구역의 인접 구역 입력
		{
			int m=sc.nextInt();
			for(int j=0;j<m;j++)
			{
				int b=sc.nextInt();
				arr[i].add(b);
				arr[b].add(i);
			}
		}
		subset(1);
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
		//answer가 Integer.MAX_VALUE, 즉 바뀌지 않았다면 두 선거구로 못나눴다는 뜻이므로
		//-1을 출력해준다. 아니라면 answer를 그대로 출력
	}
	public static void subset(int cnt)
	{
		if(cnt==N)
		{
			ArrayList<Integer> a=new ArrayList<Integer>();
			ArrayList<Integer> b=new ArrayList<Integer>();
			for(int i=1;i<=N;i++)
			{
				if(visited[i])
				{
					a.add(i);
				}
				else
				{
					b.add(i);
				}
			}
			if(a.size()+b.size()!=N)
			{
				return;
			}
			if(a.size()==0||b.size()==0)
			{
				return;
			}
			if(isPossible(a,'a')&&isPossible(b,'b'))
			{
				int temp_A=0;
				int temp_B=0;
				for(int i=0;i<a.size();i++)
				{
					temp_A+=pop[a.get(i)];
				}
				for(int i=0;i<b.size();i++)
				{
					temp_B+=pop[b.get(i)];
				}
				answer=Math.min(answer, Math.abs(temp_A-temp_B));
			}
			return;
		}
		visited[cnt]=true;
		subset(cnt+1);
		visited[cnt]=false;
		subset(cnt+1);
	}
	public static boolean isPossible(ArrayList<Integer> a,char team)
	{
		boolean[] connect=new boolean[N+1];
		int cur=a.get(0);
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(cur);
		connect[cur]=true;
		while(!q.isEmpty())
		{
			int temp=q.poll();
			for(int i=0 ;i<arr[temp].size();i++)
			{
				int next=arr[temp].get(i);
				if(connect[next])
				{
					continue;
				}
				if((visited[next]&&team=='a')||(!visited[next]&&team=='b'))
				{
					q.add(next);
					connect[next]=true;
				}
			}
		}
		for(int i=0;i<a.size();i++)
		{
			if(!connect[a.get(i)])
			{
				return false;
			}
		}
		return true;
	}
}           