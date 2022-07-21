import java.util.*;
import java.io.*; 
class Node
{
	int num;
	int count;
	public Node(int num,int count)
	{
		this.num=num;
		this.count=count;
	}
}
public class ����_2637�� {

	public static int[] counter;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());//N���� ����ǰ ��ȣ
		counter=new int[N+1];
		int M=Integer.parseInt(br.readLine());//��ǰ�鰣�� ���� ����
		ArrayList<Node>[] arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Node>();
		}
		String[] s;
		int[] degree_x=new int[N+1];
		int[] degree_y=new int[N+1];
		int X;
		int Y;
		int K;
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			X=Integer.parseInt(s[0]);
			Y=Integer.parseInt(s[1]);
			K=Integer.parseInt(s[2]);
			arr[X].add(new Node(Y,K));//�߰�(����)ǰ X�� ����µ� Y�� K�� �ʿ��ϴ�
			degree_x[X]++;//�⺻��ǰã���
			degree_y[Y]++;//�������Ŀ�
		}
		Queue<Node> q=new LinkedList<Node>();
		counter[N]=1;//����ǰ�� 1��
		q.add(new Node(N,1));
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			for(int i=0;i<arr[temp.num].size();i++)
			{
				Node next=arr[temp.num].get(i);
				counter[next.num]+=counter[temp.num]*next.count;
				degree_y[next.num]--;
				if(degree_y[next.num]==0)
				{
					q.add(new Node(next.num,counter[next.num]));
				}
			}
		}
		for(int i=1;i<=N-1;i++)
		{
			if(degree_x[i]==0)
			{
				System.out.println(i+" "+counter[i]);
			}
		}
	}	
}
