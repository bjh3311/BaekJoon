import java.util.*;
import java.io.*;
public class น้มุ_2268น๘ {

	public static long[] tree;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		long temp=0;
		while(Math.pow(2, temp)<N)
		{
			temp++;
		}
		int size=(int)Math.pow(2, temp+1);
		int startindex=(size/2)-1;
		tree=new long[size];
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			int c=Integer.parseInt(s[2]);
			if(a==0)
			{
				if(b>c)
				{
					sb.append(SUM(startindex+c,startindex+b)+"\n");
				}
				else
				{
					sb.append(SUM(startindex+b,startindex+c)+"\n");
				}
				
			}
			else if(a==1)
			{
				if(tree[startindex+b]==c)
				{
					continue;
				}
				MOD(startindex+b,c-(int)tree[startindex+b]);
			}
		}
		System.out.print(sb.toString());
	}
	public static long SUM(int b,int c)
	{
		long result=0;
		while(b<=c)
		{
			if(b==c)
			{
				result=result+tree[b];
				break;
			}
			if(b%2==0)
			{
				b=b/2;
			}
			else
			{
				result=result+tree[b];
				b=b+1;
				b=b/2;
			}
			if(c%2==1)
			{
				c=c/2;
			}
			else
			{
				result=result+tree[c];
				c=c-1;
				c=c/2;
			}
		}
		return result;
	}
	public static void MOD(int b,int c)
	{
		if(b==0)
		{
			return;
		}
		tree[b]=tree[b]+c;
		MOD(b/2,c);
	}
}
