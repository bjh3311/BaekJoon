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
public class ����_1238�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int X=Integer.parseInt(s[2]);
		ArrayList<Node>[] edge=new ArrayList[N+1];//������ ���� �Է�
		ArrayList<Node>[] reverse_edge=new ArrayList[N+1];//�Ųٷ�
		for(int i=1;i<=N;i++)
		{
			edge[i]=new ArrayList<Node>();
			reverse_edge[i]=new ArrayList<Node>();
		}
		int[] out=new int[N+1];//X���� �� ������ ���� �Ÿ�
		int[] in=new int[N+1];//���������� X�� ���� �Ÿ�
		Arrays.fill(in, Integer.MAX_VALUE);
		Arrays.fill(out, Integer.MAX_VALUE);//���ͽ�Ʈ�� �����ҋ� �� �Ÿ��� �� �ִ밪���� ����
		in[X]=0;
		out[X]=0;//�������� �ϴ� �� 0���� �ʱ�ȭ
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);//a���� b�ΰ��� c����ġ�� ����
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
