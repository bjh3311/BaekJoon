import java.util.*;
import java.io.*;

class Node implements Comparable<Node>
{
	int v;//연결되어 있는 노드 숫자
	int w;//가중치
	public Node(int v,int w)
	{
		this.v=v;
		this.w=w;
	}
	public int compareTo(Node o)//우선순위 큐에 넣을 것이다.
	{
		return w-o.w;
	}
}
public class 백준_2211번 {//트리를 형성하되 간선의 가중치 합이 가장 작은 트리를 찾자

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);//노드 갯수
		int M=Integer.parseInt(s[1]);//간선 갯수
		ArrayList<Node>[] arr=new ArrayList[N+1];
		int[] min=new int[N+1];
		int[] path=new int[N+1];
		
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
			arr[B].add(new Node(A,C));//양방향 간선이다	
		}
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		q.add(new Node(1,0));
		Arrays.fill(min, Integer.MAX_VALUE);
		min[1]=0;
		path[1]=-1;
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			if(temp.w>min[temp.v])
			{
				continue;
			}
			for(Node next : arr[temp.v])
			{
				if(min[next.v]>min[temp.v]+next.w)
				{
					min[next.v]=min[temp.v]+next.w;
					path[next.v]=temp.v;
					q.add(new Node(next.v,min[next.v]));
				}
			}
		}
		System.out.println(N-1);
		for(int i=2;i<=N;i++)
		{
			System.out.println(i+" "+path[i]);
		}
	}

}
