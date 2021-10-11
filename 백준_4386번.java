import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	double x;
	double y;
	int v;
	double dis;
	public Node(double x,double y)
	{
		this.x=x;
		this.y=y;
	}
	public Node(int v,double dis)
	{
		this.v=v;
		this.dis=dis;
	}
	public int compareTo(Node o)
	{
		return (int)(dis-o.dis);
	}
}
public class น้มุ_4386น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String[] s;
		Node[] temp=new Node[n];
		for(int i=0;i<n;i++)
		{
			s=br.readLine().split(" ");
			double a=Double.parseDouble(s[0]);
			double b=Double.parseDouble(s[1]);
			temp[i]=new Node(a,b);
		}
		ArrayList<Node>[] arr=new ArrayList[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=new ArrayList<Node>();
		}
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				double x=temp[i].x-temp[j].x;
				double y=temp[i].y-temp[j].y;
				double dis=Math.sqrt((x*x)+(y*y));
				arr[i].add(new Node(j,dis));
				arr[j].add(new Node(i,dis));
			}
		}
		boolean[] visited=new boolean[n];
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		q.add(new Node(1,0.0));
		double result=0;
		while(!q.isEmpty())
		{
			Node tmp=q.poll();
			if(visited[tmp.v])
			{
				continue;
			}
			visited[tmp.v]=true;
			result+=tmp.dis;
			for(Node a:arr[tmp.v])
			{
				if(!visited[a.v])
				{
					q.add(a);
				}
			}
		}
		System.out.printf("%.2f", result);
	}
}
