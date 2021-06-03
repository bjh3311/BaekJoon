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
public class 백준_14621번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		s=br.readLine().split(" ");
		int[] gender=new int[N+1];
		for(int i=0;i<N;i++)
		{
			if(s[i].equals("M"))//남자면 1
			{
				gender[i+1]=1;
			}
			else//여자면 0
			{
				gender[i+1]=0;
			}
		}
		ArrayList<Node>[] arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Node>();
		}
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);
			arr[a].add(new Node(b,c));
			arr[b].add(new Node(a,c));
		}
		boolean[] visited=new boolean[N+1];
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		q.add(new Node(1,0));
		int result=0;
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
				int weight=arr[v].get(i).w;
				if(!visited[next]&&(gender[v]!=gender[next]))//방문된적없고 성별이 달라야 한다
				{
					q.add(new Node(next,weight));
				}
			}
		}
		for(int i=1;i<=N;i++)
		{
			if(!visited[i])//방문된적이 없는 점이 있다면, 즉 경로가 존재하지 않다면
			{
				System.out.println("-1");
				System.exit(0);
			}
		}
		System.out.println(result);
	}
}
