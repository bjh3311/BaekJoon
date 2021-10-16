import java.util.*;
import java.io.*;
class Cost implements Comparable<Cost>
{
	int num;//친구 번호
	int value;//가치
	public Cost(int num,int value)
	{
		this.num=num;
		this.value=value;
	}
	public int compareTo(Cost o)
	{
		return value-o.value;
	}
}
public class 백준_16562번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int k=Integer.parseInt(s[2]);
		parent=new int[N+1];
		for(int i=1;i<=N;i++)
		{
			parent[i]=i;
		}
		ArrayList<Cost> arr=new ArrayList<Cost>();
		s=br.readLine().split(" ");
		for(int i=1;i<=N;i++)
		{
			arr.add(new Cost(i,Integer.parseInt(s[i-1])));
		}
		Collections.sort(arr);//가격순으로 오름차순 정렬
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int v=Integer.parseInt(s[0]);
			int w=Integer.parseInt(s[1]);
			Union(v,w);
		}
		for(int i=1;i<=N;i++)
		{
			int a=Find(i);
		}
		visited=new boolean[N+1];
		int count=0;
		Queue<Cost> q=new LinkedList<Cost>();
		for(Cost temp:arr)
		{
			q.add(temp);
		}
		while(!q.isEmpty())
		{
			Cost temp=q.poll();
			if(visited[temp.num])
			{
				continue;
			}
			count+=temp.value;
			if(count>k)
			{
				System.out.println("Oh no");
				System.exit(0);
			}
			visited[temp.num]=true;
			int index=Find(temp.num);
			for(int i=1;i<=N;i++)//부모가 같은 i는 다 친구이므로 방문처리 해준다.
			{
				if(index==parent[i])
				{
					
					visited[i]=true;
				}
			}
		}	
		System.out.println(count);
	}
	public static boolean[] visited;
	public static int[] parent;
	public static int Find(int x)
	{
		if(parent[x]==x)
		{
			return x;
		}
		return parent[x]=Find(parent[x]);
	}
	public static void Union(int x,int y)
	{
		x=Find(x);
		y=Find(y);
		if(x!=y)
		{
			if(x<y)
			{
				parent[y]=x;
			}
			else
			{
				parent[x]=y;
			}
		}
	}
}
