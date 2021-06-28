import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int next;
	int weight;
	int status;
	public Node(int next,int weight)
	{
		this.next=next;
		this.weight=weight;
	}
	public Node(int next,int weight,int status)
	{
		this.next=next;
		this.weight=weight;
		this.status=status;
	}
	public int compareTo(Node o)//가중치가 가장 낮은게 우선순위를 가진다
	{
		return weight-o.weight;
	}
}
public class 백준_16118번 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);//노드
		int M=Integer.parseInt(s[1]);//간선
		int result=0;//결과값
		int[][] wolf_dis=new int[N+1][2];//늑대가 걸리는 시간,첫번째 인덱스는 이 지점까지 느리게,두번째는 빠르게
		int[] fox_dis=new int[N+1];
		ArrayList<Node>[] arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Node>();
			fox_dis[i]=Integer.MAX_VALUE;
			Arrays.fill(wolf_dis[i], Integer.MAX_VALUE);
		}
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int d=2*Integer.parseInt(s[2]);//거리의 값을 다 2곱해줘서 소수점을 없애자
			arr[a].add(new Node(b,d));
			arr[b].add(new Node(a,d));//양 방향이기 때문에
		}
		PriorityQueue<Node> wolf_q=new PriorityQueue<Node>();
		wolf_dis[1][0]=0;
		wolf_q.add(new Node(1,0,1));
		while(!wolf_q.isEmpty())//늑대의 다익스트라
		{
			Node temp=wolf_q.poll();
			int v=temp.next;
			int status=temp.status;
			if(wolf_dis[v][status-1]<temp.weight)
			{
				continue;
			}
			for(Node ne:arr[v])
			{
			   int next=ne.next;
			   int weight=ne.weight;
			   if(status==1)//빠르게 움직인다
			   {
				   if(wolf_dis[next][1]>wolf_dis[v][0]+weight/2)
				   {
					   wolf_dis[next][1]=wolf_dis[v][0]+weight/2;
					   wolf_q.add(new Node(next,wolf_dis[next][1],2));
				   }
			   }
			   else if(status==2)//느리게 움직인다
			   {
				   if(wolf_dis[next][0]>wolf_dis[v][1]+weight*2)
				   {
					   wolf_dis[next][0]=wolf_dis[v][1]+weight*2;
					   wolf_q.add(new Node(next,wolf_dis[next][0],1));
				   }
			   }
			}
		
		}
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		fox_dis[1]=0;
		q.add(new Node(1,0));
		while(!q.isEmpty())//정상적인 다익스트라
		{
			Node temp=q.poll();
			int v=temp.next;
			if(fox_dis[v]<temp.weight)
			{
				continue;
			}
			for(Node ne: arr[v])
			{
				int next=ne.next;
				int weight=ne.weight;
				if(fox_dis[next]>fox_dis[v]+weight)
				{
					fox_dis[next]=fox_dis[v]+weight;
					q.add(new Node(next,fox_dis[next]));
				}
			}
		}
		for(int i=1;i<=N;i++)//여우거리와 늑대거리
		{
			int min=Math.min(wolf_dis[i][0], wolf_dis[i][1]);
			if(min>fox_dis[i])
			{
				result++;
			}
		}
		System.out.println(result);
	}
}
