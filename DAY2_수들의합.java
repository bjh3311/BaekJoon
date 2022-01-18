import java.util.*;
import java.io.*;
public class DAY2_수들의합 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		s=br.readLine().split(" ");
		int[] arr=new int[N+1];
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(s[i]);
		}
		int low=0;
		int high=0;
		int result=0;
		int sum=arr[0];
		while(true)
		{
			if(sum==M)
			{
				result++;
				sum=sum-arr[low];
				low++;
			}
			else if(sum<M)
			{
				high++;
				sum=sum+arr[high];
			}
			else
			{
				sum=sum-arr[low];
				low++;
			}
			if(high==N)
			{
				break;
			}
		}
		System.out.println(result);

	}

}
