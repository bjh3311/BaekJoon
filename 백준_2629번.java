import java.util.*;
import java.io.*;
public class ����_2629�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());//���� ����
		String[] s=br.readLine().split(" ");//���� ���Ե�
		int sum=0;
		int[] arr=new int[N];
		for(int i=0;i<N;i++)
		{
			int temp=Integer.parseInt(s[i]);
			sum=sum+temp;//���� ������
			arr[i]=temp;
		}
		boolean[] dp=new boolean[40001];
		for(int i=0;i<N;i++)
		{
			ArrayList<Integer> temp=new ArrayList<Integer>();
			temp.add(arr[i]);
			for(int j=1;j<=40000;j++)
			{
				if(dp[j])
				{
					if(arr[i]-j>0)
					{
						temp.add(arr[i]-j);
					}
					if(arr[i]+j<=sum)
					{
						temp.add(arr[i]+j);
					}
					if(j-arr[i]>0)
					{
						temp.add(j-arr[i]);
					}
				}
			}
			for(int j=0;j<temp.size();j++)
			{
				dp[temp.get(j)]=true;
			}
		}
		int ball=Integer.parseInt(br.readLine());//������ ����
		s=br.readLine().split(" ");//������ ����
		for(int i=0;i<ball;i++)
		{
			int value=Integer.parseInt(s[i]);
			if(dp[value])
			{
				System.out.print("Y ");
			}
			else
			{
				System.out.print("N ");
			}
		}
	}
}
