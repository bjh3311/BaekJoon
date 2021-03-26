import java.util.*;
import java.io.*;
class Edge
{
	int to;
	int weight;
	public Edge(int to,int weight)
	{
		this.to=to;
		this.weight=weight;
	}
}
public class ����_1939�� {
	public static ArrayList<Edge>[] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		arr=(ArrayList<Edge>[])new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Edge>();
		}
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);
			arr[a].add(new Edge(b,c));
			arr[b].add(new Edge(a,c));//������̾
		}
		s=br.readLine().split(" ");
		int start=Integer.parseInt(s[0]);
		int end=Integer.parseInt(s[1]);
		int min=1;
		int max=1000000000;
		int C=0;
		int ans=0;
		while(min<=max)
		{
			int index=0;
			C=(min+max)/2;
			Queue<Integer> q=new LinkedList<Integer>();
			boolean[] visited=new boolean[N+1];
			q.add(start);
			visited[start]=true;
			while(!q.isEmpty())
			{
				int temp=q.poll();
				if(temp==end)//������ ���������ÿ� �߷��� �� Ű���� �ȴ�
				{
					min=C+1;
					ans=C;
					index++;
					break;
				}
				for(int i=0;i<arr[temp].size();i++)
				{
					int nx=arr[temp].get(i).to;
					int nw=arr[temp].get(i).weight;
					if(!visited[nx]&&nw>=C)
					{
						q.add(nx);
						visited[nx]=true;//�̰ɾ��ϸ� ������̾ ��� �Դٰ��� �Ѵ�.
					}
				}
			}
			if(index==0)//�������� �������ߴٸ�
			{
			   max=C-1;
			}
		}//BFS�� �ǽ�
		System.out.println(ans);//�������
	}
}
