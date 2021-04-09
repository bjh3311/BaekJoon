import java.util.*;
import java.io.*;
public class 백준_1991번 {
	public static StringBuilder sb=new StringBuilder();
	public static ArrayList<Integer>[] arr;
	public static void pre(int a)
	{
		char c=(char)(a+64);
		sb.append(c);
		for(int i=0;i<arr[a].size();i++)
		{
			if(arr[a].get(i)==-1)//자식 노드가 없으면 아무것도안한다
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
			if(arr[a].get(i)==-1)//자식 노드가 없으면 아무것도안한다
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
			if(arr[a].get(i)==-1)//자식 노드가 없으면 아무것도안한다
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
			if(arr[a].get(i)==-1)//자식 노드가 없으면 아무것도안한다
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
			int a=(int)c-64;//A일시 1로 변환
			for(int j=1;j<3;j++)
			{
				if(!s[j].equals("."))//.이 아니라면
				{
					char temp=s[j].charAt(0);
					int b=(int)temp-64;
					arr[a].add(b);
				}
				else//.이라면 -1을 대입해준다
				{
					arr[a].add(-1);
				}
			}
		}
		pre(1);//루트노드에서 시작한다
		System.out.println(sb.toString());
		sb.setLength(0);//초기화
		in(1);
		System.out.println(sb.toString());
		sb.setLength(0);
		post(1);
		System.out.println(sb.toString());

	}

}
