import java.util.*;
import java.io.*;
class Node{
	int child;
	int weight;
	public Node(int child,int weight)
	{
		this.child=child;
		this.weight=weight;
	}
}
public class 백준_1967번 {

	public static boolean[] visited;
	public static int[] root_dis;//root노드에서 가장 먼 거리 찾기
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
	public static ArrayList<Node>[] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		arr=new ArrayList[n+1];
		visited=new boolean[n+1];
		root_dis=new int[n+1];
		max_dis=new int[n+1];
		for(int i=1;i<=n;i++)
		{
			arr[i]=new ArrayList<Node>();
		}
		String[] s;
		for(int i=0;i<n-1;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);
			arr[a].add(new Node(b,c));
			arr[b].add(new Node(a,c));//양방향 그래프
		}
		DFS(1);//루트노드부터 DFS시작
		int max=0;
		int index=1;
		for(int i=1;i<=n;i++)
		{
			if(max<root_dis[i])
			{
				max=root_dis[i];
				index=i;
			}
		}
		Arrays.fill(visited, false);
		DFS_2(index);
		max=0;
		for(int i=1;i<=n;i++)
		{
			max=Math.max(max, max_dis[i]);
		}
		System.out.println(max);	
	}

}
