import java.util.*;
import java.io.*;
public class DAY7_LCA2 {

	public static boolean[] visited;
	public static ArrayList<Integer>[] arr;
	public static int[] DEPTH;
	public static int LogN=17;//2�� ���������� ��������� ����. ���������� 10���̴� 17�·� ��������
	public static int[][] parent;//�θ� ǥ���Ѵ�
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String[] s;
		arr=new ArrayList[N+1];
		parent=new int[LogN+1][N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<N-1;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			arr[a].add(b);
			arr[b].add(a);
		}
		visited=new boolean[N+1];
		DEPTH=new int[N+1];
		BFS(1,0);//��Ʈ��� 1�� ���̴� 0. �� ��庰�� ���̸� �����ش�
		for(int i=1;i<=LogN;i++)//2�� n�� �θ� �����ش�
		{
			for(int j=1;j<=N;j++)
			{
				parent[i][j]=parent[i-1][parent[i-1][j]];
			}
		}
		int M=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			if(DEPTH[a]>DEPTH[b])
			{
				sb.append(getLCA(a,b)+"\n");//a�� ���̰� b���� ��ٰ� �����ϰ� �����Ѵ�
			}
			else//���� b�� ���̰� a���� ��ٸ�
			{
				sb.append(getLCA(b,a)+"\n");//a�� ���̰� b���� ��ٰ� �����ϰ� �����Ѵ�
			}
			
		}
		System.out.print(sb.toString());
		
		
	}
	public static void BFS(int start,int depth)//������ ���̸� �����ش�
	{
		DEPTH[start]=depth;
		visited[start]=true;
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(1);//1���� �ִ´�
		while(!q.isEmpty())
		{
			int now=q.poll();
			for(int next:arr[now])
			{
				if(!visited[next])//�湮�������ٸ�
				{
					visited[next]=true;
					DEPTH[next]=DEPTH[now]+1;
					parent[0][next]=now;//�θ� �����ش�
					q.add(next);
				}
			}
		}
	}
	public static int log(int value)
	{
		int k=0;
		while(Math.pow(2, k)<=value)
		{
			k++;
		}
		return k-1;
	}
	public static int getLCA(int a,int b)
	{
		//a����� ���̸� b����� ���̱��� �÷��� �� ����� ���̸� �����ش�
		while(DEPTH[a]!=DEPTH[b])//���̸� �����
		{
			int temp=DEPTH[a]-DEPTH[b];
			a=parent[log(temp)][a];
		}
		if(a==b)
		{
			return a;
		}
		//���������� �ƴ� �� ���� �θ� ���� �ö󰣴�
		//���������δ� LCA �ٷ� �ر������ �ö󰣴�
		for(int i=LogN;i>=0;i--)
		{
			if(parent[i][a]!=parent[i][b])
			{
				a=parent[i][a];
				b=parent[i][b];
			}
		}
		return parent[0][a];
	}
}
