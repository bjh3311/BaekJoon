import java.util.*;
import java.io.*;
public class ����_2343�� {

	public static int N,M;
	public static int[] arr;
	public static boolean binary(int size)
	{
		int cnt=0;
		int sum=0;
		for(int i=0;i<N;i++)
		{
			if(sum+arr[i]>size)
			{
				sum=arr[i];
				cnt++;
			}
			else
			{
				sum+=arr[i];
			}
		}
		if(cnt<M)//������� �׷��� ������ M���� �۴ٸ� mid�� ũ�⸦ �ٿ����Ѵ�
		{
			return true;
		}
		else//������� �׷��� ������ M���� ũ�ٸ� mid�� ũ�⸦ �÷����Ѵ�.
		{
			return false;
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		M=Integer.parseInt(s[1]);
		arr=new int[N];
		s=br.readLine().split(" ");
		int sum=0;
		int left=0;
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(s[i]);
			sum+=arr[i];
			if(left<arr[i])
			{
				left=arr[i];
			}
		}
		int right=sum;
		int mid=0;//��緹���� ũ��
		int answer=0;
		while(left<=right)
		{
			mid=(left+right)/2;
			if(binary(mid))
			{
				answer=mid;
				right=mid-1;
			}
			else
			{
				left=mid+1;
			}
		}
		System.out.println(answer);
	}
}
