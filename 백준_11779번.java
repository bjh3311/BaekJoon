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
	@Override
	public int compareTo(Node o)
	{
		return weight-o.weight;
	}
}//�켱����ť�� ����ġ�� ���� ������ ū �켱������ ������ ����
public class ����_11779�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		int[] before=new int[n+1];//�������� ���� �迭
		boolean[] visited=new boolean[n+1];//�湮�ߴ��� �˾ƺ��� �迭
		int[] dis=new int[n+1];//�Ÿ� �迭
		Arrays.fill(dis, Integer.MAX_VALUE);//�Ÿ��� �ϴ� ���� ū������ �ʱ�ȭ ���ѵд�.
		ArrayList<Node>[] map=new ArrayList[n+1];
		for(int i=1;i<=n;i++)
		{
			map[i]=new ArrayList<Node>();
		}
		String[] s;
		for(int i=0;i<m;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);
			map[a].add(new Node(b,c));
		}
		s=br.readLine().split(" ");
		int start=Integer.parseInt(s[0]);
		int end=Integer.parseInt(s[1]);
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		q.add(new Node(start,0));
		dis[start]=0;
		int count=1;//����� ���� �����̴�
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			int v=temp.vertex;
			if(!visited[v])
			{
				for(int i=0;i<map[v].size();i++)
				{
					int next=map[v].get(i).vertex;
					if(!visited[next]&&dis[next]>dis[v]+map[v].get(i).weight)
					{
						dis[next]=dis[v]+map[v].get(i).weight;
						q.add(new Node(next,dis[next]));
						before[next]=v;
					}
						
				}
			}
			visited[v]=true;//�������� �湮 ó��
			
		}
		System.out.println(dis[end]);
		Stack<Integer> result=new Stack<Integer>();
		int index=end;//end���� �����ؼ� ������ ����
		while(true)
		{
			result.push(index);
			if(index==start)//�������� ����������
			{
				break;
			}
			index=before[index];//������ �ǽ�
			count++;//�湮�� ���� ����
		}
		System.out.println(count);//����� ���
		while(!result.isEmpty())
		{
			System.out.print(result.pop()+" ");
		}
	}
}
