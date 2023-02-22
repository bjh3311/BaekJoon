import java.util.*;
import java.io.*;

public class 백준_20040번 {

	public static int[] parent;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int answer=0;
		String[] s=br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		parent=new int[n];
		for(int i=0;i<n;i++)
		{
			parent[i]=i;
		}
		for(int i=0;i<m;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			if(Find(a)==Find(b))
			{
				answer=i+1;
				break;
			}
			else
			{
				Union(a,b);
			}
		}
		System.out.println(answer);
	}
	public static void Union(int a,int b)
	{
		a=Find(a);
		b=Find(b);
		if(a<b)
		{
			parent[b]=a;
		}
		else
		{
			parent[a]=b;
		}
	}
	public static int Find(int a)
	{
		if(parent[a]==a)
		{
			return a;
		}
		else
		{
			return parent[a]=Find(parent[a]);
		}
	}
}
