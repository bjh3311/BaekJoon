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
public class 백준_1368번 {
	public static int N;
	public static int[] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		int[] price=new int[N+1];
		parent=new int[N+1];
		for(int i=0;i<=N;i++)
		{
			parent[i]=i;
		}
		for(int i=1;i<=N;i++)
		{
			price[i]=Integer.parseInt(br.readLine());
		}
		String[] s;
		PriorityQueue<Node> pq=new PriorityQueue<Node>();
		for(int i=1;i<=N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=1;j<=N;j++)
			{
				if(i==j)
				{
					pq.add(new Node(0,j,price[j]));
				}
				else
				{
					pq.add(new Node(i,j,Integer.parseInt(s[j-1])));
				}
			}
		}
		int result=0;
		while(!pq.isEmpty())
		{
			Node temp=pq.poll();
			if(Find(temp.u)==Find(temp.v))//부모가 같으면 안된다
			{
				continue;
			}
			Union(temp.u,temp.v);
			result=result+temp.w;
		}
		System.out.println(result);
	}
	public static void Union(int a,int b)
	{
		a=Find(a);
		b=Find(b);
		if(a<b)
		{
			parent[b]=a;
		}
		else
		{
			parent[a]=b;
		}
	}
	public static int Find(int n)
	{
		if(parent[n]==n)
		{
			return n;
		}
		return parent[n]=Find(parent[n]);
	}
}