package 백준_1912번;
import java.util.Arrays;
import java.util.Scanner;


public class 백준_1912번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int[] arr=new int[n];
		int[] dp=new int[n];//dp를 위한 배열선언
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}//배열값 입력
		dp[0]=arr[0];
	    for(int i=1;i<n;i++)
		{
			if(dp[i-1]>=0)
			{
				dp[i]=arr[i]+dp[i-1];
			}// 만약 이전 인덱스까지가 양수라면 일단 더하는게 이득이다.
			else
			{
				dp[i]=arr[i];
			}//양수가 아니라면 피하는게 이득이다
			
		}
		Arrays.sort(dp);
		System.out.println(dp[n-1]);
		

	}

}
