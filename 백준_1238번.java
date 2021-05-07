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
	public int compareTo(Node o)
	{
		return w-o.w;
	}
}
public class 백준_1238번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int X=Integer.parseInt(s[2]);
		ArrayList<Node>[] edge=new ArrayList[N+1];//정상적 간선 입력
		ArrayList<Node>[] reverse_edge=new ArrayList[N+1];//거꾸로
		for(int i=1;i<=N;i++)
		{
			edge[i]=new ArrayList<Node>();
			reverse_edge[i]=new ArrayList<Node>();
		}
		int[] out=new int[N+1];//X에서 각 마을로 가는 거리
		int[] in=new int[N+1];//각마을에서 X로 가는 거리
		Arrays.fill(in, Integer.MAX_VALUE);
		Arrays.fill(out, Integer.MAX_VALUE);//다익스트라 시작할떄 각 거리는 다 최대값으로 지정
		in[X]=0;
		out[X]=0;//시작점은 일단 다 0으로 초기화
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);//a에서 b로가는 c가중치의 간선
			edge[a].add(new Node(b,c));
			reverse_edge[b].add(new Node(a,c));
		}
		q.add(new Node(X,0));
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			int v=temp.v;
			for(int i=0;i<edge[v].size();i++)
			{
				int nv=edge[v].get(i).v;
				int nw=edge[v].get(i).w;
				if(out[nv]>out[v]+nw)
				{
					out[nv]=out[v]+nw;
					q.add(new Node(nv,out[nv]));
				}
			}
		}
		q.add(new Node(X,0));
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			int v=temp.v;
			for(int i=0;i<reverse_edge[v].size();i++)
			{
				int nv=reverse_edge[v].get(i).v;
				int nw=reverse_edge[v].get(i).w;
				if(in[nv]>in[v]+nw)
				{
					in[nv]=in[v]+nw;
					q.add(new Node(nv,in[nv]));
				}
			}
		}
		int result=0;
		for(int i=1;i<=N;i++)
		{
			result=Math.max(result, in[i]+out[i]);
		}
		System.out.println(result);
		
	}

}
