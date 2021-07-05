import java.util.*;
import java.io.*;
public class ����_16401�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int M=Integer.parseInt(s[0]);
		int N=Integer.parseInt(s[1]);
		s=br.readLine().split(" ");
		int[] arr=new int[N];//������ ��
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(s[i]);
		}
		Arrays.sort(arr);
		int left=1;
		int right=arr[N-1];
		int ans=0;
		while(left<=right)
		{
			int mid=(left+right)/2;
			int sum=0;
			for(int i=0;i<N;i++)
			{
				sum+=arr[i]/mid;
			}
			if(sum>=M)
			{
				ans=Math.max(ans, mid);
				left=mid+1;
			}
			else
			{
				right=mid-1;
			}
		}
		System.out.println(ans);
	}
}
