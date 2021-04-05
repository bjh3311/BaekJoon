import java.util.*;
import java.io.*;
public class ����_1756�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().split(" ");
		int D=Integer.parseInt(s[0]);
		int N=Integer.parseInt(s[1]);
		int[] arr=new int[D];
		s=br.readLine().split(" ");
		for(int i=0;i<D;i++)
		{
			arr[i]=Integer.parseInt(s[i]);
		}
		for(int i=1;i<D;i++)
		{
			if(arr[i]>arr[i-1])
			{
				arr[i]=arr[i-1];
			}
		}//���� �缳��
		int min=Integer.MAX_VALUE;
		s=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			int res=-1;
			int a=Integer.parseInt(s[i]);
			int left=0;
			int right=D-1;
			while(left<=right)
			{
				int mid=(left+right)/2;
				if(arr[mid]>=a)
				{
					res=mid;
					left=mid+1;
				}
				else if(arr[mid]<a)
				{
					right=mid-1;
				}
			}
			min=Math.min(res, min);//������ �������� res�� -1 �̵ǰ� min�� -1�� �ȴ�
			D=res;
		}
		System.out.println(min+1);
	}

}
