import java.util.*;
import java.io.*;
public class ����_2624�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		int k=Integer.parseInt(br.readLine());
		int[][] arr=new int[k][2];
		int[] dp=new int[T+1];
		for(int i=0;i<k;i++)
		{
			String[] s=br.readLine().split(" ");
			arr[i][0]=Integer.parseInt(s[0]);//������ �ݾ�
			arr[i][1]=Integer.parseInt(s[1]);//������ ����
		}
		dp[0]=1;
		for(int i=0;i<k;i++)
		{
			for(int j=T;j>0;j--)
			{
				for(int a=arr[i][1];a>0;a--)
				{
					if(j-a*arr[i][0]>=0)
					{
						dp[j]+=dp[j-a*arr[i][0]];
					}
				}	
			}
		}
		System.out.println(dp[T]);//���� ������ ���

	}
}
