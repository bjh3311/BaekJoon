import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int u;
	int v;
	int w;
	Node(int u,int v,int w)
	{
		this.u=u;
		this.v=v;
		this.w=w;
	}
	public int compareTo(Node o)
	{
		return w-o.w;
	}
}
public class 백준_10423번 {

	public static int[] parent;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int K=Integer.parseInt(s[2]);
		PriorityQueue<Node> pq=new PriorityQueue<Node>();
		parent=new int[N+1];
		for(int i=1;i<=N;i++)
		{
			parent[i]=i;
		}
		s=br.readLine().split(" ");
		for(int i=0;i<K;i++)
		{
			parent[Integer.parseInt(s[i])]=-1;//발전소는 -1로
		}
		for(int j=0;j<M;j++)
		{
			s=br.readLine().split(" ");
			int u=Integer.parseInt(s[0]);
			int v=Integer.parseInt(s[1]);
			int w=Integer.parseInt(s[2]);
			pq.add(new Node(u,v,w));
		}
		int result=0;
		while(!pq.isEmpty())
		{
			Node temp=pq.poll();
			int u=Find(temp.u);
			int v=Find(temp.v);
			if(u==-1&&v==-1)//발전소는 겹치면 안된다
			{
				continue;
			}
			if(u==v)
			{
				continue;
			}
			result=result+temp.w;
			Union(temp.u,temp.v);
		}
		System.out.println(result);
	}
	public static int Find(int n)
	{
		if(n==-1)
		{
			return -1;
		}
		if(parent[n]==n)
		{
			return n;
		}
		else
		{
			return parent[n]=Find(parent[n]);
		}
	}
	public static void Union(int a,int b)
	{
		a=Find(a);
		b=Find(b);
		if(a==b)
		{
			return;
		}
		if(a<b)
		{
			parent[b]=a;
		}
		else
		{
			parent[a]=b;
		}
	}
}
