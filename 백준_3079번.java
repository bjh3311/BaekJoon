import java.util.*;
import java.io.*;
public class ����_3079�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int M=Integer.parseInt(s[1]);
		long[] time=new long[N];
		for(int i=0;i<N;i++)
		{
			time[i]=Long.parseLong(br.readLine());
		}
		Arrays.sort(time);
		long left=0;
		long right=M*time[N-1];//�ɸ��� �ð��� ���� �� �ɻ�� * M��
		long ans=Long.MAX_VALUE;
		while(left<=right)
		{
			long mid=(left+right)/2;
			long sum=0;
			for(int i=0;i<N;i++)
			{
				sum+=mid/time[i];
			}
			if(sum>=M)
			{
				right=mid-1;
				ans=Math.min(mid, ans);
			}
			else
			{
				left=mid+1;
			}
		}
		System.out.println(ans);
	}
}
