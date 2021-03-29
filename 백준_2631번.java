import java.util.*;
public class 백준_2631번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int[] arr=new int[N];
		int[] dp=new int[N];
		Arrays.fill(dp, 1);//1로 dp배열 초기화
		for(int i=0;i<N;i++)
		{
			arr[i]=scan.nextInt();
		}
		for(int i=1;i<N;i++)
		{
			for(int j=i-1;j>=0;j--)
			{
				if(arr[i]>arr[j])
				{
					dp[i]=Math.max(dp[i],dp[j]+1);
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(N-dp[N-1]);
		

	}

}
