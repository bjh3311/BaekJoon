import java.util.Arrays;
import java.util.Scanner;
public class 백준_11722번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[] arr=new int[N];
		int[] dp=new int[N];//동적배열을 위한 배열선언
		for(int i=0;i<N;i++)
		{
			arr[i]=scan.nextInt();
		}
		dp[0]=1;
		for(int i=0;i<N;i++)
		{
			dp[i]=1;
		}
		for(int i=1;i<N;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[i]<arr[j])
				{
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
			
		}
		Arrays.sort(dp);
		System.out.println(dp[N-1]);

	}

}
