import java.util.*;
import java.io.*;
public class ����_10775�� {
	public static int G,P;
	public static int result=0;
	public static int[] parents;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int G=Integer.parseInt(br.readLine());//����Ʈ ����
		int P=Integer.parseInt(br.readLine());//����� ����
		parents=new int[G+1];
		for(int i=1;i<=G;i++)
		{
			parents[i]=i;
		}
		for(int i=0;i<P;i++)
		{
			int g=Integer.parseInt(br.readLine());
			int emptyGate=find(g);
			if(emptyGate==0)//emptyGate�� 0�̶�¶��� ���̻� ���� ����Ʈ�� ���ٴ� ��
			{
				break;
			}
			result++;
			union(emptyGate,emptyGate-1);
		}
		System.out.println(result);
	}
	public static int find(int x)
	{
		if(x==parents[x])//���� x���� ���Դµ� parents[x]=x , �� x����Ʈ�� ������ ������ x����Ʈ�� �ִ´�.
		{
			return x;
		}
		return parents[x]=find(parents[x]);
	}
	public static void union(int a,int b)
	{
		a=find(a);
		b=find(b);
		if(a!=b)
		{
			parents[a]=b;
		}
	}
}
