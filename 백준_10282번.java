import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int vertex;
	int weight;
	public Node(int vertex,int weight)
	{
		this.vertex=vertex;
		this.weight=weight;
	}
	public int compareTo(Node o)
	{
		return weight-o.weight;
	}//�켱����ť�� ���� �� ������ ����ġ�� �������� ū �켱������ ������ ����
}
public class ����_10282�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T>0)
		{
			String[] s=br.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int d=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);//������
			ArrayList<Node>[] arr=new ArrayList[n+1];
			boolean[] visited=new boolean[n+1];
			int[] dis=new int[n+1];
			Arrays.fill(dis, Integer.MAX_VALUE);
			for(int i=1;i<=n;i++)
			{
				arr[i]=new ArrayList<Node>();
			}
			for(int i=0;i<d;i++)
			{
				s=br.readLine().split(" ");
				int v1=Integer.parseInt(s[0]);
				int v2=Integer.parseInt(s[1]);
				int w=Integer.parseInt(s[2]);
				arr[v2].add(new Node(v1,w));
			}
			PriorityQueue<Node> q=new PriorityQueue<Node>();
			dis[c]=0;
			q.add(new Node(c,0));
			while(!q.isEmpty())
			{
				Node temp=q.poll();
				int v=temp.vertex;
				if(!visited[v])
				{
					for(int i=0;i<arr[v].size();i++)
					{
						int next=arr[v].get(i).vertex;
						if(!visited[next]&&dis[next]>dis[v]+arr[v].get(i).weight)
						{
							dis[next]=dis[v]+arr[v].get(i).weight;
							q.add(new Node(next,dis[next]));
						}
					}
				}
				visited[temp.vertex]=true;
			}//�Ϲ����� ���ͽ�Ʈ��
			int count=0;//������ ���� ���� ��
			int max=0;//c���� �����ؼ� ���� �� �� �ִ� ������ ���� ū��
			for(int i=1;i<=n;i++)
			{
				if(dis[i]!=Integer.MAX_VALUE)//Integer.MAX_VALUE�� �ƴ϶�°��� �����Ǿ��ٴ� ���̴�
				{
					count++;
					max=Math.max(max, dis[i]);
				}
			}
			System.out.println(count+" "+max);
			T--;
		}

	}
}
