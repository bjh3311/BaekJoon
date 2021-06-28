import java.util.*;
import java.io.*;
class Node implements Comparable<Node>
{
	int next;
	int weight;
	int status;
	public Node(int next,int weight)
	{
		this.next=next;
		this.weight=weight;
	}
	public Node(int next,int weight,int status)
	{
		this.next=next;
		this.weight=weight;
		this.status=status;
	}
	public int compareTo(Node o)//����ġ�� ���� ������ �켱������ ������
	{
		return weight-o.weight;
	}
}
public class ����_16118�� {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);//���
		int M=Integer.parseInt(s[1]);//����
		int result=0;//�����
		int[][] wolf_dis=new int[N+1][2];//���밡 �ɸ��� �ð�,ù��° �ε����� �� �������� ������,�ι�°�� ������
		int[] fox_dis=new int[N+1];
		ArrayList<Node>[] arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Node>();
			fox_dis[i]=Integer.MAX_VALUE;
			Arrays.fill(wolf_dis[i], Integer.MAX_VALUE);
		}
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int d=2*Integer.parseInt(s[2]);//�Ÿ��� ���� �� 2�����༭ �Ҽ����� ������
			arr[a].add(new Node(b,d));
			arr[b].add(new Node(a,d));//�� �����̱� ������
		}
		PriorityQueue<Node> wolf_q=new PriorityQueue<Node>();
		wolf_dis[1][0]=0;
		wolf_q.add(new Node(1,0,1));
		while(!wolf_q.isEmpty())//������ ���ͽ�Ʈ��
		{
			Node temp=wolf_q.poll();
			int v=temp.next;
			int status=temp.status;
			if(wolf_dis[v][status-1]<temp.weight)
			{
				continue;
			}
			for(Node ne:arr[v])
			{
			   int next=ne.next;
			   int weight=ne.weight;
			   if(status==1)//������ �����δ�
			   {
				   if(wolf_dis[next][1]>wolf_dis[v][0]+weight/2)
				   {
					   wolf_dis[next][1]=wolf_dis[v][0]+weight/2;
					   wolf_q.add(new Node(next,wolf_dis[next][1],2));
				   }
			   }
			   else if(status==2)//������ �����δ�
			   {
				   if(wolf_dis[next][0]>wolf_dis[v][1]+weight*2)
				   {
					   wolf_dis[next][0]=wolf_dis[v][1]+weight*2;
					   wolf_q.add(new Node(next,wolf_dis[next][0],1));
				   }
			   }
			}
		
		}
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		fox_dis[1]=0;
		q.add(new Node(1,0));
		while(!q.isEmpty())//�������� ���ͽ�Ʈ��
		{
			Node temp=q.poll();
			int v=temp.next;
			if(fox_dis[v]<temp.weight)
			{
				continue;
			}
			for(Node ne: arr[v])
			{
				int next=ne.next;
				int weight=ne.weight;
				if(fox_dis[next]>fox_dis[v]+weight)
				{
					fox_dis[next]=fox_dis[v]+weight;
					q.add(new Node(next,fox_dis[next]));
				}
			}
		}
		for(int i=1;i<=N;i++)//����Ÿ��� ����Ÿ�
		{
			int min=Math.min(wolf_dis[i][0], wolf_dis[i][1]);
			if(min>fox_dis[i])
			{
				result++;
			}
		}
		System.out.println(result);
	}
}
