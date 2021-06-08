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
	public int compareTo(Node o1)
	{
		return w-o1.w;
	}
}
public class 백준_1647번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s;
		s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		ArrayList<Node>[] map=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			map[i]=new ArrayList<Node>();
		}
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);
			map[a].add(new Node(b,c));
			map[b].add(new Node(a,c));
		}
		boolean[] visited=new boolean[N+1];
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		q.add(new Node(1,0));
		int result=0;
		int max=0;//단순히 생각해서 최소 스패닝 트리를 완성시킨 후 완성된 간선들 중 가장 큰 값을 빼면 된다
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			int now=temp.v;
			if(visited[now])
			{
				continue;
			}
			result+=temp.w;
			max=Math.max(temp.w, max);
			visited[now]=true;
			for(int i=0;i<map[now].size();i++)
			{
				int next=map[now].get(i).v;
				if(!visited[next])
				{
					q.add(new Node(next,map[now].get(i).w));
				}
			}
		}
		System.out.println(result-max);
	}

}
