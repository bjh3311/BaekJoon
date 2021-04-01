import java.util.*;
import java.io.*;
class Node
{
	int V;
	int color;
	public Node(int V,int color)
	{
		this.V=V;
		this.color=color;
	}
}
public class 백준_1707번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int K=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<K;i++)
		{
			String[] s=br.readLine().split(" ");
			int V=Integer.parseInt(s[0]);
			int E=Integer.parseInt(s[1]);
			ArrayList<Integer>[] arr=new ArrayList[V+1];
			boolean[] visited=new boolean[V+1];
			int[] node_color=new int[V+1];
			for(int j=1;j<=V;j++)
			{
				arr[j]=new ArrayList<Integer>();
			}
			for(int j=0;j<E;j++)
			{
				s=br.readLine().split(" ");
				int a=Integer.parseInt(s[0]);
				int b=Integer.parseInt(s[1]);
				arr[a].add(b);
				arr[b].add(a);//양방향 그래프다
			}
			Queue<Node> q=new LinkedList<Node>();
			int ans=0;
			loops: for(int k=1;k<=V;k++)
			{
				if(!visited[k])
				{
					q.add(new Node(k,1));//1로 시작 색깔은 1
					node_color[k]=1;
					while(!q.isEmpty())
					{
						Node temp=q.poll();
						int x=temp.V;
						int color=temp.color;
						for(int j=0;j<arr[x].size();j++)
						{
							if(!visited[arr[x].get(j)])//방문된적이 없다면
							{
								visited[arr[x].get(j)]=true;
								q.add(new Node(arr[x].get(j),color*-1));//색깔을 반대색깔로 칠한다.
								node_color[arr[x].get(j)]=color*-1;
							}
							else//방문된적이 있다면
							{
								if(node_color[arr[x].get(j)]==color)//나랑 연결되어있는데 색깔이 같다면?
								{
									ans=1;
									break loops;
								}
							}
						}
					}
				}
				
			}
			
			if(ans==1)
			{
				sb.append("NO\n");
			}
			else
			{
				sb.append("YES\n");
			}			
		}
		System.out.print(sb.toString());
	}
}
