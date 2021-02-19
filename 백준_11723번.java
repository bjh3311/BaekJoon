package 백준_11723번;
import java.util.Scanner;
import java.io.*;
public class 백준_11723번 {
	public static boolean[] visited=new boolean[21];//있으면 true
	public static StringBuilder sb=new StringBuilder();
	public static void add(int x)
	{
		visited[x]=true;
	}
	public static void remove(int x)
	{
		visited[x]=false;
	}
	public static void check(int x)
	{
		if(visited[x])
		{
			sb.append(1+"\n");
		}
		else
		{
			sb.append(0+"\n");
		}
		
	}
	public static void toggle(int x)
	{
		if(visited[x])
		{
			visited[x]=false;
		}
		else
		{
			visited[x]=true;
		}
	}
	public static void all()
	{
		for(int i=1;i<=20;i++)
		{
			visited[i]=true;
		}
	}
	public static void empty()
	{
		for(int i=1;i<=20;i++)
		{
			visited[i]=false;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int M=Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++)
		{
			String[] s=br.readLine().split(" ");
			if(s[0].equals("add"))
			{
				add(Integer.parseInt(s[1]));
			}
			else if(s[0].equals("remove"))
			{
				remove(Integer.parseInt(s[1]));
			}
			else if(s[0].equals("check"))
			{
				check(Integer.parseInt(s[1]));
			}
			else if(s[0].equals("toggle"))
			{
				toggle(Integer.parseInt(s[1]));
			}
			else if(s[0].equals("all"))
			{
				all();
			}
			else
			{
				empty();
			}
		}
		System.out.println(sb.toString());
		
		
}
}