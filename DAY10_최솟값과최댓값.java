import java.util.*;
import java.io.*;
public class DAY10_최솟값과최댓값 {

	public static int N;
	public static int M;
	public static int Depth;
	public static int startIndex;
	public static int[] arr_1;
	public static int[] arr_2;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		M=Integer.parseInt(s[1]);
		Depth=0;
		while(Math.pow(2, Depth)<=N)
		{
			Depth++;
		}
		arr_1=new int[(int)Math.pow(2, Depth+1)];//최솟값 트리
		arr_2=new int[(int)Math.pow(2, Depth+1)];//최댓값 트리
		startIndex=(int)Math.pow(2, Depth);
		int temp=startIndex;
		for(int i=0;i<N;i++)//값 채워넣기
		{
			arr_1[temp]=Integer.parseInt(br.readLine());
			arr_2[temp]=arr_1[temp];
			temp++;
		}
		preorder_1(1);
		preorder_2(1);//세그먼트 트리 완성
		for(int i=0;i<M;i++)
		{
			s=br.readLine().split(" ");
			int left=Integer.parseInt(s[0]);
			int right=Integer.parseInt(s[1]);
			System.out.println(query_1(left,right)+" "+query_2(left,right));
		}
	}
	public static int preorder_1(int n)
	{
		if(arr_1[n]!=0)
		{
			return arr_1[n];
		}
		else
		{
			if(n*2>=Math.pow(2, Depth+1))
			{
				return Integer.MAX_VALUE;
			}
			int temp=Math.min(preorder_1(n*2), preorder_1((n*2)+1));
			arr_1[n]=temp;
			return arr_1[n];
		}
	}
	public static int preorder_2(int n)
	{
		if(arr_2[n]!=0)
		{
			return arr_2[n];
		}
		else
		{
			if(n*2>=Math.pow(2, Depth+1))
			{
				return 0;
			}
			int temp=Math.max(preorder_2(n*2), preorder_2((n*2)+1));
			arr_2[n]=temp;
			return arr_2[n];
		}
	}
	public static int query_1(int left,int right)
	{
		left=left+startIndex-1;
		right=right+startIndex-1;
		int result=Integer.MAX_VALUE;
		while(left<=right)
		{
			if(left%2==0)
			{
				left=left/2;
			}
			else
			{
				result=Math.min(result, arr_1[left]);
				left=(left+1)/2;
			}
			if(right%2==1)
			{
				right=right/2;
			}
			else
			{
				result=Math.min(result, arr_1[right]);
				right=(right-1)/2;
			}
		}
		return result;
	}
	public static int query_2(int left,int right)
	{
		int result=Integer.MIN_VALUE;
		left=left+startIndex-1;
		right=right+startIndex-1;
		while(left<=right)
		{
			if(left%2==0)
			{
				left=left/2;
			}
			else
			{
				result=Math.max(result, arr_2[left]);
				left=(left+1)/2;
			}
			if(right%2==1)
			{
				right=right/2;
			}
			else
			{
				result=Math.max(result, arr_2[right]);
				right=(right-1)/2;
			}
		}
		return result;
	}
}
