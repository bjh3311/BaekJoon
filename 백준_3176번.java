import java.util.*;
import java.io.*;

class Node
{
	int V;
	int W;
	public Node(int V,int W)
	{
		this.V=V;
		this.W=W;
	}
}
public class ����_3176�� {

	public static int[][] parent;//2�� ��� �θ� ������ ����
	public static int[][] Max;//2�� ��� �θ������ ���� �� ����
	public static int[][] Min;//2�� ��� �θ������ ���� ª�� ����
	public static int[] Depth;//���� ����
	public static boolean[] visited;
	public static ArrayList<Node>[] tree;
	public static int LogN=17;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Depth=new int[N+1];
		visited=new boolean[N+1];
		parent=new int[18][N+1];
		Max=new int[18][N+1];
		Min=new int[18][N+1];
		String[] s;
		tree=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			tree[i]=new ArrayList<Node>();
		}
		for(int i=0;i<N-1;i++)
		{
			s=br.readLine().split(" ");
			int A=Integer.parseInt(s[0]);
			int B=Integer.parseInt(s[1]);
			int W=Integer.parseInt(s[2]);	
			tree[A].add(new Node(B,W));
			tree[B].add(new Node(A,W));
		}
		BFS();//Ʈ�� ����
		for(int i=1;i<=LogN;i++)//�� ������ 2�� ��ºθ�� ��������, 2�� ��ºθ������ ���� �� ���� ���� ª�� ���� ���ϱ�
		{
			for(int j=1;j<=N;j++)
			{
				parent[i][j]=parent[i-1][parent[i-1][j]];
				Max[i][j]=Math.max(Max[i-1][j], Max[i-1][parent[i-1][j]]);
				Min[i][j]=Math.min(Min[i-1][j], Min[i-1][parent[i-1][j]]);
			}
		}
		int K=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<K;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			if(Depth[a]>Depth[b])
			{
				LCA(b,a);//ù ��° �μ��� ���̰� �� ����(�� �۰�) ����
			}
			else
			{
				LCA(a,b);
			}
			
		}
	}
	public static void BFS()//���� �� �θ� ����, 1���� ��Ʈ ���� ���� ���̴�
	{
		Depth[1]=0;//���̴� 0����
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(1);
		while(!q.isEmpty())
		{
			int now=q.poll();
			if(visited[now])//�湮������ �ִٸ�
			{
				continue;
			}
			visited[now]=true;//�湮 ó��
			for(Node nextNode:tree[now])
			{
				int next=nextNode.V;
				if(visited[next])//�θ�� �ٽ� �����ϴ°� �����ش�
				{
					continue;
				}
				Depth[next]=Depth[now]+1;
				parent[0][next]=now;
				Min[0][next]=nextNode.W;
				Max[0][next]=nextNode.W;
				q.add(next);
			}
		}
	}
	public static int log(int N)//LCA�Լ����� ��ĭ �ö󰼾� �Ǵ��� ���
	{
		int temp=0;
		while(Math.pow(2, temp)<=N)
		{
			temp++;
		}
		return temp-1;
	}
	public static void LCA(int a,int b)//b�� ���̰� �� ��� ����
	{
		int max_result=Integer.MIN_VALUE;
		int min_result=Integer.MAX_VALUE;
		while(Depth[a]!=Depth[b])//���� ���̰� �ٸ��ٸ� �����ش�, �̰͵� 2�� N������ �ö�����
		{
			int temp=Depth[b]-Depth[a];
			max_result=Math.max(max_result, Max[log(temp)][b]);
			min_result=Math.min(min_result, Min[log(temp)][b]);
			b=parent[log(temp)][b];
		}
		if(a==b)//���̸� ������µ� ���� �Ȱ��� �����, �׳� �̴�� ��� ����ϰ� ������.
		{
			System.out.println(min_result+" "+max_result);
			return ;
		}
		for(int i=17;i>=0;i--)
		{
			if(parent[i][a]!=parent[i][b])
			{
				max_result=Three_Max(Max[i][a], Max[i][b],max_result);
				min_result=Three_Min(Min[i][a],Min[i][b],min_result);
				a=parent[i][a];
				b=parent[i][b];
			}
		}
		max_result=Three_Max(Max[0][a], Max[0][b],max_result);
		min_result=Three_Min(Min[0][a],Min[0][b],min_result);//��� ������ ������ 
		System.out.println(min_result+" "+max_result);
	}
	public static int Three_Max(int a,int b,int c)//�� ������ ���� ū ���� ��ȯ
	{
		if(a>=b&&a>=c)
		{
			return a;
		}
		else if(b>=a&&b>=c)
		{
			return b;
		}
		else
		{
			return c;
		}
	}
	public static int Three_Min(int a,int b,int c)//�� ������ ���� ���� ���� ��ȯ
	{
		if(a<=b&&a<=c)
		{
			return a;
		}
		else if(b<=a&&b<=c)
		{
			return b;
		}
		else 
		{
			return c;
		}
	}
}
