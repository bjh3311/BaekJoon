import java.util.Arrays;
import java.io.*;
public class ����_1654�� {
	public static long[] arr;
	public static int N;
	public static long result=0;
	public static long count=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int K=Integer.parseInt(s[0]);
        N=Integer.parseInt(s[1]);
		arr=new long[K];
		for(int i=0;i<K;i++)
		{
			arr[i]=Long.parseLong(br.readLine());
		}//������ �ִ� ������ ���� �Է�
		Arrays.sort(arr);//�̺� Ž�������� ����
		long left=1;
		long right=arr[K-1];
		long mid;
		while(left<=right)
		{
			mid=(left+right)/2;
			for(int i=0;i<K;i++)
			{
				count+=(arr[i]/mid);
			}
			if(count>=N)
			{
				if(mid>result)
				{
					result=mid;
				}
				left=mid+1;
			}
			else if(count<N)
			{
				right=mid-1;
			}
			count=0;
			
		}
		System.out.println(result);
		br.close();

	}

}