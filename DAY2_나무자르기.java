import java.util.*;
import java.io.*;
public class DAY2_나무자르기 {

	public static int[] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		s=br.readLine().split(" ");
		int max=0;
		arr=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(s[i]);
			max=Math.max(max, arr[i]);
		}
		long low=0;
		long high=max;
		long mid=0;
		long result=0;
		while(true)
		{
			mid=(low+high)/2;
			long sum=calc(mid);
			if(sum==M)
			{
				result=mid;
				break;
			}
			else if(sum<M)
			{
				high=mid-1;
			}
			else
			{
				low=mid+1;
				result=mid;
			}
			if(low>high)
			{
				break;
			}
		}
		System.out.println(result);
	}
	public static long calc(long value)
	{
		long temp=0;
		for(int i=0;i<arr.length;i++)
		{
			int tree=arr[i];
			if(tree>value)
			{
				temp+=tree-value;
			}
		}
		return temp;
	}
}
