import java.util.*;
import java.io.*;
public class ����_1991�� {
	public static StringBuilder sb=new StringBuilder();
	public static ArrayList<Integer>[] arr;
	public static void pre(int a)
	{
		char c=(char)(a+64);
		sb.append(c);
		for(int i=0;i<arr[a].size();i++)
		{
			if(arr[a].get(i)==-1)//�ڽ� ��尡 ������ �ƹ��͵����Ѵ�
			{
				
			}
			else
			{
				pre(arr[a].get(i));
			}
		}
	}
	public static void in(int a)
	{
		char c=(char)(a+64);
		for(int i=0;i<1;i++)
		{
			if(arr[a].get(i)==-1)//�ڽ� ��尡 ������ �ƹ��͵����Ѵ�
			{
				
			}
			else
			{
				in(arr[a].get(i));
			}
		}
		sb.append(c);
		for(int i=1;i<2;i++)
		{
			if(arr[a].get(i)==-1)//�ڽ� ��尡 ������ �ƹ��͵����Ѵ�
			{
				
			}
			else
			{
				in(arr[a].get(i));
			}
		}
	}
	public static void post(int a)
	{
		char c=(char)(a+64);
		for(int i=0;i<arr[a].size();i++)
		{
			if(arr[a].get(i)==-1)//�ڽ� ��尡 ������ �ƹ��͵����Ѵ�
			{
				
			}
			else
			{
				post(arr[a].get(i));
			}
		}
		sb.append(c);
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());	
		arr=new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			arr[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<N;i++)
		{
			String[] s=br.readLine().split(" ");
			char c=s[0].charAt(0);
			int a=(int)c-64;//A�Ͻ� 1�� ��ȯ
			for(int j=1;j<3;j++)
			{
				if(!s[j].equals("."))//.�� �ƴ϶��
				{
					char temp=s[j].charAt(0);
					int b=(int)temp-64;
					arr[a].add(b);
				}
				else//.�̶�� -1�� �������ش�
				{
					arr[a].add(-1);
				}
			}
		}
		pre(1);//��Ʈ��忡�� �����Ѵ�
		System.out.println(sb.toString());
		sb.setLength(0);//�ʱ�ȭ
		in(1);
		System.out.println(sb.toString());
		sb.setLength(0);
		post(1);
		System.out.println(sb.toString());

	}

}
