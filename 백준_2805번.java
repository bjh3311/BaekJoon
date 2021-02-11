import java.util.Arrays;
import java.io.*;
public class 백준_2805번 {
	public static long[] arr;
	public static long result=0;
	public static long count=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
        int M=Integer.parseInt(s[1]);
		arr=new long[N];
	    s=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			arr[i]=Long.parseLong(s[i]);
		}//가지고 있는 랜선들 길이 입력
		Arrays.sort(arr);//이분 탐색을위한 정렬
		long left=1;
		long right=arr[N-1];
		long mid;
		while(left<=right)
		{
			mid=(left+right)/2;
			for(int i=0;i<N;i++)
			{
				if(arr[i]-mid>0)
				{
					count+=arr[i]-mid;
				}
			}
			if(count>=M)
			{
				if(mid>result)
				{
					result=mid;
				}
				left=mid+1;
			}
			else if(count<M)
			{
				right=mid-1;
			}
			count=0;
			
			
		}
		System.out.println(result);
		br.close();

	}

}