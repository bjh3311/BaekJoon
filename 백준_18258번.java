import java.util.*;
import java.io.*;
public class น้มุ_18258น๘ {

	public static int[] queue=new int[2000001];
	public static int front=0;
	public static int back=0;
	public static int size=0;
	public static StringBuilder sb=new StringBuilder();
	public static void push(int n)
	{
		queue[back]=n;
		back++;
		size++;
	}
	public static void pop()
	{
		if(size==0)
		{
			sb.append("-1"+"\n");
		}
		else
		{
			sb.append(queue[front]+"\n");
			front++;
			size--;
		}
	}
	public static void size()
	{
		sb.append(size+"\n");
	}
	public static void empty()
	{
		if(front==back)
		{
			sb.append("1\n");
		}
		else
		{
			sb.append("0\n");
		}
	}
	public static void front()
	{
		if(front==back)
		{
			sb.append("-1\n");
		}
		else
		{
			sb.append(queue[front]+"\n");
		}
	}
	public static void back()
	{
		if(front==back)
		{
			sb.append("-1\n");	
		}
		else
		{
			sb.append(queue[back-1]+"\n");
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			int N=Integer.parseInt(br.readLine());
			for(int i=0;i<N;i++)
			{
				String[] s=br.readLine().split(" ");
				if(s[0].equals("push"))
				{
					push(Integer.parseInt(s[1]));
				}
				else if(s[0].equals("pop"))
				{
				      pop();
				}
				else if(s[0].equals("size"))
				{
					size();
				}
				else if(s[0].equals("empty"))
				{
					empty();
				}
				else if(s[0].equals("front"))
				{
					front();
				}
				else if(s[0].equals("back"))
				{
					back();
				}
			}
			System.out.println(sb.toString());
			

	}

}
