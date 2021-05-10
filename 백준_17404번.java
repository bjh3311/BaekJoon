import java.util.*;
import java.io.*;
public class ����_17404�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] arr=new int[N][3];
		int[][][] dp=new int[N][3][3];
		//ù��° �ε����� ���°������,2��°�� ù������ ����,3��°�� ù��°�� �̿��� ������ �ǹ�
		String[] s;
		for(int i=0;i<N;i++)
		{
			s=br.readLine().split(" ");
			for(int j=0;j<3;j++)
			{
				arr[i][j]=Integer.parseInt(s[j]);
			}
		}
		dp[1][0][0]=Integer.MAX_VALUE;//ù°���� �����̸� ��°���� ������ ���� ���Ѵ�.
		dp[1][0][1]=arr[0][0]+arr[1][1];
		dp[1][0][2]=arr[0][0]+arr[1][2];
		dp[1][1][1]=Integer.MAX_VALUE;//ù������ �ʷ��̸� �Ѥ����� �ʷ��� ���� ���Ѵ�.
		dp[1][1][0]=arr[0][1]+arr[1][0];
		dp[1][1][2]=arr[0][1]+arr[1][2];
		dp[1][2][2]=Integer.MAX_VALUE;//ù°���� �Ķ��̸� �Ѥ����� �Ķ��� ���� ���Ѵ�.
		dp[1][2][0]=arr[0][2]+arr[1][0];
		dp[1][2][1]=arr[0][2]+arr[1][1];
		for(int i=2;i<N-1;i++)
		{
			for(int j=0;j<3;j++)
			{
				dp[i][j][0]=arr[i][0]+Math.min(dp[i-1][j][1],dp[i-1][j][2]);
				dp[i][j][1]=arr[i][1]+Math.min(dp[i-1][j][0],dp[i-1][j][2]);
				dp[i][j][2]=arr[i][2]+Math.min(dp[i-1][j][0],dp[i-1][j][1]);
			}
		}
		dp[N-1][0][0]=Integer.MAX_VALUE;//ù°���� �����̸� ���������� ������ ������.
		dp[N-1][0][1]=arr[N-1][1]+Math.min(dp[N-2][0][0], dp[N-2][0][2]);
		dp[N-1][0][2]=arr[N-1][2]+Math.min(dp[N-2][0][0], dp[N-2][0][1]);
		dp[N-1][1][1]=Integer.MAX_VALUE;//ù°���� �ʷ��̸� ���������� �ʷ��� ������
		dp[N-1][1][0]=arr[N-1][0]+Math.min(dp[N-2][1][1], dp[N-2][1][2]);
		dp[N-1][1][2]=arr[N-1][2]+Math.min(dp[N-2][1][0], dp[N-2][1][1]);
		dp[N-1][2][2]=Integer.MAX_VALUE;//ù������ �Ķ��̸� ���������� �Ķ��� ������.
		dp[N-1][2][0]=arr[N-1][0]+Math.min(dp[N-2][2][1], dp[N-2][2][2]);
		dp[N-1][2][1]=arr[N-1][1]+Math.min(dp[N-2][2][0], dp[N-2][2][2]);
		int result=Integer.MAX_VALUE;
		for(int i=0;i<3;i++)//�ּҰ�ã��
		{
			for(int j=0;j<3;j++)
			{
				
				result=Math.min(result, dp[N-1][i][j]);
			}
		}
		System.out.println(result);
	}
}
