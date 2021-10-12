import java.util.*;
import java.io.*;
class Node 
{
	double x;
	double y;
	public Node(double x,double y)
	{
		this.x=x;
		this.y=y;
	}
}
class Edge implements Comparable<Edge>
{
	int start;
	int end;
	double w;
	public Edge(int start,int end,double w)
	{
		this.start=start;
		this.end=end;
		this.w=w;
	}
	@Override
	public int compareTo(Edge o)
	{
		if(w<o.w)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
}
public class 백준_1774번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		Node[] arr=new Node[N+1];
		for(int i=1;i<=N;i++)
		{
			s=br.readLine().split(" ");
			double x=Double.parseDouble(s[0]);
			double y=Double.parseDouble(s[1]);
			arr[i]=new Node(x,y);
		}
		ArrayList<Edge> edge=new ArrayList<Edge>();
		for(int i=1;i<=N;i++)
		{
			for(int j=i+1;j<=N;j++)
			{
				double weight=dis(arr[i],arr[j]);
				edge.add(new Edge(i,j,weight));
			}
		}
		Collections.sort(edge);//간선 오름차순으로 정렬
		parent=new int[N+1];
		for(int i=1;i<=N;i++)
		{
			parent[i]=i;//처음에는 자기 자신이 부모이다
		}
		double result=0;
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int start=Integer.parseInt(s[0]);
			int end=Integer.parseInt(s[1]);
			Union(start,end);
		}
		for(int i=0;i<edge.size();i++)
		{
			Edge temp=edge.get(i);
			if(findParent(temp.start)!=findParent(temp.end))
			{
				result+=temp.w;
				Union(temp.start,temp.end);
			}
		}
		System.out.printf("%.2f",result);
	}
	public static double dis(Node p1, Node p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}
	public static int[] parent;
	public static int findParent(int x)
	{
		if(parent[x]==x)
		{
			return x;
		}
		return findParent(parent[x]);
	}	
	public static void Union(int a,int b)
	{
		int x=findParent(a);//x는 a의 부모
		int y=findParent(b);//y는 b의 부모
		if(x<y)
		{
			parent[y]=x;
		}
		else
		{
			parent[x]=y;
		}
	}
}
