import java.util.*;
import java.io.*;
public class DAY2_ºÎºÐÇÕ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int S=Integer.parseInt(s[1]);
		int[] arr=new int[N+1];
		s=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(s[i]);
		}
		int L=Integer.MAX_VALUE;
		int sum=arr[0];
		int low=0;
		int high=0;
		while(true)
		{
			if(sum>=S)
			{
				L=Math.min(L,high-low+1);
				sum=sum-arr[low];
				low++;
			}
			else
			{
				high++;
				sum=sum+arr[high];
			}
			if(high==N)
			{
				break;
			}
		}
		if(L==Integer.MAX_VALUE)
		{
			System.out.println("0");
		}
		else
		{
			System.out.println(L);
		}

	}

}
