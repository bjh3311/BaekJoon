import java.util.*;
import java.io.*;


public class 백준_1275번 {

	public static int N;
	public static long[] arr;
	public static int size;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int Q=Integer.parseInt(s[1]);
		size=Log(N);
		arr=new long[(int)size];
		s=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			
			arr[(int)((size/2)+i)]=Integer.parseInt(s[i]);
		}
		Init(1);
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<Q;i++)
		{
			s=br.readLine().split(" ");
			int x=Integer.parseInt(s[0]);
			int y=Integer.parseInt(s[1]);
			if(x<y)
			{
				sb.append(query(x,y)+"\n");
			}
			else
			{
				sb.append(query(y,x)+"\n");
			}
			
			long a=Integer.parseInt(s[2]);
			a=a+(size/2)-1;
			int b=Integer.parseInt(s[3]);
			edit(a,b-arr[(int)a]);
		}
		System.out.println(sb.toString());
	}
	public static long Init(int index)
	{
		if(index>=size+N)
		{
			return 0;
		}
		if(arr[index]==0)
		{
			arr[index]=Init(index*2)+Init((index*2)+1);
			return arr[index];
		}
		else
		{
			return arr[index];
		}
	}
	public static long query(long left,long right)//왼쪽부터 오른쪽까지 구간 합
	{
		long temp=0;
		left=left+(size/2)-1;
		right=right+(size/2)-1;
		while(left<=right)
		{
			if(left%2==1)
			{
				temp=temp+arr[(int)left];
				left=left+1;
				left=left/2;
			}
			else
			{
				left=left/2;
			}
			if(right%2==0)
			{
				temp=temp+arr[(int)right];
				right=right-1;
				right=right/2;
			}
			else
			{
				right=right/2;
			}
		}
		return temp;
	}
	public static void edit(long index,long value)
	{
		while(index!=0)
		{
			arr[(int)index]=arr[(int)index]+value;
			index=index/2;
		}
	}
	public static int Log(int N)
	{
		int temp=0;
		while(Math.pow(2, temp)<N)
		{
			temp++;
		}
		return (int)Math.pow(2, temp+1);
	}

}
