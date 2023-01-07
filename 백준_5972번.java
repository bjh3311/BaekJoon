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
public class 백준_5972번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int[] dist=new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1]=0;
		ArrayList<Node>[] arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Node>();
		}
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int A=Integer.parseInt(s[0]);
			int B=Integer.parseInt(s[1]);
			int C=Integer.parseInt(s[2]);
			arr[A].add(new Node(B,C));
			arr[B].add(new Node(A,C));
		}
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		q.add(new Node(1,0));
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			for(Node next:arr[temp.v])
			{
				if(dist[next.v]>temp.w+next.w)
				{
					dist[next.v]=temp.w+next.w;
					q.add(new Node(next.v,dist[next.v]));
				}
			}
		}
		System.out.println(dist[N]);
	}

}
