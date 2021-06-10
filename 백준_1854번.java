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
	public int compareTo(Node o1)
	{
		return w-o1.w;
	}
}
public class 백준_1854번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);//도시 개수
		int m=Integer.parseInt(s[1]);//도로 개수
		int k=Integer.parseInt(s[2]);//몇번째 최단경로
		ArrayList<Node>[] map=new ArrayList[n+1];
		for(int i=1;i<=n;i++)
		{
			map[i]=new ArrayList<Node>();
		}
		for(int i=0;i<m;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);
			map[a].add(new Node(b,c));
		}
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		PriorityQueue<Integer>[] dis=new PriorityQueue[n+1];
		for(int i=1;i<=n;i++)
		{
			dis[i]=new PriorityQueue<Integer>();//내림차순
		}
		q.add(new Node(1,0));
		dis[1].add(0);
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			int v=temp.v;
			for(int i=0;i<map[v].size();i++)
			{
				int next=map[v].get(i).v;
				if(dis[next].size()<k)
				{
					dis[next].add((temp.w+map[v].get(i).w)*-1);
					q.add(new Node(next,(temp.w+map[v].get(i).w)));
				}
				else if(dis[next].peek()<(temp.w+map[v].get(i).w)*-1)
				{
					dis[next].poll();
					dis[next].add((temp.w+map[v].get(i).w)*-1);
					q.add(new Node(next,temp.w+map[v].get(i).w));
				}
				
			}
		}
		for(int i=1;i<=n;i++)
		{
			if(dis[i].size()<k)
			{
				System.out.println("-1");
				continue;
			}
			for(int j=0;j<dis[i].size()-k;j++)
			{
				dis[i].poll();
			}
			System.out.println(dis[i].poll()*-1);
		}

	}

}
