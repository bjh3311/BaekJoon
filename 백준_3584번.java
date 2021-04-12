import java.util.*;
import java.io.*;
public class 백준_3584번 {

	public static ArrayList<Integer>[] arr;
	public static boolean[] root;
	public static StringBuilder sb=new StringBuilder();
	public static boolean[] visited;
	public static int[] parent;//1번부터 N번까지의 부모노드 저장
	public static int[] depth;//1번부터 N번까지의 깊이 저장
	public static void DFS(int n)
	{
		visited[n]=true;
		for(int i=0;i<arr[n].size();i++)
		{
			if(!visited[arr[n].get(i)])
			{
				depth[arr[n].get(i)]=depth[n]+1;//자식노드의 깊이는 부모노드의 깊이 +1
				DFS(arr[n].get(i));
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
	
		while(T>0)
		{
			T--;
			int N=Integer.parseInt(br.readLine());
			arr=new ArrayList[N+1];
			root=new boolean[N+1];
			depth=new int[N+1];
			visited=new boolean[N+1];
			for(int i=1;i<=N;i++)
			{
				arr[i]=new ArrayList<Integer>();
			}
			String[] s;
			parent=new int[N+1];
			for(int i=0;i<N-1;i++)
			{
				s=br.readLine().split(" ");
				int a=Integer.parseInt(s[0]);
				int b=Integer.parseInt(s[1]);
				arr[a].add(b);
				arr[b].add(a);
				root[b]=true;//b는 루트노드가 아니다
				parent[b]=a;//각 노드의 부모노드 저장
			}
			s=br.readLine().split(" ");
			int v1=Integer.parseInt(s[0]);
			int v2=Integer.parseInt(s[1]);
			for(int i=1;i<=N;i++)
			{
				if(!root[i])
				{
					depth[i]=0;//루트노드의 깊이는 0
					DFS(i);//루트노드에서 시작해서 각 노드의 깊이를 저장해주자
				}
			}
			while(true)
			{
				if(v1==parent[v2])
				{
					sb.append(v1+"\n");
					break;
				}
				if(v2==parent[v1])
				{
					sb.append(v2+"\n");
					break;
				}
				if(depth[v1]==depth[v2])
				{
					if(parent[v1]==parent[v2])
					{
						sb.append(parent[v1]+"\n");
						break;
					}
					else
					{
						v1=parent[v1];
						v2=parent[v2];
					}
				}
				else
				{
					if(depth[v1]>depth[v2])
					{
						v1=parent[v1];
					}
					else
					{
						v2=parent[v2];
					}
				}
			}
			
		}
		System.out.print(sb.toString());
	}
}
