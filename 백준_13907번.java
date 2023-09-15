import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int v;
	int w;
	int c;
	Node(int v,int w,int c)
	{
		this.v=v;
		this.w=w;
		this.c=c;
	}
	public int compareTo(Node o)
	{
		return w-o.w;
	}
}
public class 백준_13907번 {

	public static int[][] dp;
	public static int N;
	public static int S;
	public static int D;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		N=Integer.parseInt(s[0]);//도시의 수
		int M=Integer.parseInt(s[1]);//도로의 개수
		int K=Integer.parseInt(s[2]);//세금 인상 횟수
		s=br.readLine().split(" ");
		S=Integer.parseInt(s[0]);//시작지점
		D=Integer.parseInt(s[1]);//도착 지점
		ArrayList<Node>[] arr=new ArrayList[N+1];
		dp=new int[N+1][N];//첫번째 인덱스는 도시번호, 두 번째 인덱스는 거쳐간 도시의 개수
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Node>();
		}
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int w=Integer.parseInt(s[2]);
			arr[a].add(new Node(b,w,0));
            arr[b].add(new Node(a,w,0));
		}
		for(int i=1;i<=N;i++)
		{
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		Arrays.fill(dp[S], Integer.MAX_VALUE);
		PriorityQueue<Node> pq=new PriorityQueue<Node>();
		pq.add(new Node(S,0,0));
		while(!pq.isEmpty())//다익스트라
		{
			Node temp=pq.poll();
			if(temp.c+1==N)
			{
				continue;
			}
			if(temp.w>dp[temp.v][temp.c])
			{
				continue;
			}
			fr : for(Node next : arr[temp.v])
			{
				for(int i=1;i<=temp.c;i++)//시간을 더 줄이기 위한 코드
				{
					if(dp[next.v][i]<temp.w+next.w)
					{
						continue fr;
					}//만약 다음에가고자 하는 도시에, 지금보다 더 적게 도시를 방문해서 비용이 더 적은 값이 있다면
					//더 진행하는 의미가 없다
				}
				if(dp[next.v][temp.c+1]>temp.w+next.w)
				{
					dp[next.v][temp.c+1]=temp.w+next.w;
					pq.add(new Node(next.v,temp.w+next.w,temp.c+1));
				}
			}
		}
		int result=Integer.MAX_VALUE;
		for(int i=1;i<N;i++)
		{
			result=Math.min(result, dp[D][i]);
		}
		System.out.println(result);
		for(int i=0;i<K;i++)
		{
			int p=Integer.parseInt(br.readLine());
			System.out.println(tax(p));
		}
	}
	public static int tax(int p)//tax는 거쳐온 노드의개수에 비례해서 붙는다
	{
		int result=Integer.MAX_VALUE;
		for(int i=1;i<N;i++)
		{
			if(dp[D][i]==Integer.MAX_VALUE)
			{
				continue;
			}//만약 i개의 노드만큼 거쳐지지 않고 목적지에 도달했을 수도 있으므로
			dp[D][i]+=i*p;
			result=Math.min(result, dp[D][i]);
		}
		return result;
	}
}