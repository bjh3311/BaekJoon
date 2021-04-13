import java.util.*;
import java.io.*;
public class ����_11437�� {

	public static LinkedList<Integer>[] arr;
	public static int[] parent;//1������ N�������� �θ��� ����
	public static int[] depth;//1������ N�������� ���� ����
	public static void DFS(int cur,int d,int p)
	{
		depth[cur]=d;
		parent[cur]=p;
		for(int next:arr[cur])
		{
			if(next!=p)
			{
				DFS(next,d+1,cur);
			}
			
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			int N=sc.nextInt();
			arr=new LinkedList[N+1];
			depth=new int[N+1];
			for(int i=1;i<=N;i++)
			{
				arr[i]=new LinkedList<Integer>();
			}
			parent=new int[N+1];
			for(int i=0;i<N-1;i++)
			{
				int a=sc.nextInt();
				int b=sc.nextInt();
				arr[a].add(b);
				arr[b].add(a);
			}
			int M=sc.nextInt();
			DFS(1,0,-1);//1�������� �����ؼ� ���� ����
			for(int i=0;i<M;i++)
			{
				int v1=sc.nextInt();
				int v2=sc.nextInt();
				int depthA=depth[v1];
				int depthB=depth[v2];
				while(depthA>depthB)
				{
					depthA--;
					v1=parent[v1];
				}
				while(depthA<depthB)
				{
					depthB--;
					v2=parent[v2];
				}
				while(v1!=v2)
				{
					v1=parent[v1];
					v2=parent[v2];
				}
				System.out.println(v1);
			}
	}
}
