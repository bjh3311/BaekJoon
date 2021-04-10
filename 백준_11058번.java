import java.util.*;
public class น้มุ_11058น๘ {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		long[] dp=new long[101];
		int N=sc.nextInt();
		for(int i=0;i<=100;i++)
		{
			dp[i]=i;
		}
		for(int i=3;i<100;i++)
		{
			long a=dp[i];
			for(int j=i+3;j<=100;j++)
			{
				dp[j]=Math.max(dp[j],(j-i-2)*a +dp[i]);
			}
		}
		System.out.println(dp[N]);

	}

}
