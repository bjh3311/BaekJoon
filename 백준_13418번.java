import java.util.*;
import java.io.*;
class Node 
{
	int v;
	int updown;//up이면 1 down이면 -1
	public Node(int v,int updown)
	{
		this.v=v;
		this.updown=updown;
	}
}
public class 백준_13418번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);//정점
		int M=Integer.parseInt(s[1]);//도로
		ArrayList<Node>[] arr=new ArrayList[N+1];
		for(int i=0;i<=N;i++)
		{
			arr[i]=new ArrayList<Node>();
		}
		for(int i=0;i<=M;i++)
		{
			s=br.readLine().split(" ");
			int A=Integer.parseInt(s[0]);
			int B=Integer.parseInt(s[1]);
			int C=Integer.parseInt(s[2]);
			arr[A].add(new Node(B,C));
			arr[B].add(new Node(A,C));
		}
		int up=0;
		PriorityQueue<Node> downq=new PriorityQueue<Node>((Node o1,Node o2)->o1.updown-o2.updown);//최소힙
		downq.add(new Node(0,-1));
		boolean[] visited=new boolean[N+1];
		while(!downq.isEmpty())
		{
			Node temp=downq.poll();
			if(visited[temp.v])
			{
				continue;
			}
			visited[temp.v]=true;
			if(temp.updown==0)
			{
				up++;
			}
			for(Node next : arr[temp.v])
			{
				downq.add(next);
			}
		}
		visited=new boolean[N+1];//방문배열 초기화
		int k=0;
		PriorityQueue<Node> upq=new PriorityQueue<Node>((Node o1,Node o2)->o2.updown-o1.updown);
		upq.add(new Node(0,-1));
		while(!upq.isEmpty())
		{
			Node temp=upq.poll();
			if(visited[temp.v])
			{
				continue;
			}
			visited[temp.v]=true;
			if(temp.updown==0)
			{
				k++;
			}
			for(Node next : arr[temp.v])
			{
				upq.add(next);
			}
		}
		System.out.println((up*up)-(k*k));
	}
}
