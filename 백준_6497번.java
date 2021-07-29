import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int v;
	int w;
	Node(int v,int w)
	{
		this.v=v;
		this.w=w;
	}
	public int compareTo(Node o)
	{
		return w-o.w;
	}
}
public class 백준_6497번 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			String[] s=br.readLine().split(" ");
			int m=Integer.parseInt(s[0]);
			int n=Integer.parseInt(s[1]);
			if(m==0&&n==0)
			{
				break;
			}
			ArrayList<Node>[] arr=new ArrayList[m];
			for(int i=0;i<m;i++)
			{
				arr[i]=new ArrayList<Node>();
			}
			boolean[] visited=new boolean[m];
			int sum=0;
			for(int i=0;i<n;i++)
			{
				s=br.readLine().split(" ");
				int x=Integer.parseInt(s[0]);
				int y=Integer.parseInt(s[1]);
				int z=Integer.parseInt(s[2]);	
				sum=sum+z;
				arr[x].add(new Node(y,z));
				arr[y].add(new Node(x,z));
			}
			int spanning=0;
			PriorityQueue<Node> q=new PriorityQueue<Node>();
			q.add(new Node(0,0));//0번 집부터 시작
			while(!q.isEmpty())
			{
				Node temp=q.poll();
				if(visited[temp.v])
				{
					continue;
				}
				visited[temp.v]=true;
				spanning=spanning+temp.w;
				for(Node next:arr[temp.v])
				{
					if(!visited[next.v])
					{
						q.add(next);
					}
				}
			}
			System.out.println(sum-spanning);
		}

	}
}
