import java.util.*;
public class น้มุ_11725น๘ {

	public static ArrayList<Integer>[] arr;
	public static boolean[] visited;
	public static int[] parent;
	public static void DFS(int n)
	{
		visited[n]=true;
		for(int i=0;i<arr[n].size();i++)
		{
			if(!visited[arr[n].get(i)])
			{
				parent[arr[n].get(i)]=n;
				DFS(arr[n].get(i));
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Integer>();
		}
		parent=new int[N+1];
		visited=new boolean[N+1];
		for(int i=0;i<N-1;i++)
		{
			int a=sc.nextInt();
			int b=sc.nextInt();
			arr[a].add(b);
			arr[b].add(a);	
		}
		DFS(1);
		for(int i=2;i<=N;i++)
		{
			System.out.println(parent[i]);
		}
		
	}
}
