import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int V;
	int weight;
	public Node(int V,int weight)
	{
		this.V=V;
		this.weight=weight;
	}
	@Override
	public int compareTo(Node o)
	{
		return weight-o.weight;
	}
}
public class น้มุ_1197น๘ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int V=Integer.parseInt(s[0]);
		int E=Integer.parseInt(s[1]);
		int result=0;
		boolean[] visited=new boolean[V+1];
		ArrayList<Node>[] arr=new ArrayList[V+1];
		for(int i=1;i<=V;i++)
		{
			arr[i]=new ArrayList<Node>();
		}
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		for(int i=0;i<E;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);
			arr[a].add(new Node(b,c));
			arr[b].add(new Node(a,c));
		}
		q.offer(new Node(1,0));
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			int now=temp.V;
			if(visited[now])
			{
				continue;
			}
			visited[now]=true;
			result=result+temp.weight;
			for(int i=0;i<arr[now].size();i++)
			{
				int next=arr[now].get(i).V;
				if(!visited[next])
				{
					q.add(new Node(next,arr[now].get(i).weight));
				}
			}
		}
		System.out.println(result);
	}
}
