import java.util.*;
import java.io.*;
public class ����_1477�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);//�ް��� �Լ�
		int M=Integer.parseInt(s[1]);//�� ������� �ްԼ� ����
		int L=Integer.parseInt(s[2]);//��ӵ����� ����
		int[] arr=new int[N+2];
		arr[0]=0;
		arr[N+1]=L;
		s=br.readLine().split(" ");
		for(int i=1;i<=N;i++)
		{
			arr[i]=Integer.parseInt(s[i-1]);
		}
		Arrays.sort(arr);
		int left=0;
		int right=L;
		for(int i=1;i<=N+1;i++)//�־��� ��ӵ��ο��� ���� ������ ū �� ���ϱ�
		{
			int temp=arr[i]-arr[i-1];
			right=Math.max(right, temp);
		}
		while(left<=right)
		{
			int mid=(left+right)/2;
			int sum=0;
			for(int i=1;i<=N+1;i++)
			{		
				sum+=(arr[i]-arr[i-1]-1)/mid;
			}
			if(sum>M)
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
