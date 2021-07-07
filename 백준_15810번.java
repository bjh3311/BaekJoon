import java.util.*;
import java.io.*;
public class 백준_15810번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		int[] arr=new int[N];
		s=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(s[i]);
		}
		Arrays.sort(arr);
		long left=0;
		long right=(long)arr[0]*(long)M;
		while(left<=right)
		{
			long mid=(left+right)/2;
			long sum=0;
			for(int i=0;i<N;i++)
			{
				sum+=mid/(long)arr[i];

			}
			if(sum<M)//sum이 너무 크다 -> 시간을 너무 많이 줬다.
			{
				left=mid+1;
			}
			else
			{
				right=mid-1;
			}
		}
		System.out.println(left);
	}
}
