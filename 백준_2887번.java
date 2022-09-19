import java.util.*;
import java.io.*;
class Node 
{
	int num;//노드 번호
	int x;
	int y;
	int z;
	Node(int num,int x,int y,int z)
	{
		this.num=num;
		this.x=x;
		this.y=y;
		this.z=z;
	}
}
class Edge implements Comparable<Edge>//두 노드간의 간선
{
	int node1;
	int node2;
	int weight;
	Edge(int node1,int node2,int weight)
	{
		this.node1=node1;
		this.node2=node2;
		this.weight=weight;
	}
	public int compareTo(Edge o)//간선 오름차순으로 정렬
	{
		return weight-o.weight;
	}
}

public class 백준_2887번 {

	public static int[] parent;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int result = 0;
		parent=new int[N];
		for(int i=0;i<N;i++)//크루스칼을 위한 초기 설정
		{
			parent[i]=i;
		}
		String[] s;
		int x,y,z;
		Node[] arr=new Node[N];
		PriorityQueue<Edge> q=new PriorityQueue<Edge>();
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			x=Integer.parseInt(s[0]);
			y=Integer.parseInt(s[1]);
			z=Integer.parseInt(s[2]);
			arr[i]=new Node(i,x,y,z);
		}
		Arrays.sort(arr,(n1,n2)-> n1.x-n2.x);//x좌표 오름차순 정렬
		for(int i=0;i<N-1;i++)//우선순위 큐에 넣는다
		{
			q.add(new Edge(arr[i].num,arr[i+1].num,Math.abs(arr[i].x-arr[i+1].x)));
		}
		Arrays.sort(arr,(n1,n2)-> n1.y-n2.y);//y좌표 오름차순 정렬
		for(int i=0;i<N-1;i++)//우선순위 큐에 넣는다
		{
			q.add(new Edge(arr[i].num,arr[i+1].num,Math.abs(arr[i].y-arr[i+1].y)));
		}
		Arrays.sort(arr,(n1,n2)-> n1.z-n2.z);//z좌표 오름차순 정렬
		for(int i=0;i<N-1;i++)//우선순위 큐에 넣는다
		{
			q.add(new Edge(arr[i].num,arr[i+1].num,Math.abs(arr[i].z-arr[i+1].z)));
		}
		while(!q.isEmpty())
		{
			Edge temp=q.poll();
			if (Find(temp.node1) == Find(temp.node2)) 
			{
				continue;
			}
			result += temp.weight;
			Union(temp.node1, temp.node2);
		}
	
		System.out.println(result);
	}
	public static void Union(int v1,int v2)//v1과 v2를 합병해준다, 더 작은 숫자의 노드번호로 합병해준다, 최종적으론 다 0번
	{
		v1=Find(v1);
		v2=Find(v2);
		
		if(v1<v2)
		{
			parent[v2]=v1;
		}
		else
		{
			parent[v1]=v2;
		}
	}
	public static int Find(int num)//num의 부모를 찾아준다.
	{
		if(parent[num]==num)
		{
			return num;
		}
		else
		{
			return parent[num]=Find(parent[num]);
		}
	}
}
