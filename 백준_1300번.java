import java.util.*;
import java.io.*;
public class ����_1300�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		long N=Long.parseLong(br.readLine());
		long k=Long.parseLong(br.readLine());
		long left=1;
		long right=N*N;
		long mid;
		long result=Long.MAX_VALUE;
		long count=0;
		while(left<=right)
		{
			count=0;
			mid=(left+right)/2;
			for(int i=1;i<=N;i++)
			{
				count+=Math.min(N, mid/i);
			}
			if(count>=k)//count�� ũ�ٴ� �Ҹ��� mid�� �ʹ� ũ�ٴ� �Ҹ���
			{
				right=mid-1;
				result=Math.min(mid, result);
			}
			else
			{
				left=mid+1;
			}
		}
		System.out.println(result);
	}
}
