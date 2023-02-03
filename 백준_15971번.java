import java.util.*;
import java.io.*;
class Node
{
	int v;
	int w;
	Node(int v,int w)
	{
		this.v=v;
		this.w=w;
	}
}
public class 백준_15971번 {

	public static int result;
	public static ArrayList<Node>[] arr;
	public static boolean[] visited;
	public static int A;
	public static int B;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		A=Integer.parseInt(s[1]);
		B=Integer.parseInt(s[2]);
		arr=new ArrayList[N+1];
		visited=new boolean[N+1];
		result=Integer.MAX_VALUE;
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Node>();
		}
		for(int i=0;i<N-1;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int w=Integer.parseInt(s[2]);
			arr[a].add(new Node(b,w));
			arr[b].add(new Node(a,w));
		}
		visited[A]=true;
		DFS(A,0,0);
		System.out.println(result);
	}
	public static void DFS(int v1,int sum,int max)
	{
		if(v1==B)
		{
			result=Math.min(result, sum-max);
			return;
		}
		for(Node next : arr[v1])
		{
			if(!visited[next.v])
			{
				visited[next.v]=true;
				DFS(next.v,sum+next.w,Math.max(max, next.w));
			}
		}
	}
}
