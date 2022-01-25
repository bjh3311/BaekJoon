import java.util.*;
import java.io.*;
class Node
{
	int start;
	int end;
	int w;
	public Node(int start,int end,int w)
	{
		this.start=start;
		this.end=end;
		this.w=w;
	}
}
public class DAY6_타임머신 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		ArrayList<Node> arr=new ArrayList<Node>();
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int A=Integer.parseInt(s[0]);
			int B=Integer.parseInt(s[1]);
			int C=Integer.parseInt(s[2]);
			arr.add(new Node(A,B,C));
		}
		long[] dist=new long[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1]=0;
		for(int i=0;i<N-1;i++)//처음에 쫙 한번 갱신
		{
			for(Node temp: arr)
			{
				if(dist[temp.start]!=Integer.MAX_VALUE&&dist[temp.end]>dist[temp.start]+temp.w)
				{
					dist[temp.end]=dist[temp.start]+temp.w;
				}
			}
		}
		for(Node temp: arr)
		{
			if(dist[temp.start]!=Integer.MAX_VALUE&&dist[temp.end]>dist[temp.start]+temp.w)//다시 또 갱신되면
			{
				System.out.println("-1");
				System.exit(0);
			}
		}
		for(int i=2;i<=N;i++)
		{
			if(dist[i]==Integer.MAX_VALUE)
			{
				System.out.println("-1");
			}
			else
			{
				System.out.println(dist[i]);
			}
		}
	}
}
