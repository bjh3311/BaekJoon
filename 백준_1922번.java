import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int v;
	int w;
	public Node(int v,int w)
	{
		this.v=v;
		this.w=w;
	}
	@Override
	public int compareTo(Node o1)
	{
		return w-o1.w;
	}
}
public class น้มุ_1922น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		ArrayList<Node>[] arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Node>();
		}
		boolean[] visited=new boolean[N+1];
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		String[] s;
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);
			arr[a].add(new Node(b,c));
			arr[b].add(new Node(a,c));
		}
		int result=0;
		q.add(new Node(1,0));
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			int v=temp.v;
			int w=temp.w;
			if(visited[v])
			{
				continue;
			}
			visited[v]=true;
			result=result+w;
			for(int i=0;i<arr[v].size();i++)
			{
				int next=arr[v].get(i).v;
				if(!visited[next])
				{
					q.add(new Node(next, arr[v].get(i).w));
				}
			}
		}
		System.out.println(result);
	}
}
