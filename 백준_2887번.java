import java.util.*;
import java.io.*;
class Node 
{
	int num;//��� ��ȣ
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
class Edge implements Comparable<Edge>//�� ��尣�� ����
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
	public int compareTo(Edge o)//���� ������������ ����
	{
		return weight-o.weight;
	}
}

public class ����_2887�� {

	public static int[] parent;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int result = 0;
		parent=new int[N];
		for(int i=0;i<N;i++)//ũ�罺Į�� ���� �ʱ� ����
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
		Arrays.sort(arr,(n1,n2)-> n1.x-n2.x);//x��ǥ �������� ����
		for(int i=0;i<N-1;i++)//�켱���� ť�� �ִ´�
		{
			q.add(new Edge(arr[i].num,arr[i+1].num,Math.abs(arr[i].x-arr[i+1].x)));
		}
		Arrays.sort(arr,(n1,n2)-> n1.y-n2.y);//y��ǥ �������� ����
		for(int i=0;i<N-1;i++)//�켱���� ť�� �ִ´�
		{
			q.add(new Edge(arr[i].num,arr[i+1].num,Math.abs(arr[i].y-arr[i+1].y)));
		}
		Arrays.sort(arr,(n1,n2)-> n1.z-n2.z);//z��ǥ �������� ����
		for(int i=0;i<N-1;i++)//�켱���� ť�� �ִ´�
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
	public static void Union(int v1,int v2)//v1�� v2�� �պ����ش�, �� ���� ������ ����ȣ�� �պ����ش�, ���������� �� 0��
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
	public static int Find(int num)//num�� �θ� ã���ش�.
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
