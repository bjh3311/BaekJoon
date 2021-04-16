import java.util.*;
class Node{
	int child;
	int weight;
	public Node(int child,int weight)
	{
		this.child=child;
		this.weight=weight;
	}
}
public class น้มุ_1167น๘ {

	public static ArrayList<Node>[] arr;
	public static boolean[] visited;
	public static int[] root_dis;
	public static int[] max_dis;
	public static void DFS(int n)
	{
		visited[n]=true;
		for(int i=0;i<arr[n].size();i++)
		{
			int next=arr[n].get(i).child;
			if(!visited[next])
			{
				root_dis[next]=root_dis[n]+arr[n].get(i).weight;
				DFS(next);
			}
		}
	}
	public static void DFS_2(int n)
	{
		visited[n]=true;
		for(int i=0;i<arr[n].size();i++)
		{
			int next=arr[n].get(i).child;
			if(!visited[next])
			{
				max_dis[next]=max_dis[n]+arr[n].get(i).weight;
				DFS_2(next);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int V=sc.nextInt();
		arr=new ArrayList[V+1];
		visited=new boolean[V+1];
		root_dis=new int[V+1];
		max_dis=new int[V+1];
		for(int i=1;i<=V;i++)
		{
			arr[i]=new ArrayList<Node>();
		}
		for(int i=0;i<V;i++)
		{
			int a=sc.nextInt();
			while(true)
			{
				int b=sc.nextInt();
				if (b==-1)
				{
					break;
				}
				int c=sc.nextInt();
				arr[a].add(new Node(b,c));				
			}
		}
		int max=0;
		int index=1;
		DFS(1);
		for(int i=1;i<=V;i++)
		{
			if(max<root_dis[i])
			{
				max=root_dis[i];
				index=i;
			}
		}
		Arrays.fill(visited, false);
		DFS_2(index);
		for(int i=1;i<=V;i++)
		{
			max=Math.max(max_dis[i], max);
		}
		System.out.println(max);
	}
}
