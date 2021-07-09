import java.util.*;
import java.io.*;
class Node
{
	int x;
	int visit;
	public Node(int x,int visit)
	{
		this.x=x;
		this.visit=visit;
	}
}
public class 백준_5214번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int K=Integer.parseInt(s[1]);
		int M=Integer.parseInt(s[2]);
		boolean[] visited=new boolean[N+M+1];
		ArrayList<Integer>[] arr=new ArrayList[N+M+1];
		Queue<Node> q=new LinkedList<Node>();
		for(int i=1;i<=N+M;i++)
		{
			arr[i]=new ArrayList<Integer>();
		}
		for(int i=1;i<=M;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<K;j++)
			{
				arr[N+i].add(Integer.parseInt(s[j]));
				arr[Integer.parseInt(s[j])].add(N+i);
			}
			
		}
		q.add(new Node(1,1));//1번에서 시작하며 1개 방문
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			if(temp.x==N)
			{
				System.out.println(temp.visit);
				System.exit(0);
			}
			if(visited[temp.x])
			{
				continue;
			}
			visited[temp.x]=true;
			for(int i=0;i<arr[temp.x].size();i++)
			{
				int next=arr[temp.x].get(i);
				if(!visited[next])
				{
					if(next>N)
					{
						q.add(new Node(next,temp.visit));
					}
					else
					{
						q.add(new Node(next,temp.visit+1));
					}
					
				}
			}
		}
		System.out.println("-1");
	}
}
