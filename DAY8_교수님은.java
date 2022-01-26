import java.util.*;
import java.io.*;
public class DAY8_�������� {

	public static int[] parent;
	static long [] WeightDiff;
	//WeightDiff[2]=3 �̰� parent[2]=4�̸� 2���� �θ�� 4���̰�, 4������ 3��ŭ ���̴�
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s;
		while(true)
		{
			s=br.readLine().split(" ");
			if(s[0].equals("0")&&s[1].equals("0"))
			{
				break;
			}
			int N=Integer.parseInt(s[0]);//���� ����
			int M=Integer.parseInt(s[1]);//������ ��
			parent=new int[N+1];
			for(int i=1;i<=N;i++)
			{
				parent[i]=i;//ó���� �θ�� �ڱ� �ڽ�
			}
			WeightDiff=new long[N+1];
			int a,b,w;
			for(int i=0;i<M;i++)
			{
				s=br.readLine().split(" ");
				if(s[0].equals("!"))//���Ը� ���
				{
					a=Integer.parseInt(s[1]);
					b=Integer.parseInt(s[2]);
					w=Integer.parseInt(s[3]);
					Union(a,b,w);
				}
				else//������ �����Ѵ�
				{
					a=Integer.parseInt(s[1]);
					b=Integer.parseInt(s[2]);
					if(Find(a)!=Find(b))//�θ� �ٸ��ٸ�
					{
						System.out.println("UNKNOWN");
					}
					else
					{
						System.out.println(WeightDiff[b]-WeightDiff[a]);
					}
				}
			}
			
		}
	}
	public static void Union(int a,int b,int w)
	{
		int parentA=Find(a);
		int parentB=Find(b);
		if(parentA==parentB)//���� �θ��̸� ���� ����� �ʿ䰡����
		{
			return;
		}
		WeightDiff[parentB]=WeightDiff[a]-WeightDiff[b]+w;
		parent[parentB]=parentA;

	}
	public static int Find(int a)//
	{
		if(a==parent[a])
		{
			return a;
		}
		else
		{
			int parentIndex=Find(parent[a]);
			WeightDiff[a]=WeightDiff[a]+WeightDiff[parent[a]];
			return parent[a]=parentIndex;
				
		}
	}

}
