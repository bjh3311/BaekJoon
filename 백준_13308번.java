import java.util.*;
import java.io.*;
class Edge
{
	int v;//정점 번호
	int w;//거리
	Edge(int v,int w)
	{
		this.v=v;
		this.w=w;
	}
}
class Node implements Comparable<Node>
{
	int v;//도시 번호
	long total;//사용한 돈
	int minoil;//가지고 있는 기름
	Node(int v,long total,int minoil)
	{
		this.v=v;
		this.total=total;
		this.minoil=minoil;
	}
	public int compareTo(Node o)//가격별로 오름차순 정리
	{
		return Long.compare(total,o.total);
	}
	
}
public class 백준_13308번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		s=br.readLine().split(" ");
		int[] price=new int[N+1];//각 도시별 기름 가격
		for(int i=0;i<N;i++)//가격정보 입력
		{
			price[i+1]=Integer.parseInt(s[i]);
		}
		long[][] dp=new long[N+1][2501];// 첫번째는 도시, 두번째는 둘러본 도시중 가장 기름값이 적은 노드숫자
		for(int i=1;i<=N;i++)
		{
			Arrays.fill(dp[i],Long.MAX_VALUE);
		}
		ArrayList<Edge>[] arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Edge>();
		}
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int dis=Integer.parseInt(s[2]);
			arr[a].add(new Edge(b,dis));
			arr[b].add(new Edge(a,dis));
		}
		PriorityQueue<Node> pq=new PriorityQueue<Node>();
		pq.add(new Node(1,0,price[1]));
		dp[1][price[1]]=0;
		while(!pq.isEmpty())
		{
			Node now=pq.poll();
			if(now.v==N)
			{
				System.out.println(now.total);
				return ;
			}
			for(Edge next : arr[now.v])
			{
				if(dp[next.v][now.minoil]>now.total+(next.w*now.minoil))
				{
					dp[next.v][now.minoil]=now.total+(next.w*now.minoil);
					pq.offer(new Node(next.v,now.total+(next.w*now.minoil)
							,Math.min(now.minoil, price[next.v])));
				}
			}
		}
	}
}
