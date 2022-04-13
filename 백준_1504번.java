import java.util.*;
import java.io.*;

class Node implements Comparable<Node>
{
	int vertex;
	int weight;
	Node(int vertex,int weight)
	{
		this.vertex=vertex;
		this.weight=weight;
	}
	@Override
	public int compareTo(Node o)
	{
		return weight-o.weight;
	}//�켱���� ť�� ������ ������ ª���� ���� ū �켱������ ������ ����
}
public class ����_1504�� {
	public static int INF=200000000;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
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
			int c=Integer.parseInt(s[2]);
			arr[a].add(new Node(b,c));
			arr[b].add(new Node(a,c));//����� �׷����̱� ������
		}
		s=br.readLine().split(" ");
		int des1=Integer.parseInt(s[0]);//������ �Ǵ� �� ������ ù��°
		int des2=Integer.parseInt(s[1]);//������ �Ǵ� �� ������ �ι�°
		boolean[] visited=new boolean[N+1];
		int[] dis=new int[N+1];
		Arrays.fill(dis, INF);
		Arrays.fill(visited, false);
		dis[1]=0;
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		q.add(new Node(1,0));//������ 1�������� ����
		while(!q.isEmpty())//���������� ���ͽ�Ʈ�� �ǽ��Ѵ�.
		{
			Node temp=q.poll();
			int v=temp.vertex;
			if(!visited[v])
			{
				for(int i=0;i<arr[v].size();i++)
				{
					Node next=arr[v].get(i);
					if(!visited[next.vertex]&&dis[next.vertex]>dis[v]+next.weight)
					{
						dis[next.vertex]=dis[v]+next.weight;
						q.add(new Node(next.vertex,dis[next.vertex]));
					}
				}
			}
			visited[v]=true;
		}
		int route1_1=dis[des1];//�����ߵǴ� �� ������ �������������� ù��° ���������� �Ÿ�
		int route2_1=dis[des2];//�����ߵǴ� �� ������ �������������� �ι�° ���������� �Ÿ�
		Arrays.fill(visited, false);
		Arrays.fill(dis, INF);
		q.clear();
		q.add(new Node(des1,0));//�����ߵǴ� �� ������ ù��°���� ����
		dis[des1]=0;
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			int v=temp.vertex;
			if(!visited[v])
			{
				for(int i=0;i<arr[v].size();i++)
				{
					Node next=arr[v].get(i);
					if(!visited[next.vertex]&&dis[next.vertex]>dis[v]+next.weight)
					{
						dis[next.vertex]=dis[v]+next.weight;
						q.add(new Node(next.vertex,dis[next.vertex]));
					}
				}
			}
			visited[v]=true;
		}
		int between=dis[des2];//������ �Ǵ� �� ���������� �Ÿ�
		int route2_2=dis[N];//des1���� ���� ������ N������ �Ÿ�
		Arrays.fill(visited, false);
		Arrays.fill(dis, INF);
		q.clear();
		q.add(new Node(des2,0));
		dis[des2]=0;
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			int v=temp.vertex;
			if(!visited[v])
			{
				for(int i=0;i<arr[v].size();i++)
				{
					Node next=arr[v].get(i);
					if(!visited[next.vertex]&&dis[next.vertex]>dis[v]+next.weight)
					{
						dis[next.vertex]=dis[v]+next.weight;
						q.add(new Node(next.vertex,dis[next.vertex]));
					}
				}
			}
			visited[v]=true;
		}
		int route1_2=dis[N];//des2���� ���� ������ N������ �Ÿ�
		int route1=route1_1+route1_2+between;
		int route2=route2_1+route2_2+between;
		int ans=(route1>=INF&&route2>=INF)? -1 : Math.min(route1, route2);
		System.out.println(ans);
	}
}
