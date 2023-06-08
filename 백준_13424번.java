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
public class 백준_13424번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T>0)
		{
			String[] s=br.readLine().split(" ");
			int N=Integer.parseInt(s[0]);
			int M=Integer.parseInt(s[1]);
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
				int w=Integer.parseInt(s[2]);
				arr[a].add(new Node(b,w));
				arr[b].add(new Node(a,w));
			}
			int[][] map=new int[N+1][N+1];//각 지점에서 지점까지 최단거리
			PriorityQueue<Node> pq=new PriorityQueue<Node>();
			int K=Integer.parseInt(br.readLine());//친구 수
			s=br.readLine().split(" ");
			for(int i=0;i<K;i++)
			{
				int now=Integer.parseInt(s[i]);
				pq.add(new Node(now,0));
				Arrays.fill(map[now], Integer.MAX_VALUE);
				map[now][now]=0;
				while(!pq.isEmpty())//다익스트라
				{
					Node temp=pq.poll();
					for(Node next : arr[temp.v])
					{
						if(map[now][next.v]>temp.w+next.w)
						{
							map[now][next.v]=temp.w+next.w;
							pq.add(new Node(next.v,map[now][next.v]));
						}
					}
				}
			}
			int answer=Integer.MAX_VALUE;
			int result=0;
			for(int i=N;i>=1;i--)
			{
				int temp=0;
				for(int j=0;j<K;j++)
				{
					temp=temp+map[Integer.parseInt(s[j])][i];
				}
				if(temp<=answer)
				{
					answer=temp;
					result=i;
				}
			}
			System.out.println(result);
			T--;
		}

	}

}
