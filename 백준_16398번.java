import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int A;
	int B;
	int w;
	public Node(int A,int B,int w)
	{
		this.A=A;
		this.B=B;
		this.w=w;
	}
	public int compareTo(Node o)
	{
		return w-o.w;
	}
}
public class 백준_16398번 {

	public static int[] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		parent=new int[N];
		for(int i=0;i<N;i++)
		{
			parent[i]=i;
		}
		String[] s;
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=i+1;j<N;j++)
			{
				q.add(new Node(i,j,Integer.parseInt(s[j])));
			}
		}
		long result=0;
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			if(Find(temp.A)==Find(temp.B))
			{
				continue;
			}
			result=result+temp.w;
			Union(temp.A,temp.B);
		}
		System.out.println(result);
	}
	public static void Union(int a,int b)
	{
		a=Find(a);
		b=Find(b);
		if(b<a)
		{
			parent[a]=b;
		}
		else
		{
			parent[b]=a;
		}
	}
	public static int Find(int n)
	{
		if(parent[n]==n)
		{
			return n;
		}
		else 
		{
			return parent[n]=Find(parent[n]);
		}
	}
}
