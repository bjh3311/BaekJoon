package ����_1912��;
import java.util.Arrays;
import java.util.Scanner;


public class ����_1912�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int[] arr=new int[n];
		int[] dp=new int[n];//dp�� ���� �迭����
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}//�迭�� �Է�
		dp[0]=arr[0];
	    for(int i=1;i<n;i++)
		{
			if(dp[i-1]>=0)
			{
				dp[i]=arr[i]+dp[i-1];
			}// ���� ���� �ε��������� ������ �ϴ� ���ϴ°� �̵��̴�.
			else
			{
				dp[i]=arr[i];
			}//����� �ƴ϶�� ���ϴ°� �̵��̴�
			
		}
		Arrays.sort(dp);
		System.out.println(dp[n-1]);
		

	}

}
