import java.util.Arrays;
import java.util.Scanner;
public class ����_12865�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[][] arr=new int[N][2];//�� ǰ�� ���Կ� ��ġ
		int K=scan.nextInt();
		int[] dp=new int[K+1];
		for(int i=0;i<N;i++)
		{
			arr[i][0]=scan.nextInt();//����
			arr[i][1]=scan.nextInt();//��ġ
		}
		for(int i=0;i<N;i++)
		{
			for(int j=K;j-arr[i][0]>=0;j--)
			{
				dp[j]=Math.max(dp[j], dp[j-arr[i][0]]+arr[i][1]);
			}
			
		}
		Arrays.sort(dp);
		System.out.println(dp[K]);
		

	}

}

