import java.util.*;
import java.io.*;
public class DAY6_������ǥ�� {

	public static int[] parent;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		parent=new int[n+1];
		for(int i=1;i<=n;i++)
		{
			parent[i]=i;
		}//ó���� �θ�� �ڱ��ڽ�
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<m;i++)
		{
			s=br.readLine().split(" ");
			int b=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);
			if(Integer.parseInt(s[0])==0)//������
			{
				Union(b,c);
			}
			else//������������ Ȯ��
			{
				if(Find(b)==Find(c))
				{
					sb.append("YES\n");
				}
				else
				{
					sb.append("NO\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
	public static int Find(int n)//�θ�ã��
	{
		if(parent[n]==n)
		{
			return n;
		}
		else
		{
			return parent[n]=Find(parent[n]);
		}
	}
	public static void Union(int a,int b)
	{
		int temp_a=Find(a);
		int temp_b=Find(b);
		if(temp_a<temp_b)
		{
			parent[temp_b]=temp_a;
		}
		else
		{
			parent[temp_a]=temp_b;
		}
	}

}
